package Questions.DP_15;

public class Longest_Repeating_SubSeq {
    public static void main(String[] args) {
        String s="abba";
        System.out.println(longSubSeq(s,s));
    }
    static int longSubSeq(String A,String B){
        int[][]dp=new int[A.length()+1][B.length()+1];
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(A.charAt(i-1)==B.charAt(j-1) && i!=j)
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[A.length()][B.length()];
    }
}
