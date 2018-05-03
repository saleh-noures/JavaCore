package Java8.c_methodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@FunctionalInterface
interface NamesOperationsExecutable {
    List<String> execute(List<String> list);
}

/*Reference to an instance method of a particular object*/
public class MethodReferences2 {
    public static void main(String[] args) {

        List<String> namesList = Arrays.asList("Saleh", "Omar", "Adam");
        NamesOperations namesOperations = new NamesOperations();

        System.out.println("===========Using Anynomous Inner Class=========");
        namesOperations.print(namesList, new NamesOperationsExecutable() {
            @Override
            public List<String> execute(List<String> list) {
                return namesOperations.toLowerCaseText(list);
            }
        });

        System.out.println("===========Using a lambda expression=========");
        namesOperations.print(namesList, l -> namesOperations.toUpperCaseText(l));

        System.out.println("===========Using Method References================");
        namesOperations.print(namesList, namesOperations::toLowerCaseText);
    }
}

class NamesOperations {
    public void print(List<String> list, NamesOperationsExecutable namesOperation) {
        List<String> newList = namesOperation.execute(list);
        newList.forEach(System.out::println);
    }

    public List<String> toUpperCaseText(List<String> list) {
        List<String> UpperCaseList = new ArrayList<>();
        for (String name : list) {
            UpperCaseList.add(name.toUpperCase());
        }
        return UpperCaseList;
    }

    public List<String> toLowerCaseText(List<String> list) {
        List<String> UpperCaseList = new ArrayList<>();
        for (String name : list) {
            UpperCaseList.add(name.toLowerCase());
        }
        return UpperCaseList;
    }
}

