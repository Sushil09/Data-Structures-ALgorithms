package Questions.Graphs_16;

import Questions.Pair_;
import Questions.Trees_11.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {
    public static void main(String[] args) {
        int[][]A={{1,1,0,0,0},
                  {0,1,0,0,0},
                  {1,0,0,1,1},
                  {0,0,0,0,0},
                   {1,0,1,0,1}};
        int N=A.length;
        int M=A[0].length;
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(A[i][j]==1){
                    count++;
                    BFS(A,i,j,N,M);
                }
            }
        }
        System.out.println(count);
    }
    static void BFS(int[][]A,int i,int j,int N,int M){
        int[] kI={-1,-1,-1,0,0,1,1,1};
        int[] kJ={0,-1,1,-1,1,1,0,-1};
        Queue<Pair_> q=new LinkedList<>();
        q.add(new Pair_(i,j));
            A[i][j]=0;
            while(!q.isEmpty()){
                Pair_ p=q.poll();
                int first=(Integer) p.first;
                int second=(Integer) p.second;
                A[first][second]=0;
                for(int x=0;x<8;x++){
                    if(isSafe(A,first+kI[x],second+kJ[x],N,M)){
                        A[first+kI[x]][second+kJ[x]]=0;
                        q.add(new Pair_(first+kI[x],second+kJ[x]));
                    }
                }
            }
    }
    static boolean isSafe(int[][]A,int i,int j,int N,int M){
        return i>=0 && i<N && j>=0 && j<M && (A[i][j]==1);
    }
}
