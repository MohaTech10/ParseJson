package code.ast;

public class NumberNode extends ValueNode {

    String value;
    public NumberNode(String value) {
        super(ValueKind.NUMBER);
        this.value = value;
    }
}
