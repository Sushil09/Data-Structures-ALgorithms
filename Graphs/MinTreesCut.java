package Questions.Graphs_16;

import Questions.Pair_;

import java.util.LinkedList;
import java.util.Queue;

public class MinTreesCut {
    public static void main(String[] args) {
        int[][] a = {{2, 1, 1},
                {0, 1, 1},
                {1, 0, 1}};
        System.out.println(minTime(a));
    }

    static int minTime(int[][] a) {
        int N = a.length, M = a[0].length;
        int[] Xi = {-1, 1, 0, 0};
        int[] Yj = {0, 0, -1, 1};
        Queue<Pair_> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] == 2)
                    q.add(new Pair_(i, j));
            }
        }
        int time = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            time++;
            for (int i = 0; i < size; i++) {
                Pair_ t = q.poll();
                int x1 = (Integer) t.first;
                int y1 = (Integer) t.second;
                for (int ii = 0; ii < 4; ii++) {
                    if (isValid(a, x1 + Xi[ii], y1 + Yj[ii], N, M)) {
                        a[x1 + Xi[ii]][y1 + Yj[ii]] = 2;
                        q.add(new Pair_(x1 + Xi[ii], y1 + Yj[ii]));
                    }
                }
            }
        }
        if(isLeft(a,N,M))
            return -1;
        return time;
    }

    static boolean isValid(int[][] a, int i, int j, int N, int M) {
        return i >= 0 && j >= 0 && i < N && j < M && a[i][j] >0;
    }

    static boolean isLeft(int[][] a, int N, int M) {
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (a[i][j] == 1) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }
}
