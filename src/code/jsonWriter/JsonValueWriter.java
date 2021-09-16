package code.jsonWriter;

import code.ast.Root;

// This can be the caller of WriterVisitor.
// Also called after parsing immediately.
public final class JsonValueWriter {
    public static void endJsonParsing(Root json) {
        var ast = json.getAst();
        switch (json.getRootKind()) {
            case ARRAY: break;
            case OBJECT: break;
        }

    }
}
