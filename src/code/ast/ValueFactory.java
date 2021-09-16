package code.ast;

public class ValueFactory {

    private ValueFactory() { }

    public static ValueNode create(/*ValueNode.ValueKind kind,*/ String value) {

        if (Utility.isNullString(value))
            return new NullNode();
        else if (Utility.isBoolString(value))
            return new BoolNode(value);
        else if (Utility.isNumeric(value))
            return new NumberNode(value);

        // Well, We can take the advantage of knowing jsonValue ahead of time
        // if not boolString and not numerical value, then it's string, or null as Object & Array not handled here
        return new StringNode(value);
    }
}
