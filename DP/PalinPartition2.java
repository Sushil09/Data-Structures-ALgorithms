package Questions.DP_15;

import java.util.Arrays;

public class PalinPartition2 {
    public static void main(String[] args) {
        String a="aba";
        cutMin(a);
        System.out.println(cutMin(a));
    }
    static int cutMin(String s){
        int N=s.length();
        boolean [][]dp=new boolean[N][N];
        for(int i=0;i<N;i++)
            dp[i][i]=true;
        for(int i=0;i<N-1;i++)
            if(s.charAt(i)==s.charAt(i+1))
                dp[i][i+1]=true;
        for(int l=3;l<=N;l++){
            for(int i=0;l+i-1<N;i++){
                int j=l+i-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1])
                    dp[i][j]=true;
                else
                    dp[i][j]=false;
            }
        }
        int[]cuts=new int[N];
        Arrays.fill(cuts,Integer.MAX_VALUE);
        for(int i=0;i<N;i++){
            if(dp[0][i])
                cuts[i]=0;
            else{
                for(int k=0;k<i;k++){
                    if(dp[k+1][i])
                        cuts[i]=Math.min(cuts[k]+1,cuts[i]);
                }
            }
        }
        return cuts[N-1];
    }
}
