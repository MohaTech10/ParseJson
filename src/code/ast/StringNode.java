package code.ast;

import code.visitor.ValueVisitor;

public class StringNode extends ValueNode {
    String value;
    protected StringNode(String value) {
        super(ValueKind.STRING);
        this.value = value;
    }

    @Override
    public ValueNode accept(ValueVisitor visitor) {
        return visitor.visit(this); // this is the fixed node;
    }
}
