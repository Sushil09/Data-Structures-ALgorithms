package Questions.DP_15;

public class MaxNonContigSubArray {
    public static void main(String[] args) {
        int[]a={1, 2, 3};
        System.out.println(maxSum(a));
    }
    static int maxSum(int[]a){
        int N=a.length;
        if(N==1)
            return a[0];
        int t1=a[0],t2=Math.max(a[0],a[1]);
        int ans=0;//Math.max(t1,t2);
        for(int i=2;i<N;i++){
            ans=Math.max(t1+a[i],t2);
            t1=t2;
            t2=ans;
        }
        return ans;
    }
}
