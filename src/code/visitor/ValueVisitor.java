package code.visitor;

import code.ast.*;

public interface ValueVisitor {
    ValueNode visit(ObjectNode objectNode);
    ValueNode visit(ArrayNode arrayNode);
    ValueNode visit(StringNode stringNode);
    ValueNode visit(NumberNode numberNode);
    ValueNode visit(BoolNode boolNode);
    ValueNode visit(NullNode nullNode);
}
