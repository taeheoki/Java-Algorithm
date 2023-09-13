package src.week_37;

import java.lang.reflect.*;
import java.util.*;

interface TestInterface {
    int calculate(int a, int b);
    String calculate(String a, String b);
    String getValue();
}

public class MockLibrary implements InvocationHandler {
    private Map<String, Map<List<Object>, Object>> mockMethods = new HashMap<>();
    private String lastMethodKey;
    private List<Object> lastArgs;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        List<Object> argList = args != null ? Arrays.asList(args) : Collections.emptyList();
        Map<List<Object>, Object> methods = mockMethods.get(method.getName());
        if (methods != null && methods.containsKey(argList)) {
            return methods.get(argList);
        } else {
            throw new IllegalArgumentException("Method with provided arguments is not registered");
        }
    }

    public MockLibrary when(String methodName, Object[] args) {
        this.lastMethodKey = methodName;
        this.lastArgs = args != null ? Arrays.asList(args) : Collections.emptyList();

        if (!mockMethods.containsKey(methodName)) {
            mockMethods.put(methodName, new HashMap<>());
        }

        return this;
    }

    public void thenReturn(Object result) {
        if (lastMethodKey != null && lastArgs != null) {
            mockMethods.get(lastMethodKey).put(lastArgs,result);
            // reset
            lastMethodKey = null;
            lastArgs = null;
        } else {
            throw new IllegalStateException("Must call when() before calling thenReturn()");
        }
    }

    public static void main(String[] args) {
        MockLibrary handler = new MockLibrary();
        TestInterface ref = (TestInterface) Proxy.newProxyInstance(
                MockLibrary.class.getClassLoader(),
                new Class[]{TestInterface.class}, handler);

        handler.when("calculate", new Object[] {1, 2}).thenReturn(3);
        handler.when("calculate", new Object[] {"a", "b"}).thenReturn("ab");

        handler.when("getValue", null).thenReturn("mocked value");

        System.out.println(ref.calculate(1, 2)); // prints 3
        System.out.println(ref.calculate("a", "b")); // prints "ab"

        System.out.println(ref.getValue());
    }
}
