package Questions.DP_15;

public class MinSumPath {
    public static void main(String[] args) {
        int[][]a={{1,3,2},
                 {4,3,1},
                 {5,6,1},
                 };
        System.out.println(MinSumPath(a));
    }
    static int MinSumPath(int[][]a){
        int N=a.length,M=a[0].length;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(i==0 && j==0)
                    continue;
                else if(i==0)
                    a[i][j]+= a[i][j-1];
                else if(j==0)
                    a[i][j]+= a[i-1][j];
                else
                    a[i][j]+=Math.min(a[i-1][j],a[i][j-1]);
            }
        }
        return a[N-1][M-1];
    }
}
