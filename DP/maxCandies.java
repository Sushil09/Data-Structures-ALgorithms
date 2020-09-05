package Questions.DP_15;

public class maxCandies {
    public static void main(String[] args) {
        int[]A={1,2,3};//candies number
        int []B={2,2,10};//sweetness
        int []C={2,3,9};//cost
        int D=8;
        System.out.println(maxSweetness(A,B,C,D));
    }
    static int maxSweetness(int[]A,int[] B,int []C,int D){
        for(int i=0;i<B.length;i++)
            B[i]=B[i]*A[i];
        int[][]dp=new int[B.length+1][D+1];
        for(int i=1;i<=B.length;i++){
            for(int j=1;j<=D;j++){
                if(j>=C[i-1])
                    dp[i][j]=Math.max(dp[i-1][j] ,dp[i][j-C[i-1]]+B[i-1]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[B.length][D];
    }
}
