package Questions.DP_15;

public class UniquePathsInGrids {
    public static void main(String[] args) {
        //numPaths is 2-d arrays with 1 as blocker and 0 as valid cells
    }
    static int numPaths(int[][] A){
        int[][]dp=new int[A.length+1][A[0].length+1];
        dp[1][1]=1;
        for(int i=1;i<=A.length;i++){
            for(int j=1;j<=A[0].length;j++){
                if(A[i-1][j-1]==1)
                    dp[i][j]=0;
                else
                    dp[i][j]+=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[A.length][A[0].length];
    }
}
