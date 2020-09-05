package Questions.Searching_3;

public class RotatedSortedArray {
    public static void main(String[] args) {
        //find(1)=3,find(6)=-1
        int[]a={4,5,6,7,0,1,2};
        int pivot=findPivot(a);
        System.out.println(pivot);
        int K=5;
      int ans=BS1(a,pivot,K)==-1?BS2(a,pivot,K):BS1(a,pivot,K);
        System.out.println(ans);
    }
    static int findPivot(int[]a){
        int low=0,high=a.length-1;
        int pivot=a.length-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(a[mid]>a[a.length-1])
                low=mid+1;
            else {
                pivot=mid;
                high=mid-1;
            }
        }
        return pivot;
    }
    static int BS1(int[]a,int pivot,int K){
        int ans=-1;
        int l=0,h=pivot-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if(a[mid]>K)
                h=mid-1;
            else if(a[mid]<K)
                l=mid+1;
            else{
                ans=mid;
                break;
            }
        }
        return ans;
    }
    static int BS2(int[]a,int pivot,int K){
        int ans=-1;
        int l=pivot,h=a.length-1;
        while (l<=h){
            int mid=l+(h-l)/2;
            if(a[mid]>K)
                h=mid-1;
            else if(a[mid]<K)
                l=mid+1;
            else{
                ans=mid;
                break;
            }
        }
        return ans;
    }
}
