package Questions.DP_15;

public class MaxBalSubString {
    public static void main(String[] args) {
        String A="(()";
        char[]c=A.toCharArray();
        System.out.println(maxLength(c));
    }
    static int maxLength(char[] c){
        int[]dp=new int[c.length];
        dp[0]=0;
        for(int i=1;i<c.length;i++){
            if((c[i]==')' && c[i-1]=='(') || (c[i]==']' && c[i-1]=='[') || (c[i]=='}' && c[i-1]=='{'))
                dp[i]=i>1?dp[i-2]+2:2;
            else{
                if(i-dp[i-1]-1>=0 && ((c[i]==')'  && c[i-dp[i-1]-1]=='(') || (c[i]=='}'&& c[i-dp[i-1]-1]=='{') || (c[i]==']'&&c[i-dp[i-1]-1]=='[')))
                    dp[i]=dp[i-1]+2+ ((i-dp[i-1]-2)>=0?dp[i-dp[i-1]-2]:0);
            }
        }
        int ans=dp[0];
        for(int x:dp)
            ans=Math.max(x,ans);
        return ans;
    }
}
