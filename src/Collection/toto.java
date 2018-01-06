package Collection;

import java.util.HashMap;
import java.util.Map;

public class toto {

	public static void main(String[] args) {

		// initial a Map
		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "Jan");
		map.put("2", "Feb");
		map.put("3", "Mar");
		map.put("4", "Apr");
		map.put("5", "May");
		map.put("6", "Jun");

		// more elegant way, this should be the standard way, recommend!
		System.out.println("\nExample 2...");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}


		String number = "10";
		Integer result = Integer.valueOf(number);
		System.out.println(result);

		//System.out.println(map.toString());

		Box<Integer, String > b3 = new Box<>(3,"Box3");
		System.out.println("saleh123".hashCode());



	}

}