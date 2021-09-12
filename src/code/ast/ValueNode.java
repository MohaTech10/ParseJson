package code.ast;

public abstract class ValueNode {
    public enum ValueKind {
        STRING,
        NUMBER,
        BOOLEAN,
        OBJECT,
        ARRAY
    }

    ValueKind kind;

    public ValueNode(ValueKind kind) {
        this.kind = kind;
    }
}
