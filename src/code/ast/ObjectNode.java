package code.ast;

import java.util.ArrayList;
import java.util.List;

// This construct introduces a new class declaration;
// So when Visiting we check currentNode is object? create class and loop through its elements, as propertis, and so on;
// One Possible mmore info we need parent? yes maybe;
public class ObjectNode extends ValueNode implements JsonRoot<PropertyNode> {

    /*ValueNode parent?*/

    List<PropertyNode> elements;

    public ObjectNode() {
        super(ValueKind.OBJECT);
        elements = new ArrayList<>();
    }

    public boolean push(PropertyNode element) { return elements.add(element); }

    @Override
    public String toString() {
        return "ObjectNode{" +
                "elements=" + elements +
                '}';
    }
}
