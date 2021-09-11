package parserdev.ast;

import java.util.List;
public class ArrayNode extends ValueNode implements JsonRoot {

    List<ValueKind> elements;
    public ArrayNode() {
        super(ValueKind.ARRAY);
    }
}
