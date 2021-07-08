package util;

import java.util.HashMap;
import java.util.Map;

public final class TestContext {

    private static ThreadLocal<Map<ContextKey, Object>> context = new ThreadLocal<>();

    private TestContext() {
    }

    public static void resetContext() {
        context.set(new HashMap<>());
    }

    public static void setContext(ContextKey key, Object value) {
        context.get().put(key, value);
    }

    public static <T> T getContext(ContextKey key) {
        return (T) context.get().get(key);
    }

}
