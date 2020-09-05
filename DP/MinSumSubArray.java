package Questions.DP_15;

public class MinSumSubArray {
    public static void main(String[] args) {
        int[]a={8, 4, 5};
        int sum=0;
        for(int x:a)
            sum+=x;
        int minSum=calcMin(a,sum);
        int minEle=calcMinEleReq(a,minSum);
        System.out.println(minEle);
    }
    static int calcMin(int []a,int sum){
        int n=a.length;
        boolean[][]dp=new boolean[n+1][sum+1];
        for(int i=0;i<=n;i++)
            dp[i][0]=true;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=sum;j++){
                if(j>=a[i-1])
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-a[i-1]];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        int diff=Integer.MAX_VALUE;
        for(int j=sum/2;j>=0;j--){
            if(dp[n][j]){
                diff=j;
                break;
            }
        }
        return diff;
    }
    static int calcMinEleReq(int []a,int minSum){
        int n=a.length;
        int[][]dp=new int[n+1][minSum+1];
        for(int j=1;j<=minSum;j++)
            dp[0][j]=Integer.MAX_VALUE/2;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=minSum;j++){
                if(j>=a[i-1])
                    dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-a[i-1]]+1);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][minSum];
    }
}
//https://codeforces.com/blog/entry/43256
//https://naman.dev/caesars-legions-codeforces.html