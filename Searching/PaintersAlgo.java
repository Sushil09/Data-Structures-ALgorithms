package Questions.Searching_3;

public class PaintersAlgo {
    public static void main(String[] args) {
        int[]a={3,5,1,7,8,2,5,3,10,1,4,7,5,4,6};
        int K=3;
        System.out.println(minTime(a,K));
    }
    static int minTime(int[]a,int K){
        int l=maxEle(a),h=summ(a);
        int ans=l;
        while (l<=h){
            int mid=l+(h-l)/2;
            if(isValid(a,mid,K)){
                ans=mid;
                h=mid-1;
            }
            else
                l=mid+1;
        }
        return ans;
    }
    static boolean isValid(int[]a,int mid, int K){
        int N=a.length;
        int ppl=1,sum=0;
        for(int i=0;i<N;){
            if(sum+a[i]>mid){
                ppl++;
                sum=0;
            }
            else {
                sum+=a[i];
                i++;
            }
        }
        if(ppl<=K)
            return true;
        return false;
    }
    static int maxEle(int[]a){
        int max=a[0];
        for(int x:a)
            max=Math.max(max,x);
        return max;
    }
    static int summ(int[]a){
        int sum=0;
        for(int x:a)
            sum+=x;
        return sum;
    }
}
