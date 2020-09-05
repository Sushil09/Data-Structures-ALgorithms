package Questions.DP_15;

public class PascalMinSumPath {
    public static void main(String[] args) {
        int[][]A={{2},
                  {3,4},
                  {6,5,7},
                  {4,1,8,3}
                  };
        System.out.println(minSum(A));
    }
    static int minSum(int[][]A){
        int N=A.length,M=A[A.length-1].length;
        int [][]dp=new int[N+1][M+1];
        for(int i=0;i<N;i++){
            for(int j=0;j<A[i].length;j++)
                dp[i][j]=A[i][j];
        }
        for(int i=N-1;i>=0;i--){
            for(int j=M-1;j>=0;j--)
                dp[i][j]+=Math.min(dp[i+1][j],dp[i+1][j+1]);
        }
        return dp[0][0];
    }
}
