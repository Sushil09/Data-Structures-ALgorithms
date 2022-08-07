package Questions.Recursion_And_BackTracking_4;

public class Coin_change {
    static int count=0;
    public static void main(String[] args) {
        int[]a={1,5,6};
        int sum=7;
        topDown(a,a.length-1,sum);
//        bottomUp(a,a.length,0,sum,0);
        System.out.println(count-1);
    }
    static void topDown(int[]a,int N,int sum){
        if(N<0 ||sum<0)
            return;
        if(sum==0)
            count++;
        topDown(a,N,sum-a[N]); // If an element is chosen, it can be choosen, many times.
        topDown(a,N-1,sum);
    }
    static void bottomUp(int[]a,int N,int sum,int K,int idx){
        if(idx==N || sum>K)
            return;
        if(sum==K)
            ++count;
        bottomUp(a,N,sum+a[idx],K,idx);
        bottomUp(a,N,sum+a[idx],K,idx+1);
    }
}
