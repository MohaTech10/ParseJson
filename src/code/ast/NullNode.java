package code.ast;

import code.visitor.ValueVisitor;

public class NullNode extends ValueNode {
    protected NullNode() {
        super(ValueKind.NULL);
    }

    @Override
    public ValueNode accept(ValueVisitor visitor) {
        return visitor.visit(this);
    }
}
