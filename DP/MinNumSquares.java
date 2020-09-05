package Questions.DP_15;

public class MinNumSquares {
    public static void main(String[] args) {
        int A=3;
        System.out.println(MinSquares(A));
    }
    static int MinSquares(int A){
        int[]dp=new int[A+1];
        for(int i=0;i<=A;i++)
            dp[i]=i;
        for(int i=1;i<=A;i++){
            for(int j=1;j*j<=i;j++){
                dp[i]=Math.min(dp[i],1+dp[i-j*j]);
            }
        }
        return dp[A];
    }
}
