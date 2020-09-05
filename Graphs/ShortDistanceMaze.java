package Questions.Graphs_16;

import Questions.Pair_;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortDistanceMaze {
    public static void main(String[] args) {
        int[][] a = {{0, 0, 0},
                    {0, 0, 0},
                    {1, 1, 1},
                    {0, 0, 1},
                    {1, 1, 1},
                    {1, 0, 0},
                    {1, 1, 0},
                    {0, 0, 1},
                    {0, 1, 0},
                    {0, 1, 0}
        };
        int N = a.length, M = a[0].length;
        int[] source = {5, 1};
        int[] destination = {9,0};
        System.out.println(shortestDis(a, source, destination, N, M));
    }

    static int shortestDis(int[][] a, int[] src, int[] des, int N, int M) {
//        int[][] temp=new int[N][M];
//        for(int i=0;i<N;i++)
//            Arrays.fill(temp[i],Integer.MAX_VALUE);
        int sx=src[0],ex=src[1],dx=des[0],dy=des[1];
        Queue<Pair_> q = new LinkedList<>();
        q.add(new Pair_(src[0], src[1]));
        int[] xi = {-1, 1, 0, 0};
        int[] yi = {0, 0, -1, 1};
        int level = 0;
        while (!q.isEmpty())  {
            int size = q.size();
            level++;
            for (int i = 0; i < size; i++) {
                Pair_ temp_ = q.poll();
                int x = (Integer) temp_.first;
                int y = (Integer) temp_.second;
                if (x == des[0] && y == des[1])
                    return level-1;
                for (int j = 0; j < 4; j++) {
                    if (isValid(a, x + xi[j], y + yi[j], N, M,des)) {
                        a[x + xi[j]][y + yi[j]]=1;
                        q.add(new Pair_(x + xi[j], y + yi[j]));
                    }
                }
            }
        }
        return -1;
    }
    static boolean isValid(int[][] a, int i, int j, int N, int M,int []des) {
        return (i >= 0 && j >= 0 && i < N && j < M && a[i][j] == 0) || (i==des[0] && j==des[1]);
    }
}

