package code.ast;

public class StringNode extends ValueNode {
    String value;
    public StringNode(String value) {
        super(ValueKind.STRING);
        this.value = value;
    }
}
