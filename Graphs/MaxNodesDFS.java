package Questions.Graphs_16;

import java.util.ArrayList;

public class MaxNodesDFS {
    static int[]colors;
    public static void main(String[] args) {
        int[][]a={{1,3},
                {1,4},
                {3,2},
                {3,5}};
        int V=5;
        ArrayList<ArrayList<Integer>> G=createGraph(a,V);
        colors=new int[2];
        dfs(G,1,0,0);
        long ans=colors[0]*colors[1];
        ans-=V-1;
        System.out.println(ans);
    }
    static void dfs(ArrayList<ArrayList<Integer>> G,int src,int parent,int c){
        colors[c]++;
        for(int x:G.get(src)){
            if(x!=parent){
                dfs(G,x,src,1-c);
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
