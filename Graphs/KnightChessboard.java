package Questions.Graphs_16;

import Questions.Pair_;

import java.util.LinkedList;
import java.util.Queue;

public class KnightChessboard {
    public static void main(String[] args) {
        int rows=8,columns=8;
        int[][]board=new int[rows][columns];
        int[] src={1,1};
        int des[]={8,8};
        System.out.println(findMin(board,src,des,rows,columns));
    }
    static int findMin(int[][] board,int []src,int[]des,int rows,int columns){
        int[] possX={-2,-2,-1,1,2,2,-1,-1};
        int[] possY={-1,1,2,2,1,-1,2,2};
        int sx=src[0]-1,sy=src[1]-1;
        int dx=des[0]-1,dy=des[1]-1;
        int minSteps=0;
        Queue<Pair_> q=new LinkedList<>();
        q.add(new Pair_(sx,sy));
        board[sx][sy]=-1;
        while (!q.isEmpty()) {
            int size=q.size();
            minSteps++;
            for (int x = 0; x < size; x++) {
                Pair_ p = q.poll();
                int xx = (Integer) p.first;
                int yy = (Integer) p.second;
                if (xx == dx && yy == dy)
                    return minSteps-1;
                for (int i = 0; i < 8; i++) {
                    if (isValid(board, xx + possX[i], yy + possY[i], rows, columns)) {
                        board[xx + possX[i]][yy + possY[i]] = -1;
                        q.add(new Pair_(xx + possX[i], yy + possY[i]));
                    }
                }
            }
        }
        return -1;
    }
    static boolean isValid(int[][]board,int i,int j,int N,int M){
        return i<N && j<M && i>=0 && j>=0 && board[i][j]==0;
    }
}
