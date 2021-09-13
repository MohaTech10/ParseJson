package code.ast;

class Utility {

    private Utility() {}

    public static boolean isBoolString(String str) {
        return str.equals("true") || str.equals("false");  // TODO: Better .ignoreUpperLower
    }
    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
    public static boolean isNullString(String str) {
        return str == null;
    }
}
public class ValueFactory {

    private ValueFactory() { }

    public static ValueNode create(/*ValueNode.ValueKind kind,*/ String value) {

        if (Utility.isNullString(value))
            return new NullValue();
        if (Utility.isBoolString(value))
            return new BoolNode(value);
        if (Utility.isNumeric(value))
            return new NumberNode(value);

        // Well, We can take the advantage of knowing jsonValue ahead of time
        // if not boolString and not numerical value, then it's string, or null as Object & Array not handled here
        return new StringNode(value);
    }
}
