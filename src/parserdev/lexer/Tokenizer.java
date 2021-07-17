package parserdev.lexer;

import java.util.ArrayList;

interface GenericLexer {
    boolean advance();
    void lex();
    void lexString();
    void lexNumber();

}
public class Tokenizer implements GenericLexer {

    private int idx;
    private ArrayList<Token> tokens;
    private char currentChar;
    private final String src;
    private boolean lexerError;

    public Tokenizer(String src) {
        this.src = src;
        tokens = new ArrayList<>();
        advance();
        lex();
    }

    @Override
    public boolean advance() {
        if (idx < src.length()) {
            currentChar = src.charAt(idx++);
            return true;
        }
        currentChar = '\0';
        return false;
    }

    @Override
    public void lex() {
        while (currentChar != '\0') {
            if (Character.isWhitespace(currentChar)) {
                advance();
            }
            else if (currentChar == '{') {
                tokens.add(new Token(Token.TokenType.OPEN_BRACE, "{"));
                advance();
            } else if (currentChar == '}') {
                tokens.add(new Token(Token.TokenType.CLOSE_BRACE, "}"));
                advance();
            } else if (Character.isJavaIdentifierStart(currentChar)) {
                lexString();
            } else if (Character.isDigit(currentChar)) {
                lexNumber();
            } else if (currentChar == ':') {
                tokens.add(new Token(Token.TokenType.COLON, ":"));
                advance();
            } else if (currentChar == ',') {
                tokens.add(new Token(Token.TokenType.COMMA, ","));
                advance();
            } else {
                lexerError = true;
                advance();
                break;
            }
        }

    }

    @Override
    public void lexString() {
        final var buffer = new StringBuffer();
        while (Character.isJavaIdentifierPart(currentChar) && currentChar != '\0') {
            buffer.append(currentChar);
            advance();
        }
        if (buffer.toString().equals("true") || buffer.toString().equals("false"))
            tokens.add(new Token(Token.TokenType.BOOLEAN, buffer.toString()));
        else
            tokens.add(new Token(Token.TokenType.STRING, buffer.toString()));
    }

    @Override
    public void lexNumber() {
        final var buffer = new StringBuffer();
        while (Character.isDigit(currentChar) && currentChar != '\0') {
            buffer.append(currentChar);
            advance();
        }
        tokens.add(new Token(Token.TokenType.NUMBER, buffer.toString()));
    }


    public ArrayList<Token> getTokens() {
        return tokens;
    }

    public static void main(String[] args) {
        var lexer = new Tokenizer("{dev:10}");
        System.out.println(lexer.tokens);
    }
}
