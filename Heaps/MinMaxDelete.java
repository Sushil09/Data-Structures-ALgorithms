package Questions.Heaps_14;

import java.util.HashMap;
import java.util.Map;

public class MinMaxDelete {
    public static void main(String[] args) {
        int[]a={1, 1, 2, 2, 2, 3, 1};
        System.out.println(MaxDistinct(a));
    }
    static int MaxDistinct(int[]a){
        Map<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<a.length;i++)
            hm.put(a[i],hm.getOrDefault(a[i],0)+1);
        int countTwos=0;
        for(Map.Entry entries:hm.entrySet()){
            if((Integer)entries.getValue()>1 && (Integer)entries.getValue()%2!=0)
                hm.put((Integer)entries.getKey(),1);
            else if((Integer)entries.getValue()%2==0){
                hm.put((Integer) entries.getKey(), 2);
                countTwos++;
            }
        }
        if(countTwos%2==0)
            return hm.size();
        else
            return hm.size()-1;
    }
}
