package Questions.Recursion_And_BackTracking_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PhoneDictionary {
    static Map<Integer,String> map;
    public static void main(String[] args) {
        String numbers="234";
        map=new HashMap<>();
        map.put(0,"0");map.put(1,"1");map.put(2,"abc");map.put(3,"def");map.put(4,"ghi");map.put(5,"jkl");map.put(6,"mno");map.put(7,"pqrs");map.put(8,"tuv");map.put(9,"wxyz");
        ArrayList<String> ans=new ArrayList<>();
        generateDictionary(ans,numbers,"");
        for(String x:ans)
            System.out.print(x+" ");
    }
    static void generateDictionary(ArrayList<String> ans,String s,String combined) {
        if (s.length() == 0) {
            ans.add(combined);
            return;
        }
        else {
            int x = Integer.parseInt(s.substring(0, 1));
            String p = map.get(x);
            for (int i = 0; i < p.length(); i++) {
                String a = p.substring(i, i + 1);
                generateDictionary(ans, s.substring(1), combined + a);
            }
        }
    }
}
