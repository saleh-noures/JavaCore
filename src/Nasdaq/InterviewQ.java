package Nasdaq;

import java.util.HashMap;
import java.util.Map;

public class InterviewQ {

    public static void main(String[] args) {

        Map<String, int []> stockList =  new HashMap<>();

        stockList.put("StkId11", new int [] {1,2});
        stockList.put("StkId22", new int [] {4,4});
        stockList.put("StkId33", new int [] {1,5});
        stockList.put("StkId44", new int [] {7,8});

        Map<String, int []> m = new HashMap<>();

        m.put("a",new int[]{1,2});
        m.put("b",new int[]{3,4});

        System.out.println(m.get("a")[1]);

    }
}
