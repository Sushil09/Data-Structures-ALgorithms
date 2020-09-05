package Questions.Graphs_16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    public static void main(String[] args) {
        int V=8;
        int[][]edges={{1,4},{1,2},{4,2},{4,3},{3,2},{5,2},{3,5},{8,2},{8,6}};
        int[]indegree=new int[V+1];
        ArrayList<ArrayList<Integer>> G=makeAdjlist(edges,indegree,V);
//        System.out.println(detectCycle(G,indegree,V));
        int [] ans=detectCycle(G,indegree,V);
        for(int x:ans)
            System.out.print(x+" ");
        System.out.println();
    }
    static ArrayList<ArrayList<Integer>> makeAdjlist(int[][]edges,int[]indegree,int V){
        ArrayList<ArrayList<Integer>> G=new ArrayList<>();
        int N=edges.length;
    for(int i=0;i<=V;i++)
            G.add(new ArrayList<>());
        for(int i=0;i<N;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            G.get(u).add(v);
            indegree[v]++;
        }
        return G;
    }
    static int[] detectCycle(ArrayList<ArrayList<Integer>> G,int[]indegree,int V){
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        boolean[]visited=new boolean[V+1];
        for(int i=1;i<=V;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        while (!q.isEmpty()){
            int curr=q.poll();
            if(!visited[curr]){
                ans.add(curr);
                visited[curr]=true;
            }
            for(int neighbours:G.get(curr)){
                indegree[neighbours]--;
                if(indegree[neighbours]==0){
                    ans.add(neighbours);
                    visited[neighbours]=true;
                    q.add(neighbours);
                }
            }
        }
        int[]answer=new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            answer[i]=ans.get(i);
        return answer;
//        for(int x:ans)
//            System.out.print(x+" ");
//        System.out.println();
//        if(ans.size()==V)
//            return false;
//        return true;
    }
}
