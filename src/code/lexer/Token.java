package code.lexer;

final public class Token {

    public enum TokenType {
        ID, STRING, BOOLEAN, COLON, COMMA, NUMBER, R_BRACE, L_BRACE, L_BRACKET, R_BRACKET;
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
