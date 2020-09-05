package Questions.DP_15;

public class MaxSumWithoutAdj {
    public static void main(String[] args) {
        int[][] a= {{1},
                    {2}};
        int[]ans=new int[a[0].length];
        for(int i=0;i<a[0].length;i++)
            ans[i]=Math.max(a[0][i],a[1][i]);
        System.out.println(maxSumSubsequence(ans));
    }
    static int maxSumSubsequence(int []a){
        for(int i=2;i<a.length;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<=i-2;j++){
                max=Math.max(max,a[j]);
            }
            a[i]=max+a[i];
        }
        int ans=Integer.MIN_VALUE;
        for(int x:a)
            ans=Math.max(x,ans);
        return ans;
    }
}
