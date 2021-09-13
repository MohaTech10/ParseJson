package code.parse;

import code.ast.*;
import code.lexer.Token;
import code.lexer.Tokenizer;

public class JsonParser {

    // Fixme: Assumption we have Lexer , Don't forget to implement one later;


    Tokenizer lexer;
    int idx = 0;
    Token skipped, currentToken;
    public JsonParser(String src) {
        lexer = new Tokenizer(src);
        advance();
    }

    // Todo: rename it
    boolean check(Token.TokenType tokenType) {
        return tokenType == currentToken.getTokenType();
    }

    // it is optional token advancement;  var x : int = 10;  var y = 10;
    boolean consumeIf(Token.TokenType tokenType) {
        if (check(tokenType)) {
            advance();
            return true;
        }
        return false;
    }

    // Eat otherwise parser error;
    boolean eat(Token.TokenType tokenType) {
        if (check(tokenType)) {
            advance();
            return true;
        } else {
            // TODO: 7/13/21 Throw parser error;
            System.err.println("Expected: " + tokenType + " but Got " + currentToken);
        }
        return false;
    }
    boolean eatNoAdvance(Token.TokenType tokenType) {
        if (check(tokenType)) {
            return true;
        }
        System.err.println("Expected: " + tokenType + " but Got " + currentToken);
        return false;
    }

    boolean advance() {
        /*lexer.nextToken()*/
        if (idx < lexer.getTokens().size()) {
            skipped = currentToken;
            currentToken = lexer.getTokens().get(idx++);
            return true;
        }
        return false;
    }
    public Root parseRoot() {
        Root root = null;
        if (consumeIf(Token.TokenType.L_BRACE)) {
            if (check(Token.TokenType.R_BRACE)) {  // Case1: Empty json feed
                // Empty
            } else {  // Have single or more jsonData
                root = new Root(parseObject());
                eat(Token.TokenType.R_BRACE);
            }
        } else if (consumeIf(Token.TokenType.L_BRACKET)) {
            if (check(Token.TokenType.R_BRACKET)) {  // Case1: Empty json feed
                // Empty
            } else {  // Have single or more jsonArrayData
                root = new Root(parseArray());
                eat(Token.TokenType.R_BRACKET);
            }
        }
        return root; // FIXME: check & see empty classRoot, OR null , invalid start. etc..
    }

    private ObjectNode parseObject() {
        var object = new ObjectNode();
        while (true) {
            eat(Token.TokenType.STRING);   // must have a key first in json
            var key = skipped.getStringValue();  // get the key
            eat(Token.TokenType.COLON); // TODO: Wire colon to key, As we have a key in object must have colon & Value;
            switch (currentToken.getTokenType()) {
                case STRING -> object.push(new PropertyNode(key, new StringNode(currentToken.getStringValue())));
                case BOOLEAN -> object.push(new PropertyNode(key, new BoolNode(currentToken.getStringValue())));
                case NUMBER -> object.push(new PropertyNode(key, new NumberNode(currentToken.getStringValue())));
                case L_BRACE -> {
                    advance();
                    object.push(new PropertyNode(key, parseObject()));
                    eatNoAdvance(Token.TokenType.R_BRACE);
                }
//                case L_BRACKET -> {
//                    advance();
//                    object.push(new PropertyNode(key, parseArray()));
//                    eat(Token.TokenType.R_BRACKET);
//                }
                default -> System.out.println("ValueError: Unexpected value type. Valid Value: (Boolean, String, Number, Object, Array)");
            }
            advance();
            if (!consumeIf(Token.TokenType.COMMA)) break;

        }
        return object;
    }

    private ArrayNode parseArray() {
        var array = new ArrayNode();
        while (true) {
            switch (currentToken.getTokenType()) {
                case STRING -> array.push(new StringNode(currentToken.getStringValue()));
                case BOOLEAN -> array.push(new BoolNode(currentToken.getStringValue()));
                case NUMBER -> array.push(new NumberNode(currentToken.getStringValue()));
            }
            advance();
            if (!consumeIf(Token.TokenType.COMMA)) break;
        }

        return array;
    }


    public static void main(String[] args) {
        var parser = new JsonParser("/Users/engmoht/IdeaProjects/ParseJson/src/code/example/json_example.text");
        System.out.println(parser.parseRoot());
    }
}