package Questions.Graphs_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MaxNodesBipartite {
    public static void main(String[] args) {
        int[][]a={{1,3},
                  {1,4},
                  {3,2},
                  {3,5}};
        int V=5;
        int src=a[0][0];
        ArrayList<ArrayList<Integer>> G=createGraph(a,V);
        int[]colors=new int[V+1];
        Arrays.fill(colors,-1);
        colors[0]=-2;
        makeBipartite(G,V,src,colors);
        int zeros=0,ones=0;
        for(int i=1;i<=V;i++){
            if(colors[i]==0)
                zeros++;
            if(colors[i]==1)
                ones++;
        }
        System.out.println(zeros*ones - a.length);
    }
    static void makeBipartite(ArrayList<ArrayList<Integer>> G,int V,int src,int[] colors){
        colors[src]=1;
        Queue<Integer> q=new LinkedList<>();
        q.add(src);
        while (!q.isEmpty()){
            int u=q.poll();
            for(int neighbours:G.get(u)){
                if(colors[neighbours]==-1){
                    colors[neighbours]=1-colors[u];
                    q.add(neighbours);
                }
            }
        }
    }
    static ArrayList<ArrayList<Integer>> createGraph(int[][]a, int V){
        ArrayList<ArrayList<Integer>> G=new ArrayList<>();
        for(int i=0;i<=V;i++)
            G.add(new ArrayList<>());
        for(int i=0;i<a.length;i++){
            int u=a[i][0],v=a[i][1];
            G.get(u).add(v);
            G.get(v).add(u);
        }
        return G;
    }
}
