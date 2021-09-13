package code.ast;

public class NullValue extends ValueNode {
    protected NullValue() {
        super(ValueKind.NULL);
    }
}
