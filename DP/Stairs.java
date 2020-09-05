package Questions.DP_15;

public class Stairs {
    public static void main(String[] args) {
        int A=2;
        System.out.println(maxWays(A));
    }
    static int maxWays(int x){
        if(x==1)
            return 1;
        int first=1,second=1;
        int ans=first+second;
        for(int i=2;i<=x;i++){
            ans=first+second;
            first=second;
            second=ans;
        }
        return ans;
    }
}
