package Questions.Graphs_16;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class IsConnectedS2D {
    static boolean[] visited;
    public static void main(String[] args) {
        int D=5;
        visited=new boolean[D+1];
        int[][]E={{1,2},
                  {2,3},
                  {3,4},
                  {4,5 } };
        int S=1;
        ArrayList<ArrayList<Integer>> G=prepareAdjList(E,D);
        System.out.println(isPossibleBFS(G,S,D));
        System.out.println(isPossibleDFS(G,S,D));
    }
    static boolean isPossibleBFS(ArrayList<ArrayList<Integer>> G,int S,int D ){
        boolean[]visited=new boolean[D+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(S);
        while(!q.isEmpty()){
            int x=q.peek();
            q.poll();
            for(int r:G.get(x)){
                if(!visited[r]){
                    visited[r]=true;
                    q.add(r);
                }
            }
        }
        return visited[D];
    }
    static boolean isPossibleDFS(ArrayList<ArrayList<Integer>> G ,int S,int D){
        if(S==D)
            return true;
            for(int x:G.get(S)){
                if(!visited[x]){
                    visited[x]=true;
                    return isPossibleDFS(G,x,D);
                }
            }
        return false;
    }
    static ArrayList<ArrayList<Integer>> prepareAdjList(int[][]E,int D){
        ArrayList<ArrayList<Integer>> G=new ArrayList<>();
        for(int i=0;i<=D;i++)
            G.add(new ArrayList<>());
        for(int i=0;i<E.length;i++){
            int x=E[i][0];
            int y=E[i][1];
            G.get(x).add(y);
        }
        return G;
    }
}
