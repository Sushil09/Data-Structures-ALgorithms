package Questions.Maths_And_Arrays_1;

public class NCRMODM {
    static int[] fact;
    public static void main(String[] args) {
        int N=4,R=2;
        computeFact(N);
        System.out.println(fact[N]/(fact[N-R] * fact[R]));
    }
    //normal method
    private static void computeFact(int n) {
        fact = new int[n + 1];
        fact[0] = 1;
        for (int i = 1; i < fact.length; i++)
            fact[i] = fact[i - 1] * i;
    }
    //For modulus operator, iteration only till min(i,r)
    static int nCrModP(int n, int r, int p)
    {
        int[] C=new int[r+1];
        C[0] = 1;
        for (int i = 1; i <= n; i++)
        {
            for (int j = Math.min(i, r); j > 0; j--)
                C[j] = (C[j] + C[j-1])%p;
        }
        return C[r];
    }
}
