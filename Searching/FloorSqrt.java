package Questions.Searching_3;

public class FloorSqrt {
    public static void main(String[] args) {
        int N=80;
        System.out.println(floorSqrt(N));
    }
    static int floorSqrt(int N){
        int low=1,high=N;
        int ans=1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(mid*mid<=N){
                ans=mid;
                low=mid+1;
            }
            else
                high=mid-1;
        }
        return ans;
    }
}
