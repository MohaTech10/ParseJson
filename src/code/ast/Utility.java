package code.ast;

public class Utility {

    private Utility() { }

    public static boolean isBoolString(String str) {
        return str.equals("true") || str.equals("false");  // TODO: Better .ignoreUpperLower
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    public static boolean isNullString(String str) {
        return str.equals("null");
    }
}
