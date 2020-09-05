package Questions.DP_15;

public class PartyCouples {
    static int[]dp;
    public static void main(String[] args) {
        int A=17;
        System.out.println(MinWays(A));
    }
    static int MinWays(int A){
        dp=new int[A+1];
        dp[0]=0;
        dp[1]=1;dp[2]=2;
        for(int i=3;i<=A;i++)
            dp[i]=dp[i-1]+(i-1)*dp[i-2];
        return dp[A];
    }
}
