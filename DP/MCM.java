package Questions.DP_15;

import java.util.Arrays;

public class MCM {
    static int[][]dp=new int[1001][1001];
    public static void main(String[] args) {
        int []a={10,20,30};
        for(int[]x:dp)//filling initial values
            Arrays.fill(x,-1);
        System.out.println(minMultiply(a,1,a.length-1));
    }
    static int minMultiply(int[]a,int i,int j){
        if(i>=j)
            return 0;
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int temp;
            int left;
            if(dp[i][k]!=-1)
                left=dp[i][k];
            else{
                left=minMultiply(a,i,k);
                dp[i][k]=left;
            }
            int right;
            if(dp[k+1][j]!=-1)
                right=dp[k+1][j];
            else{
                right=minMultiply(a,k+1,j);
                dp[k+1][j]=right;
            }
            temp=left+right+a[i-1]*a[k]*a[j];
            if(ans>temp)
                ans=temp;
        }
        return dp[i][j]=ans;
    }
}
