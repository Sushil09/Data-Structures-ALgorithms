package Questions.DP_15;

class Solution {
    static int knapsack(int W, int val[], int wt[]) {
        int N = val.length;
        int[][]dp = new int[N+1][W+1];
        
        for(int i=0 ;i<=N;i++)
            for(int j=0;j<=W;j++)
                dp[i][j]=-1;
                
        // return knapsackUtil(wt,val,W,N,dp);
        return knapsackUtilTopDown(wt,val,W,N,dp);
    }
    
    private static int knapsackUtil(int []wt, int[]val, int W, int N, int[][]dp) {
        if(W<=0 || N<=0)
            return dp[N][W] = 0;
        
        if (dp[N][W] != -1)
            return dp[N][W];
        
        if (wt[N-1]<=W) 
            return dp[N][W] = Math.max(val[N-1] + knapsackUtil(wt,val,W-wt[N-1],N-1,dp),
                                        knapsackUtil(wt,val,W,N-1,dp));
        
        else
            return dp[N][W] = knapsackUtil(wt,val,W,N-1,dp);
    }
    
    private static int knapsackUtilTopDown(int []wt, int[]val, int W, int N, int[][]dp) {
        for(int i=0;i<=N;i++) {
            for(int j=0;j<=W;j++) {
                if(i==0 || j==0)
                    dp[i][j]=0;
                else{
                    if(wt[i-1] <=j){
                        dp[i][j] = Math.max(val[i-1] + dp[i-1][j-wt[i-1]],dp[i-1][j]);
                    }else
                        dp[i][j]=dp[i-1][j];
                }    
            }
        }
        return dp[N][W];
    }
}
