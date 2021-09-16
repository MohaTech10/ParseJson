package code.ast;

// RootClass Declaration
public class Root {

    private final JsonRoot ast;
    public enum RootKind {
        ARRAY, OBJECT;
    }

    private final RootKind rootKind;
    public Root(JsonRoot ast  /*RootKind kind*/) {
        this.ast = ast;
        // FIXME
        if (ast instanceof ArrayNode)
            rootKind = RootKind.ARRAY;
        else rootKind = RootKind.OBJECT;
    }

    public JsonRoot getAst() {
        return ast;
    }

    public RootKind getRootKind() {
        return rootKind;
    }


    @Override
    public String toString() {
        return "Root{" +
                "jsonRoot=" + ast +
                '}';
    }
}
