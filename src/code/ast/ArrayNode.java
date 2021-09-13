package code.ast;

import java.util.List;
public class ArrayNode extends ValueNode implements JsonRoot<ValueNode> {

    List<ValueNode> elements;
//    private boolean heterogeneous;  // Array of mix type, False by default;

    public ArrayNode() {
        super(ValueKind.ARRAY);
    }

    @Override
    public boolean push(ValueNode element) {
        return elements.add(element);
    }

//    public boolean isHeterogeneous() {
//        return heterogeneous;
//    }
//
//    public void confirmHeterogeneous() {
//        this.heterogeneous = true;
//    }
}
