package Questions.DP_15;

import java.util.Arrays;

public class Tushar_BirthDay {
    public static void main(String[] args) {
       int[] A ={2, 4, 6};
       int[] B ={2, 1, 3};
       int[] C ={2, 5, 3};
        int maxEle=FindMax(A);
        int N=B.length;
        int[][]dp=new int[N+1][maxEle+1];
        for(int i=0;i<N;i++)
            Arrays.fill(dp[i],Integer.MAX_VALUE/2);
        BuildDp(maxEle,B,C,N,dp);
        int ans=0;
        for(int i=0;i<A.length;i++)
            ans+=dp[N][A[i]];
        System.out.println(ans);
    }
    static void BuildDp(int maxCap,int[]capacity,int[]costs,int N,int[][]dp){
        for(int j=0;j<=maxCap;j++){
            for(int i=1;i<=N;i++){
                if(j==0)
                    dp[i][j]=0;
                else if(j>=capacity[i-1])
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-capacity[i-1]]+costs[i-1]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
    }
    static int FindMax(int[]a){
        int max=a[0];
        for(int x:a)
            max=Math.max(max,x);
        return max;
    }
}
