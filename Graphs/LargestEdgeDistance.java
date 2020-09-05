package Questions.Graphs_16;

import Questions.Pair_;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LargestEdgeDistance {
    public static void main(String[] args) {
        int[]a={-1,0};
        ArrayList<ArrayList<Integer>> G=getAdjList(a);
        Pair_ firstCall=getLargestDistance(G,0);
        Pair_ secondCall=getLargestDistance(G,(Integer) firstCall.first);
        System.out.println(secondCall.second);
    }
    static Pair_ getLargestDistance(ArrayList<ArrayList<Integer>> G,int S){
        int V=G.size();
        int level=0;
        int lastVisited=0;
        boolean[] visited=new boolean[V];
        visited[S]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(S);
        while (!q.isEmpty()){
            int size=q.size();
            level++;
            for(int i=0;i<size;i++){
                int temp=q.poll();
                lastVisited=temp;
                for(int x:G.get(temp)){
                    if(!visited[x]){
                        visited[x]=true;
                        q.add(x);
                    }

                }
            }
        }
        return new Pair_(lastVisited,level-1);
    }

    static ArrayList<ArrayList<Integer>> getAdjList(int[]a){
        ArrayList<ArrayList<Integer>> G=new ArrayList<>();
        int N=a.length;
        for(int i=0;i<N;i++)
            G.add(new ArrayList<>());
        for(int i=0;i<N;i++){
            if(a[i]!=-1){
                G.get(i).add(a[i]);
                G.get(a[i]).add(i);
            }
        }
        return G;
    }
}
