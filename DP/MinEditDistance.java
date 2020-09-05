package Questions.DP_15;

public class MinEditDistance {
    public static void main(String[] args) {
        String A="Anshuman";
        String B="Antihuman";
        System.out.println(minEdit(A,B));
    }
    static int minEdit(String A,String B){
        int[][]dp=new int[A.length()+1][B.length()+1];
        for(int i=0;i<dp[0].length;i++)
            dp[0][i]=i;
        for(int i=0;i<dp.length;i++)
            dp[i][0]=i;
        for(int i=1;i<=A.length();i++){
            for(int j=1;j<=B.length();j++){
                if(A.charAt(i-1)==B.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else{
                    dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        return dp[A.length()][B.length()];
    }
}
