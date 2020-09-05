package Questions.DP_15;

public class CatalanNumber {
    private static long [] catalan= new long[1001];
    private static final int MOD=1000000007;
    public static void main(String[] args) {
        precalc();
        System.out.println(catalan[7]);
    }
    private static void precalc(){

        for (int i=0;i<=1000;i++){
            if (i==0 || i==1){
                catalan[i]=1;
            }
            else{
                long sum =0;long left, right;
                for (int k=1;k<=i;k++){
                    left = catalan[k-1] % MOD;
                    right= catalan[i-k] % MOD;
                    sum =(sum+ (left * right)%MOD)%MOD;
                }
                catalan[i]=sum;
            }
        }
    }
}
