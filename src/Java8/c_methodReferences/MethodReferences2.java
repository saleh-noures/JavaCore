package Java8.c_methodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Reference to an instance method of a particular object*/
public class MethodReferences2
{
	public static void main(String[] args)
	{
		List<String> namesList = Arrays.asList("Saleh","Omar","Adam");
		NamesPrinter namesPrinter = new NamesPrinter();
		TextOperation textOpr = new TextOperation();

		System.out.println("===========Using Anynomous Inner Class=========");
		namesPrinter.print(namesList, new NamesOperation(){
			@Override
			public List<String> execute(List<String> list) {
				return textOpr.toLowerCaseText(list);
			}
		});

		System.out.println("===========Using a lambda expression=========");
		namesPrinter.print(namesList, l->textOpr.toUpperCaseText(l));

		System.out.println("===========Using Method References================");
		namesPrinter.print(namesList, textOpr::toLowerCaseText);
	}
}

class NamesPrinter
{
	public void print(List<String> list, NamesOperation nameOpr)
	{
		List<String> newList = nameOpr.execute(list);
		newList.forEach(System.out::println);
	}
}

@FunctionalInterface
interface NamesOperation
{
	List<String> execute(List<String> list);
}

class TextOperation
{
	public List<String> toUpperCaseText(List<String> list)
	{
		List<String> UpperCaseList = new ArrayList<>();
		for (String name : list)
		{
			UpperCaseList.add(name.toUpperCase());
		}
		return UpperCaseList;
	}

	public List<String> toLowerCaseText(List<String> list)
	{
		List<String> UpperCaseList = new ArrayList<>();
		for (String name : list)
		{
			UpperCaseList.add(name.toLowerCase());
		}
		return UpperCaseList;
	}
}


