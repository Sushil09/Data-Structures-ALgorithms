package Questions.DP_15;

public class CoinChange2 {
    public static void main(String[] args) {
        int []a={1, 2, 3};
        int K=4;
//        System.out.println(minWays(a,K));
        System.out.println(TwoDWay(a,K));
    }
    //O(N) way
    static int MOD=(int)(1E6+7);
    static int minWays(int[]a,int K){
        int N=a.length;
        int []dp=new int[K+1];
        dp[0]=1;
        for(int i=0;i<N;i++){
            for(int j=a[i];j<=K;j++){
                    dp[j]=(dp[j]%MOD+dp[j-a[i]]%MOD)%MOD;
            }
        }
        return dp[K]%MOD;
    }
    static int TwoDWay(int[]a,int K){
        int N=a.length;
        int [][]dp=new int[N+1][K+1];
        for(int i=0;i<=N;i++)
            dp[i][0]=1;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=K;j++){
                if(j>=a[i-1]){
                    dp[i][j]=dp[i-1][j]+dp[i][j-a[i-1]];
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[N][K];
    }
}
