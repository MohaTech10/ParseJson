package code.ast;

public class NumberNode extends ValueNode {

    String value;
    protected NumberNode(String value) {
        super(ValueKind.NUMBER);
        this.value = value;
    }
}
