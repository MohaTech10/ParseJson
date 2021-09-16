package code.ast;

import code.visitor.ValueVisitor;

import java.util.ArrayList;
import java.util.List;

// This construct introduces a new class declaration;
// So when Visiting we check currentNode is object? create class and loop through its elements, as propertis, and so on;
// One Possible mmore info we need parent? yes maybe;
public class ObjectNode extends ValueNode implements JsonRoot<PropertyNode> {

    /*ValueNode parent?*/

    private List<PropertyNode> elems;

    public ObjectNode() {
        super(ValueKind.OBJECT);
        elems = new ArrayList<>();
    }

    public boolean push(PropertyNode element) { return elems.add(element); }

    @Override
    public List<PropertyNode> elements() {
        return elems;
    }

    @Override
    public String toString() {
        return "ObjectNode{" +
                "elements=" + elems +
                '}';
    }

    @Override
    public ValueNode accept(ValueVisitor visitor) {
        return visitor.visit(this);
    }
}
