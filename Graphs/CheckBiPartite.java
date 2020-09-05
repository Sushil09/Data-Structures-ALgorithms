package Questions.Graphs_16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckBiPartite {
    public static void main(String[] args) {
        int[][]a={{0,1}};
        int V=3;
        ArrayList<ArrayList<Integer>> G=createGraph(a,V);
        System.out.println(isBipartite(G,V));
    }
    static boolean isBipartite(ArrayList<ArrayList<Integer>> G,int V){
        int[]colors=new int[V+1];
        Arrays.fill(colors,-1);
        for(int i=1;i<=V;i++){
            if(colors[i]==-1){
                if(!isBipartiteUtil(G,V,i,colors))
                    return false;
            }
        }
        return true;
    }
    static boolean isBipartiteUtil(ArrayList<ArrayList<Integer>> G,int V,int src,int[] colors){
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
                else if(colors[neighbours]==colors[u])
                    return false;
            }
        }
        return true;
    }
    static ArrayList<ArrayList<Integer>> createGraph(int[][]a,int V){
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
