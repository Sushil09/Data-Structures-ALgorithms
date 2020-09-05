package Questions.Searching_3;

public class AggresiveCows {
    public static void main(String[] args) {
        int[]a={1, 2};
        int N=2;//No. of cows
        System.out.println(maxDistance(a,N));
    }
    static int maxDistance(int[]a,int K){
        int N=a.length-1;
        int l=0,h=N-1;
        int ans=Integer.MIN_VALUE;
        while (l<=h){
            int mid=l+(h-l)/2;
            if(isPossible(a,a[mid],K)){
                if(a[mid]>ans)
                    ans=a[mid];
//                ans=mid;
                l=mid+1;
            }
            else
                h=mid-1;
        }
        return ans;
    }
    static boolean isPossible(int []a,int mid, int K){
        int count=1,lasEncountered=a[0];
        for(int i=1;i<a.length;i++){
            if(a[i]-lasEncountered>=mid){
                count++;
                lasEncountered=a[i];
            }
        }
        return count>=K;
    }
}
