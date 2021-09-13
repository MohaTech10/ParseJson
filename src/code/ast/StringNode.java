package code.ast;

public class StringNode extends ValueNode {
    String value;
    protected StringNode(String value) {
        super(ValueKind.STRING);
        this.value = value;
    }
}
