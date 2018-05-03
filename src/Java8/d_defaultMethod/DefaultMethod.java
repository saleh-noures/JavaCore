package Java8.d_defaultMethod;


/*
 * Java 8 introduces Default Method or (Defender methods) new feature, which allows developer to add new methods
 * to the interfaces without breaking the existing implementation of these interface. It provides flexibility to allow
 * interface define implementation which will use as default in the situation where a concrete class fails to provide
 * an implementation for that method
 * An implementing class can override the default implementation provided by the interface
 */

/*
 * When to Use Default Method Over Abstract Classes
 * Abstract class can define constructor. They are more structured and can have a state associated with them.
 * While in contrast, default method can be implemented only in the terms of invoking other interface methods,
 * with no reference to a particular implementation's state.
 */

@FunctionalInterface
interface Executable {
    void execute();
    default void cancelExecute() {
        System.out.println("Execution has been canceled");
    }
}

/* https://dzone.com/articles/interface-default-methods-java */
public class DefaultMethod {
    public static void main(String[] args) {
        Executable command = () -> System.out.println("Command is executing ...");
        command.execute();
        command.cancelExecute();
    }
}
