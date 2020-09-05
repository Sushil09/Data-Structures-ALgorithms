package Questions.DP_15;

public class Valueable_Nodes {
    public static void main(String[] args) {
        int[] A={1, 50, 3, 4};
        if(A.length<3)
            System.out.println(maxEle(A));
        else
        System.out.println(maxSum(A));
    }
    static int maxSum(int[]a){
        int N=a.length;
        int[]dp=new int[N];
        dp[0]=a[0];dp[1]=a[1];dp[2]=a[2];
        for(int i=3;i<N;i++)
            dp[i]=Math.max(dp[i-3]+a[i],dp[i-1]);
        return maxEle(dp);
    }
    static int maxEle(int[]a){
        int max=a[0];
        for(int x:a)
            max=Math.max(x,max);
        return max;
    }
}
