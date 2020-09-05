package Questions.Graphs_16;

import Questions.Pair_;

import java.util.LinkedList;
import java.util.Queue;

public class BlackShapes {
    public static void main(String[] args) {
       char[][]x={{'X','X','X'},{'X','X','X'},{'X','X','X'}};
        int N=x.length;
        int M=x[0].length;
        int count=0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(x[i][j]=='X'){
                    count++;
                    BFS(x,i,j,N,M);
                }
            }
        }
        System.out.println(count);
    }
    static void BFS(char[][]x,int i,int j,int N,int M){
        int[] kI={-1,0,1,0};
        int[] kJ={0,1,0,-1};
        Queue<Pair_> q=new LinkedList<>();
        q.add(new Pair_(i,j));
        x[i][j]='0';
        while(!q.isEmpty()){
            Pair_ p=q.poll();
            int first=(Integer) p.first;
            int second=(Integer) p.second;
            x[first][second]='0';
            for(int y=0;y<4;y++){
                if(isSafe(x,first+kI[y],second+kJ[y],N,M)){
                    x[first+kI[y]][second+kJ[y]]=0;
                    q.add(new Pair_(first+kI[y],second+kJ[y]));
                }
            }
        }
    }
    static boolean isSafe(char[][]A,int i,int j,int N,int M){
        return i>=0 && i<N && j>=0 && j<M && (A[i][j]=='X');
    }

}
