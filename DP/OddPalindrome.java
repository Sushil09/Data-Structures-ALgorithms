package Questions.DP_15;

public class OddPalindrome {
    public static void main(String[] args) {
        String s="xyzx";
        int[]ans=oddPalin(s);
        for(int x:ans)
            System.out.print(x+" ");
    }
    static int[] oddPalin(String s){
        int N=s.length();
        String s1=s;
        String s2=new StringBuffer(s).reverse().toString();
        int[][]dp=new int[N+1][N+1];
        for(int i=0;i<=N;i++)
            dp[i][0]=1;
        for(int i=0;i<=N;i++)
            dp[0][i]=1;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++){
                    if(s1.charAt(i-1)==s2.charAt(j-1))
                        dp[i][j]=dp[i-1][j]+dp[i][j-1];
                    else
                        dp[i][j]=dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1];
                }
            }
        int[]ans=new int[N];
        ans[0]=1;
        for(int i=1;i<N;i++){
            ans[i]=dp[i][N-i-1];
        }
        return ans;
    }
}
