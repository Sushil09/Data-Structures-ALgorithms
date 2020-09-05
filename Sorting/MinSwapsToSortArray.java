package Questions.Sorting_5;

import java.util.HashMap;
import java.util.Map;

public class MinSwapsToSortArray {
    public static void main(String[] args) {
        int[]a={7,3,4,6,2,1,0,5};
        System.out.println(minJumps(a));
    }
    static int minJumps(int[]a){
        int count=0;
        int N=a.length;
        boolean[]visited=new boolean[N];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++)
            map.put(a[i],i);
        for(int i=0;i<N;i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (i == map.get(i))
                    continue;
                else {
                    int p = map.get(i);
                    while (!visited[p]) {
                        visited[p] = true;
                        count++;
                        p = map.get(p);
                    }
                }
            }
        }
        return count;
    }
}
