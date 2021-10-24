package HackerRank;

//https://www.hackerrank.com/challenges/maximum-element/problem
//My rank 592,336
import java.util.*;

public class HR16_MaximumElement {

    public static void main(String[] args) {
        List<String> ops= new ArrayList<>();
        Scanner  in = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Enter n:");
        int n  = in.nextInt();

        System.out.println("Enter Operations:");
        for (int i = 0; i < n; i++) {
            ops.add(in.next());
        }

        getMax(ops).stream().forEach(System.out::println);
    }

    public static List<Integer> getMax(List<String> operations) {
        Stack<Integer> s = new Stack<>();
        List<Integer> maxList = new ArrayList<>();
        TreeMap<Integer,Integer> maxMap = new TreeMap<>();

        operations.stream().forEach(i->{


            if( i.startsWith("1"))
            {
                int elm = Integer.parseInt(i.substring(2));
                s.push(elm);
                updateMaxMap(maxMap,elm,1);

            }
            else if (i.equalsIgnoreCase("2"))
            {
                int elm = s.pop();
                updateMaxMap(maxMap,elm,2);
            }
            else if (i.equalsIgnoreCase("3"))
            {
                    maxList.add(maxMap.lastEntry().getKey());
            }

        });

          return maxList;
    }

    public static void updateMaxMap(TreeMap<Integer,Integer> maxMap,int elm, int opr){

        if(opr == 1)
        {
            if (maxMap.get(elm) == null)
                maxMap.put(elm,1);
            else {
                int elmValue = maxMap.get(elm);
                maxMap.put(elm, elmValue + 1);
            }
        } else if (opr == 2){
            if(maxMap.get(elm) == 1)
                maxMap.remove(elm);
            else{
                int elmValue = maxMap.get(elm);
                maxMap.put(elm, elmValue - 1);
            }

        }

    }

}
// Another solution using 2 stacks
/*    while(sc.hasNext())
    {
        String type[] = sc.nextLine().split(" ");
        switch(type[0])
        {
            case "1":
                temp = Integer.parseInt(type[1]);
                stack.push(temp);
                if(onlyMaxs.isEmpty() || onlyMaxs.peek() <= temp)
                    onlyMaxs.push(temp);
                break;
            case "2":
                temp = stack.pop();
                if(temp == onlyMaxs.peek())
                    onlyMaxs.pop();
                break;
            case "3":
                System.out.println(onlyMaxs.peek());
        }
        N--;
    }*/





