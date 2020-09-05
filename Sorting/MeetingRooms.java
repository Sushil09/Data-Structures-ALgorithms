package Questions.Sorting_5;

import java.util.*;

public class MeetingRooms {
    public static void main(String[] args) {
        int[][]a={{1,18},
                  {18,23},
                  {15,29},
                  {4,15},
                  {2,11},
                  {5,13}};
        System.out.println(minRooms(a));
    }
    static int minRooms(int[][]a){
        int N=a.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<N;i++){
            if(!map.containsKey(a[i][0]))
                map.put(a[i][0],0);
            map.put(a[i][1],1);
        }
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<N;i++){
            al.add(a[i][0]);
            al.add(a[i][1]);
        }
        Collections.sort(al);
        int c=0,ans=Integer.MIN_VALUE;
        for(int x:al){
            if(map.get(x)==0)
                c++;
            else
                c--;
            ans=Math.max(c,ans);
        }
        return ans;
    }
}
