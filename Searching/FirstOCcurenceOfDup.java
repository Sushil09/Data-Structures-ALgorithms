package Questions.Searching_3;

public class FirstOCcurenceOfDup {
    public static void main(String[] args) {
        //e.x: find(0)=-1,find(1)=0,find(3)=5,find(4)=7;
        int[]a={1,1,2,2,2,3,3,3,4};
        System.out.println(findFirst(a,1));
    }
    static int findFirst(int[]a,int K){
        int N=a.length;
         int low=0,high=N-1;
         int ans=-1;
         while(low<=high){
             int mid=low+(high-low)/2;
             if(a[mid]>=K){
                 ans=mid;
                 high=mid-1;
             }
             else
                 low=mid+1;
         }
         return ans;
    }
}
