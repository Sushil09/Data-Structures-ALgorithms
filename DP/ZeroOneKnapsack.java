package Questions.DP_15;

public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[]profits={60, 100, 120};//profits
        int[]weights={10,20,30};//weights
        int capacity=50;//capacity
        System.out.println(maxProfit(profits,weights,capacity));
    }
    static int maxProfit(int[]profits,int[]weights,int capacity){
        int[][]dp=new int[profits.length+1][capacity+1];
        for(int i=1;i<=profits.length;i++){
            for(int j=1;j<=capacity;j++){
                if(j>=weights[i-1])
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weights[i-1]]+profits[i-1]);
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        return dp[profits.length][capacity];
    }
}
