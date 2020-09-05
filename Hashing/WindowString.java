package Questions.Hashing_7;

import java.util.HashMap;
import java.util.Map;

public class WindowString {
    public static void main(String[] args) {
        String A="ADOBECODEBANC";
        String B="ABC";
        System.out.println(minLength(A,B));
    }
    static String minLength(String A,String B){
        Map<Character,Integer> map=new HashMap<>();
        for(char x:B.toCharArray())
            map.put(x,map.getOrDefault(x,0)+1);
        int minLength=Integer.MAX_VALUE;
        int start=0,end=0,j=0,i=0,count=map.size();
        while (j<A.length()){
            if(map.containsKey(A.charAt(j))) {
                map.put(A.charAt(j), map.get(A.charAt(j)) - 1);
                if (map.get(A.charAt(j)) == 0)
                    count--;
            }
            while (i<j && count==0){
                if(minLength>j-i+1){
                    start=i;end=j+1;minLength=j-i+1;
                }
                if(map.containsKey(A.charAt(i))){
                    map.put(A.charAt(i),map.get(A.charAt(i))+1);
                    if(map.get(A.charAt(i))>0)
                        count++;
                }
                i++;
            }
            j++;
        }
        return minLength==Integer.MAX_VALUE?"":A.substring(start,end);
    }
}
