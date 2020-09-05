package Questions.DP_15;

public class PalindromePartioning {
    public static void main(String[] args) {
        String s="nitin";
        System.out.println(minCuts(s));
    }
    static int minCuts(String s){
        int N=s.length();
        //creating dp matrix for palindrome check
        boolean[][]palindromSet=new boolean[N][N];
        for(int i=0;i<N;i++)
            palindromSet[i][i]=true;
        for(int i=0;i<N-1;i++){
            if(s.charAt(i)==s.charAt(i+1))
                palindromSet[i][i+1]=true;
        }
        for(int l=3;l<=N;l++){
            for(int i=0;i<N-l+1;i++){
                int j=l+i-1;
                if(s.charAt(i)==s.charAt(j) && palindromSet[i+1][j-1])
                    palindromSet[i][j]=true;
            }
        }
        int []cuts=new int[N];
        for(int i=0;i<N;i++){
            int temp=Integer.MAX_VALUE;
            if(palindromSet[0][i])
                cuts[i]=0;
            else{
                for(int j=0;j<i;j++){
                    if(palindromSet[j+1][i] && temp>cuts[j]+1){
                        temp=cuts[j]+1;
                    }
                }
                cuts[i]=temp;
            }
        }
        return cuts[N-1];
    }
}
