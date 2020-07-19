package Questions.Maths_And_Arrays_1;

public class RainWaterTrapping {
    public static void main(String[] args) {
        int[]a={1,8,6,2,5,4,8,3,7};
        System.out.println(trap(a));
    }
    static int trap(final int[] A) {
        int[]min_arr=new int[A.length];
        int[]max_arr=new int[A.length];
        min_arr[0]=A[0];
        int ans=0;
        max_arr[A.length-1]=A[A.length-1];
        for(int i=1;i<A.length;i++)
            min_arr[i]=Math.max(min_arr[i-1], A[i]);
        for(int i=A.length-2;i>=0;i--)
            max_arr[i]=Math.max(max_arr[i+1], A[i]);
        for(int i=0;i<A.length;i++)
            ans+=Math.min(min_arr[i], max_arr[i])-A[i];
        return ans;
    }
}
