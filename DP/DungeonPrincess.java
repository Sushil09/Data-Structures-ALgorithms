package Questions.DP_15;

public class DungeonPrincess {
    public static void main(String[] args) {
        int[][]a={{1, -1, 0},
                  {-1, 1, -1},
                  {1, 0, -1}
                 };
        System.out.println(minHealth(a));
    }
    static int minHealth(int[][]a){
        int N=a.length;
        int M=a[0].length;
        int[][]dp=new int[N+1][M+1];
        for(int i=0;i<=N;i++)
            dp[i][M]=Integer.MAX_VALUE;

        for(int i=0;i<=M;i++)
            dp[N][i]=Integer.MAX_VALUE;
        for(int i=N-1;i>=0;i--){
            for(int j=M-1;j>=0;j--){
                if(i==N-1 && j==M-1){
                    dp[i][j]=a[i][j]<0?Math.abs(a[i][j])+1:1;
                }
                else{
                    dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])-a[i][j];
                    if(dp[i][j]<=0)
                        dp[i][j]=1;
                }
            }
        }
        return dp[0][0];
    }
}
