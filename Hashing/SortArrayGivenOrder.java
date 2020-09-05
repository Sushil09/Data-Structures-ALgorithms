package Questions.Hashing_7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortArrayGivenOrder {
    static Map<Integer,Integer> map=new HashMap<>();
    public static void main(String[] args) {
        int[]a={1,2,3,4,5};
        int[]b={5,4,2};
        for(int i=0;i<b.length;i++)
            map.put(b[i],i);
//        Arrays.sort(a,new MyComparator implements Comparator<Integer>{
//            public int compare(Integer i1,Integer i2){
//                if(map.containsKey(i1) && !map.containsKey(i2))
//                    return -1;
//                else if(map.containsKey(i2) && !map.containsKey(i1))
//                    return 1;
//                else if(map.containsKey(i2) && map.containsKey(i1))
//                    return map.get(i1)-map.get(i2);
//                else
//                    return -1;
//            }
//        });
        for(int x:a)
            System.out.print(x+" ");
    }

}
