class Solution {
    public int cutRod(int[] price) {
        int size = price.length;
        int[][] dp = new int[size+1][size+1];
        
        for(int[]arr:dp)
            java.util.Arrays.fill(arr,-1);
        return cutRodUtil(price,size,size,dp);    
        
    }
    
    private static int cutRodUtil(int[]arr, int N, int K,int[][]dp) {
        if(N<=0 || K<=0)
            return 0;
        
        if(dp[N][K]!=-1)
            return dp[N][K];
            
        if(arr[N-1]<=K)
            return dp[N][K] = Math.max(cutRodUtil(arr,N,K-N,dp)+arr[N-1],
                                        cutRodUtil(arr,N-1,K,dp));
        else
            return dp[N][K] = cutRodUtil(arr,N-1,K,dp);
    }
}
