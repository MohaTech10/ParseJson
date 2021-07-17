package parserdev.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class JsonObject extends LinkedHashMap<String, Object> {
    public JsonObject(int initialCapacity, float loadFactor) {
        super(initialCapacity, loadFactor);
    }

    public JsonObject(int initialCapacity) {
        super(initialCapacity);
    }

    public JsonObject() {
    }

    public JsonObject(Map<? extends String, ?> m) {
        super(m);
    }

    public JsonObject(int initialCapacity, float loadFactor, boolean accessOrder) {
        super(initialCapacity, loadFactor, accessOrder);
    }
}
