package code.ast;

// Think if there's parent relation 'aka' Strong composition to understand which property belong to which object;
public class BoolNode extends ValueNode {

    String value;
    public BoolNode(String value) {
        super(ValueKind.BOOLEAN);
        this.value = value;
    }
}