package Java8.c_methodReferences;

/* Reference to an instance method of an arbitrary object of a particular type */

/*
 * In this case, we have a lambda expression like the following:
 * (obj, args) -> obj.instanceMethod(args)
 * Where an instance of an object is passed, and one of its methods is executed with some optional(s) parameter(s).
 * This can be turned into the following method reference:
 * ObjectType::instanceMethod
 *
 * https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
 * */

@FunctionalInterface
interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

/* This Example will read two Strings convert them into numbers then return the sum of them */
public class MethodReferences3 {
    public static void main(String[] args) {
            Sum sum = new Sum();

        System.out.println("===========Using Anynomous Inner Class=========");
        TriFunction<Sum, String, String, Integer> triFunction1 = new TriFunction<Sum, String, String, Integer>() {
            public Integer apply(Sum s, String u, String v) {
                return s.doSum(u, v);
            }
        };
        Integer num1 = triFunction1.apply(sum, "1", "2");
        System.out.println(num1.intValue());

        System.out.println("===========Using a lambda expression=========");
        TriFunction<Sum, String, String, Integer> triFunction2 = (Sum s, String y, String z) -> s.doSum(y, z);
        Integer num2 = triFunction2.apply(sum, "1", "2");
        System.out.println(num2.intValue());

        System.out.println("===========Using Method References================");
        TriFunction<Sum, String, String, Integer> triFunction3 = Sum::doSum;
        Integer num3 = triFunction3.apply(sum, "1", "2");
        System.out.println(num3.intValue());
    }
}

class Sum {
    public Integer doSum(String x, String y) {
        return new Integer(x) + new Integer(y);
    }
}