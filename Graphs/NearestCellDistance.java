package Questions.Graphs_16;

import Questions.Pair_;

import java.util.LinkedList;
import java.util.Queue;

public class NearestCellDistance {
    public static void main(String[] args) {
        int[][] a = {{0, 0, 0, 1},
                {0, 0, 1, 1},
                {0, 1, 1, 0}};
        int N = a.length, M = a[0].length;
        changeMatrix(a,N,M);
        for (int[] x : a) {
            for (int i : x)
                System.out.print(i);
            System.out.println();
        }
    }
    static void changeMatrix(int[][]a,int N,int M){
        Queue<Pair_> q=new LinkedList<>();
        int [] Xi={-1,1,0,0};
        int [] Yj={0,0,-1,1};
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)
                if(a[i][j]==1)
                    q.add(new Pair_(i,j));
        }
        while (!q.isEmpty()){
            Pair_ p=q.poll();
            int xx=(Integer) p.first;
            int yy=(Integer) p.second;
            for(int i=0;i<4;i++){
                if(isValid(a,Xi[i]+xx,Yj[i]+yy,N,M)){
                    a[Xi[i]+xx][Yj[i]+yy]=a[xx][yy]+1;
                    q.add(new Pair_(Xi[i]+xx,Yj[i]+yy));
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)
                    a[i][j]--;
        }
    }
    static boolean isValid(int[][]a,int i,int j,int N,int M){
        return i>=0 && j>=0 && i<N && j<M && a[i][j]==0;
    }
}
