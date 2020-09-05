package Questions.DP_15;

public class CountSubsetSum {
    public static void main(String[] args) {
        int[]a={1,1,1,1,1};
        int K=3;
        int totalSum=finSum(a);
        int sum=(totalSum+K)/2;
        System.out.println(countSubsetsWithSumEqualToGivenSum(a,sum));
    }
    public static int countSubsetsWithSumEqualToGivenSum(int[] arr, int sum) {
        if(arr.length == 0 || sum <= 0) {
            return 0;
        }
        int n = arr.length;
        int[][] count = new int[n][sum + 1];
        for(int i = 0; i < n; i++)
            count[i][0] = 1;
        for(int j = 0; j <= sum; j++) {
            if(arr[0] == j) {
                count[0][j] = 1;
            }
        }
        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= sum; j++) {
                int includingCurrentValue = 0;
                int excludingCurrentValue = 0;
                if(arr[i] <= j)
                    includingCurrentValue = count[i - 1][j - arr[i]];
                excludingCurrentValue = count[i - 1][j];
                count[i][j] = includingCurrentValue + excludingCurrentValue;
            }
        }
        return count[n - 1][sum];
    }
    static int finSum(int[]a){
        int sum=0;
        for(int x:a)
            sum+=x;
        return sum;
    }
}
