package others;

import java.util.HashMap;
import java.util.Map;

/*
    1-The block is executed only once, when the class is loaded by the JVM.
    2-Static initializers are executed before the class is used, such as before calling a static method
    or accessing a static variable.
    3-Static initializers are executed in the same order they appear in the code
*/

public class StaticInitializerExample {
    static int count;
    static String message;
    static Map<String, Integer> items;

    // Static initializer block1
    static {
        count = 5;  // Initialize the static variable
        message = "Hello, Static World!";
        System.out.println("Static initializer 1 executed: Items initialized");
    }

    // Static initializer block2
    static {
        items = new HashMap<>();
        items.put("Apples", 50);
        items.put("Oranges", 30);
        items.put("Bananas", 20);
        System.out.println("Static initializer 2 executed: Items initialized");
    }

    public static void main(String[] args) {
        System.out.println("Count: " + count + " message: " + message);
        System.out.println("Items available: " + items);
    }
}
