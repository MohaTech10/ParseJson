package parserdev.parse;

import parserdev.ast.ArrayNode;
import parserdev.ast.ObjectNode;
import parserdev.ast.Root;
import parserdev.lexer.Token;
import parserdev.lexer.Tokenizer;

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
        if (consumeIf(Token.TokenType.R_BRACE)) {
            root = new Root(parseObjRoot());  // TODO: See if parseObject is sufficient
        } else if (consumeIf(Token.TokenType.L_BRACKET)) {
            root = new Root(parseArrayRoot());  // TODO: See if parseArray is sufficient
        }
        return root; // FIXME: check & see empty classRoot, OR null , invalid start. etc..
    }

    private ObjectNode parseObjRoot() {
        return null;   // TODO: 9/11/21
    }

    private ArrayNode parseArrayRoot() {
        // TODO: 9/11/21
        return null;
    }

    // This will parse the object as object{} element not a root 'i.e' has a parent
    private void parseObject() {
//        if (check(Token.TokenType.STRING)) {
//            var jsonObject = new JsonObject();
//            do {
//                eat(Token.TokenType.STRING);
//                var key = skipped.getStringValue();
//                eat(Token.TokenType.COLON);    // { address: {} for example; }
//                switch (currentToken.getTokenType()) {
//                    case R_BRACE -> {
//                        // TODO: 7/17/21 Recursive
//                    }
//
//                    // FIXME: 7/17/21 Refactor value to parseValue
//                    case NUMBER -> {
//                        value = Integer.parseInt(currentToken.getStringValue());
//                        jsonObject.put(key, value);
//                        value = jsonObject;
//                        advance();
//                    } case BOOLEAN -> {
//                        value = Boolean.parseBoolean(currentToken.getStringValue());
//                        jsonObject.put(key, value);
//                        value = jsonObject;
//                        advance();
//                    }
//                    case STRING -> {
//                        value = currentToken.getStringValue();
//                        jsonObject.put(key, value);
//                        value = jsonObject;
//                        advance();
//                    }
//                }
//            } while (consumeIf(Token.TokenType.COMMA));
//        }
//        eat(Token.TokenType.L_BRACE);   // closing object;

    }

    // This will parse the array as[] element not a root 'i.e' has a parent
    private void parseArray() {
        // TODO: 7/13/21

    }

    private void parseValue() {
        // TODO: 7/17/21
    }


    public static void main(String[] args) {

    }
}