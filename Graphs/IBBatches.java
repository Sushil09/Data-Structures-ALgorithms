package Questions.Graphs_16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static Questions.Graphs_16.DisJointSetArray.printSets;

public class IBBatches {
    public static void main(String[] args) {
        int V = 10;
        int[] energy = {7, 9, 3, 2, 9, 1, 6, 4, 10, 8};
        int D=26;
        int[][] connections = {{1, 5},
                                {2, 6},
                                {3, 7},
                                {3, 9},
                                {3, 10},
                                {4, 5},
                                {4, 7},
                                {4, 10},
                                {5, 7},
                                {7, 9}};
        DisJointSetArray ds=new DisJointSetArray();
        int[]universe=new int[V];
        for(int i=1;i<=V;i++)
            universe[i-1]=i;
        ds.makeSet(universe);
        for(int i=0;i<connections.length;i++)
            ds.Union(connections[i][0],connections[i][1]);

//        DisJointSetArray.printSets(universe,ds);
        printSets(universe,ds);
        printSets(universe,ds);
        for(int x:universe)
            System.out.print(x+" ");
        Map<Integer, ArrayList<Integer>> map=new HashMap<>();
        for(int i=0;i<V;i++){
            if(!map.containsKey(universe[i])){
                map.put(universe[i],new ArrayList<>());
                map.get(universe[i]).add(energy[i]);
            }
            else
                map.get(universe[i]).add(energy[i]);
        }
        int count=0;
        for(Map.Entry<Integer,ArrayList<Integer>> hm:map.entrySet()){
            int cost=0;
            for(int x:hm.getValue())
                cost+=x;
            if(cost>=D)
                count++;
        }
        System.out.println(count);

    }
}
