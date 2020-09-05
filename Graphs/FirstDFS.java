package Questions.Graphs_16;

import java.util.ArrayList;
import java.util.List;

public class FirstDFS {
    static boolean[]visited;
    public static void main(String[] args) {
        int[]a={1, 1, 1, 3, 3, 4, 6, 5, 3, 3  };
        List<List<Integer>> G=new ArrayList<>();
//        int max=findMax(a);
        int N=a.length;
        visited=new boolean[N+1];
        int D=10,S=3;
        for(int i=0;i<=N+1;i++)
            G.add(new ArrayList<>());
        for(int i=1;i<N;i++)
            G.get(a[i]).add(i+1);
        System.out.println(isPossibleDFS(G,S,D));
    }
    static boolean DFS(List<List<Integer>> G,int S,int D){
        if(S==D)
            return true;
        for(int x:G.get(S)){
            if(!visited[x]){
                visited[x]=true;
                if(DFS(G,x,D))
                    return true;
            }
        }
        return false;
    }
    static boolean isPossibleDFS(List<List<Integer>> G ,int S,int D){
        if(S==D)
            return true;
        for(int x:G.get(S)){
            if(!visited[x]){
                visited[x]=true;
                if(isPossibleDFS(G,x,D))
                    return true;
            }
        }
        return false;
    }
    static int findMax(int[]a){
        int max=a[0];
        for(int x:a)
            max=Math.max(x,max);
        return max;
    }

}
