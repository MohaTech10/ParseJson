package parserdev.ast;

// RootClass Declaration
public class Root {
    private final JsonRoot jsonRoot;
    public enum RootKind {
        ARRAY, OBJECT;
    }

    private final RootKind rootKind;
    public Root(JsonRoot jsonRoot  /*RootKind kind*/) {
        this.jsonRoot = jsonRoot;
        // FIXME
        if (jsonRoot instanceof ArrayNode)
            rootKind = RootKind.ARRAY;
        else rootKind = RootKind.OBJECT;
    }
}
