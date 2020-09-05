package Questions.Searching_3;

import java.util.Arrays;

public class MatrixMedian {
    public static void main(String[] args) {
        int[][]a={{1,2,8},
                  {6,7,15},
                  {16,18,19},
                  {2,4,7},
                  {1,8,9}};
        System.out.println(findMedian(a));
    }
    static int findMedian(int[][]a){
        int N=a.length,M=a[0].length;
        int ans=-1;
        int l=findMin(a),h=findMax(a);
        int desired=(N*M+1)/2;
        while (l<=h){
            int mid=l+(h-l)/2;
            int count=findLess(a,mid);// to get how many ele. are less than mid
            if(count<=desired){
                ans=mid;
                l=mid+1;
            }
            else
                h=mid-1;
        }
        return ans;
    }
    static int findLess(int[][]a,int mid){
        int place=0,get=0,N=a.length;
        for(int i=0;i<N;i++){
            get=Arrays.binarySearch(a[i],mid);// gives index of first occurence of ele. if found  else - at which place it can be kept
            if(get<0)
                get=Math.abs(get)-1;
            else{
                while(get < a[i].length && a[i][get] == mid)
                    get += 1;
            }
            place+=get;
        }
        return place;
    }
    static int findMin(int[][]a){
        int N=a.length;
        int min=a[0][0];
        for(int i=0;i<N;i++)
            min=Math.min(min,a[i][0]);
        return min;
    }
    static int findMax(int[][]a){
        int N=a.length;
        int M=a[0].length;
        int max=a[0][M-1];
        for(int i=0;i<N;i++)
            max=Math.max(max,a[i][M-1]);
        return max;
    }
}
