package parserdev.ast;

import java.util.Map;


// This construct introduces a new class declaration;
// So when Visiting we check currentNode is object? create class and loop through its elements, as propertis, and so on;
// One Possible mmore info we need parent? yes maybe;
public class ObjectNode extends ValueNode implements JsonRoot {

    /*ValueNode parent?*/
    Map<PropertyNode, ValueNode> elements;

    public ObjectNode() {
        super(ValueKind.OBJECT);
    }

}
