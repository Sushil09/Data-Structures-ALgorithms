package Questions.DP_15;

public class LCS {
    public static void main(String[] args) {
        String A="abbcdgf";
        String B="bbadcgf";
        System.out.println(longSubSeq(A,B));
    }
    
    // top down
    static int longSubSeq(String A,String B){
        int[][]dp=new int[A.length()+1][B.length()+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(A.charAt(i-1)==B.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[A.length()][B.length()];
    }

    //bottom up
    static int longSubSeqBottomUp(String A, String B, int m, int n, int[][] dp) {
        // Base case: if either string is empty, LCS length is 0
        if (m == 0 || n == 0) {
            return 0;
        }
        
        // Check if value is already computed
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        
        // If last characters match, add 1 to result and recurse for remaining substring
        if (A.charAt(m - 1) == B.charAt(n - 1)) {
            return dp[m][n] = 1 + longSubSeq(A, B, m - 1, n - 1, dp);
        } else {
            // Otherwise, take the maximum from two possible cases
            return dp[m][n] = Math.max(longSubSeq(A, B, m - 1, n, dp), longSubSeq(A, B, m, n - 1, dp));
        }
    }
}
