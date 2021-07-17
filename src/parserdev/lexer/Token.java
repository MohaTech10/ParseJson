package parserdev.lexer;

final public class Token {

    public enum TokenType {
        ID, STRING, BOOLEAN, COLON, COMMA, NUMBER, OPEN_BRACE, CLOSE_BRACE, OPEN_SQUARE, CLOSE_SQUARE;
    }

    private final TokenType tokenType;
    private final String stringValue;

    public Token(TokenType tokenType, String stringValue) {
        this.tokenType = tokenType;
        this.stringValue = stringValue;
    }

    public TokenType getTokenType() {
        return tokenType;
    }

    public String getStringValue() {
        return stringValue;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenType=" + tokenType +
                ", stringValue='" + stringValue + '\'' +
                '}';
    }
}
