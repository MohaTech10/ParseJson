package code.visitor;

import code.ast.*;
// Mainly when talking abound large software
// We need to know entry point.
public class WriterVisitor implements ValueVisitor {

    @Override
    public ValueNode visit(ObjectNode objectNode) {
        return null;
    }

    @Override
    public ValueNode visit(ArrayNode arrayNode) {
        return null;
    }

    @Override
    public ValueNode visit(StringNode stringNode) {
        return null;
    }

    @Override
    public ValueNode visit(NumberNode numberNode) {
        return null;
    }

    @Override
    public ValueNode visit(BoolNode boolNode) {
        return null;
    }

    @Override
    public ValueNode visit(NullNode nullNode) {
        return null;
    }

    public static void processEachNode() {

    }
}
