package Collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class mainClass_Map {

	public static void main(String[] args) {

		Map<String, Box<Integer,String>> boxHashMap =  new HashMap<>();
		System.out.println("Populating ('b1',(1,Box1)) ('b2',(2,Box2)) ('b3',(3,Box3)) ('b3',(3,Box3)) ('b4',(3,Box3)) (null,(4,Box4)) ('b5',(null)) ('b6',(6,Box6))  .....");
		populateMap(boxHashMap);
		System.out.println("Printing boxHashMap .....");
		printMap(boxHashMap);
		
		Map<String, Box<Integer,String>> linkedHashMap =  new LinkedHashMap<>();
		System.out.println("Populating ('b1',(1,Box1)) ('b2',(2,Box2)) ('b3',(3,Box3)) ('b3',(3,Box3)) ('b4',(3,Box3)) (null,(4,Box4)) ('b5',(null)) ('b6',(6,Box6))  .....");
		populateMap(linkedHashMap);
		System.out.println("Printing boxHashMap .....");
		printMap(linkedHashMap);
	}

	public static void populateMap(Map <String, Box<Integer,String>> boxMap)
	{
		boxMap.put("b1", new Box<>(1,"Box1"));
		boxMap.put("b2", new Box<>(2,"Box2"));
		Box<Integer, String > b3 = new Box<>(3,"Box3");
		boxMap.put("b3",b3);
		boxMap.put("b3",b3);
		boxMap.put("b4",new Box<>(3,"Box3"));
		boxMap.put(null,new Box<>(4,"Box4"));
		boxMap.put("b5", null);
		boxMap.put("b6",new Box<>(6,"Box6"));
	}

	public static void printMap(Map <String, Box<Integer,String>> boxMap)
	{
		for (Map.Entry<String, Box<Integer,String>> entry : boxMap.entrySet())
		{
			System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
		}
	}

}
