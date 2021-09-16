package code.ast;

import code.visitor.ValueVisitor;

import java.util.List;
public class ArrayNode extends ValueNode implements JsonRoot<ValueNode> {

    private List<ValueNode> elems;
//    private boolean heterogeneous;  // Array of mix type, False by default;

    public ArrayNode() {
        super(ValueKind.ARRAY);
    }

    @Override
    public boolean push(ValueNode element) {
        return elems.add(element);
    }

    @Override
    public List<ValueNode> elements() {
        return elems;
    }

    @Override
    public ValueNode accept(ValueVisitor visitor) {
        return visitor.visit(this);
    }

//    public boolean isHeterogeneous() {
//        return heterogeneous;
//    }
//
//    public void confirmHeterogeneous() {
//        this.heterogeneous = true;
//    }
}
