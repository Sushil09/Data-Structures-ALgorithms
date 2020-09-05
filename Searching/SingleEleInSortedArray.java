package Questions.Searching_3;

public class SingleEleInSortedArray {
    public static void main(String[] args) {
//        int[]a={1,1,3,3,4,4,5};
        int[]a={1,1,2,2,3,3,4,4,5};
        System.out.println(singleEle(a));
    }
    static int singleEle(int[]a){
        int N=a.length;
        if(N==1)
            return a[0];
        if(N==3)
            return a[0]==a[1]?a[2]:a[0];
        int low=0,high=N-1;
        while (low<=high){
            int mid=low+(high-low)/2;
            if((mid==0 && a[mid+1]!=a[mid]) || (mid==N-1 && a[mid-1]!=a[mid]) || a[mid-1]!=a[mid] &&  a[mid+1]!=a[mid])
                return a[mid];
            if(mid%2!=0){
                if(a[mid-1]!=a[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
            else {
                if(a[mid+1]!=a[mid])
                    high=mid-1;
                else
                    low=mid+1;
            }
        }
    return -1;
    }
}
