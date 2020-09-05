package Questions.DP_15;

public class MatrixSumSubQuery {
    public static void main(String[] args) {
        int[][]a= {{1, 2, 3},
                   {4, 5, 6},
                    {7,8,9}};
        int i=2,j=2,k=3,l=3;
        System.out.println(SumQuery(a,i,j,k,l));
    }
    static int SumQuery(int[][]a,int i,int j,int k, int l){
        int N=a.length,M=a[0].length;
        int[][]dp=new int[N+1][M+1];
       for(int i_=1;i_<=N;i_++){
           for(int j_=1;j_<=M;j_++){
               dp[i_][j_]=dp[i_-1][j_]+dp[i_][j_-1]-dp[i_-1][j_-1]+a[i_-1][j_-1];
           }
       }
       for(int i_=0;i_<=N;i_++){
           for(int j_=0;j_<=M;j_++)
               System.out.print(dp[i_][j_]+" ");
           System.out.println();
       }
        System.out.println();
       return dp[k][l]-dp[i-1][l]-dp[k][j-1]+dp[i-1][j-1];
    }
}
