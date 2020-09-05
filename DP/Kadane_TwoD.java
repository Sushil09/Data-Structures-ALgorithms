package Questions.DP_15;

public class Kadane_TwoD {
    public static void main(String[] args) {
        int[][]a={{-1}};
        System.out.println(maxSubMatrixSum(a));
    }
    static int maxSubMatrixSum(int[][]a){
        int N=a.length,M=a[0].length;
        int ans=Integer.MIN_VALUE;
        int[]temp=new int[a.length];
        for(int left=0;left<M;left++){
            for(int i=0;i<N;i++)
                temp[i]=0;
            for(int right=left;right<M;right++){
                for(int i=0;i<N;i++)
                    temp[i]+=a[i][right];
                ans=Math.max(ans,KadaneOneD(temp));
            }
        }
        return ans;
    }
    static int KadaneOneD(int[]a){
        int ans=a[0],maxSoFar=a[0];
        for(int i=1;i<a.length;i++){
            maxSoFar=Math.max(a[i],maxSoFar+a[i]);
            ans=Math.max(ans,maxSoFar);
        }
        return ans;
    }
}
