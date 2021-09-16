package code.ast;

import code.visitor.ValueVisitor;

// Think if there's parent relation 'aka' Strong composition to understand which property belong to which object;
public class BoolNode extends ValueNode {

    String value;
    protected BoolNode(String value) {
        super(ValueKind.BOOLEAN);
        this.value = value;
    }

    @Override
    public ValueNode accept(ValueVisitor visitor) {
        return visitor.visit(this);
    }
}