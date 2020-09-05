package Questions.Graphs_16;

import Questions.Pair_;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class InfiniteKnight {
    public static void main(String[] args) {
        int x=1;
        int y=1;
        System.out.println(findMin(x,y));
    }
    static int findMin(int x,int y){
        int[] possX={-2,-2,-1,1,2, 2 ,1,-1};
        int[] possY={-1, 1, 2,2,1,-1,-2,-2};
        int sx=0,sy=0;
        int dx=x,dy=y;
        Map<Integer,Integer> map=new HashMap<>();
        int minSteps=0;
        Queue<Pair_> q=new LinkedList<>();
        q.add(new Pair_(sx,sy));
        map.put(sx,sy);
        while (!q.isEmpty()) {
            int size=q.size();
            minSteps++;
            for (int r = 0; r < size; r++) {
                Pair_ p = q.poll();
                int xx = (Integer) p.first;
                int yy = (Integer) p.second;
                if (xx == dx && yy == dy)
                    return minSteps-1;
                for (int i = 0; i < 8; i++) {
                    if (isValid(map,xx + possX[i], yy + possY[i]) && (xx + possX[i]>-1) && (yy + possY[i]>-1) ) {
                        map.put(xx + possX[i],yy + possY[i]);
                        q.add(new Pair_(xx + possX[i], yy + possY[i]));
                    }
                }
            }
        }
        return -1;
    }
    static boolean isValid(Map<Integer,Integer> map, int x, int y){
        if(!map.containsKey(x))
            return true;
        return !(map.containsKey(x) && map.get(x)==y);
    }
}
