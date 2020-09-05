package Questions.DP_15;

public class DistinctSubSequnces {
    public static void main(String[] args) {
        String A="aaaababbababbaabbaaababaaabbbaaabbb";
        String B="bbababa";
        System.out.println(distinctSubSequence(A,B));
    }
    static int distinctSubSequence(String A, String B){
        int[][]dp=new int[A.length()+1][B.length()+1];
        dp[0][0]=1;
        for(int i=0;i<A.length();i++)
            dp[i][0]=1;
        for(int i=1;i<=A.length();i++){
            for(int j=1;j<=B.length();j++){
                if(A.charAt(i-1)==B.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[A.length()][B.length()];
    }
}
