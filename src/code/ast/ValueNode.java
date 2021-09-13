package code.ast;

public abstract class ValueNode {
    public enum ValueKind {
        STRING,
        NUMBER,
        BOOLEAN,
        OBJECT,
        ARRAY,
        NULL
    }

    ValueKind kind;

    protected ValueNode(ValueKind kind) {
        this.kind = kind;
    }
}
