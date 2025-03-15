class Solution {

    static Boolean isSubsetSum(int arr[], int target) {
        int M = arr.length, N = target;
        boolean [][]dp1 = new boolean[M+1][N+1];
        int[][] dp2 = new int[M + 1][N + 1];

        for (int i = 0; i <= M; i++)
            for (int j = 0; j <= N; j++)
                dp2[i][j] = -1;

        // return isSubsetSumUtil(arr, M, target, dp2) > 0;
        return isSubsetSumUtilTopDown(arr,M,target,dp1);
    }

    private static int isSubsetSumUtil(int[] arr, int N, int K, int[][] dp) {
        // Base case: If sum K is 0, return 1 (empty subset can form sum 0)
        if (K == 0) return 1;

        // Base case: If no elements left but sum K > 0, return 0
        if (N == 0) return 0;

        // Check if already computed
        if (dp[N][K] != -1) return dp[N][K];

        // If current element is less than or equal to K, we can either take or skip it
        if (arr[N - 1] <= K) {
            return dp[N][K] = isSubsetSumUtil(arr, N - 1, K - arr[N - 1], dp) 
                            | isSubsetSumUtil(arr, N - 1, K, dp);
        } else {
            return dp[N][K] = isSubsetSumUtil(arr, N - 1, K, dp);
        }
    }
    
    private static boolean isSubsetSumUtilTopDown(int[]arr,int N, int K, boolean[][]dp) {
        
        for(int i=0;i<=N;i++)
                dp[i][0]=true;
        
        for(int i=1;i<=N;i++){
            for(int j=1;j<=K;j++) {
                if(j>=arr[i-1]) 
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[N][K];
    }
}
