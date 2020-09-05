package Questions.DP_15;

public class LPSubsequence {
    public static void main(String[] args) {
        String s="bebeeed";
        System.out.println(longestPalindromeSub(s));
    }
    static int longestPalindromeSub(String s){
        int[][]dp=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++)
            dp[i][i]=1;
        for(int outer=2;outer<=s.length();outer++){
            for(int i=0;i<s.length()-outer+1;i++){
                int j=outer+i-1;
                if(outer==2 && s.charAt(i)==s.charAt(j))
                    dp[i][j]=2;
                else if(s.charAt(i)==s.charAt(j))
                    dp[i][j]=dp[i+1][j-1]+2;
                else
                    dp[i][j]=Math.max(dp[i+1][j],dp[i][j-1]);
            }
        }
        return dp[0][s.length()-1];
    }
}
