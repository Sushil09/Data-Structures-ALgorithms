package Questions.Searching_3;

public class FindingLocalMaxima {
    public static void main(String[] args) {
        int[]a={1,5,3,6,7,8,9};
        System.out.println(localMaxima(a));
    }
    static int localMaxima(int[]a){
        int N=a.length;
        int low=0,high=N-1;
        int ans=-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(mid!=0 && a[mid-1]>a[mid])
                high=mid-1;
            else if(mid!=N-1 && a[mid+1]>a[mid])
                low=mid+1;
            else{
                ans=a[mid];
                break;
            }
        }
        return ans;
    }
}
