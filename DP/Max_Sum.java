package Questions.DP_15;

public class Max_Sum {
    public static void main(String[] args) {
        int[] a = {1};
        int[] prefixMax = new int[a.length];
        int[] prefixMin = new int[a.length];
        int[] postfixMax = new int[a.length];
        int[] postfixMin = new int[a.length];
        int N = a.length;
        int max = a[0];
        for (int i = 0; i < N; i++) {
            max = Math.max(max, a[i]);
            prefixMax[i] = max;
        }
        int min = a[0];
        for (int i = 0; i < N; i++) {
            min = Math.min(min, a[i]);
            prefixMin[i] = min;
        }
        max = min = a[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            max = Math.max(max, a[i]);
            min = Math.min(min, a[i]);
            postfixMax[i] = max;
            postfixMin[i] = min;
        }
        int ans = Integer.MIN_VALUE;
        int B = 1, C = -10, D = 3;
        if (N == 1)
            System.out.println((B + C + D) * a[0]);
        else {
            for (int i = 0; i < a.length; i++) {
                int sum = 0;
                if (i == 0) {
                    sum = B * a[0] + C * a[0] * (D > 0 ? D * Math.max(a[0], postfixMax[1]) : D * Math.min(a[0], postfixMin[1]));
                } else if (i == N - 1) {
                    sum = (B > 0 ? B * Math.max(a[i], prefixMax[i - 1]) : B * Math.min(a[i], prefixMin[i - 1])) + C * a[i] + D * a[i];
                } else {
                    sum = (B > 0 ? B * Math.max(a[i], prefixMax[i - 1]) : B * Math.min(a[i], prefixMin[i - 1])) + C * a[i] + (D > 0 ? D * Math.max(a[i], postfixMax[i+1]) : D * Math.min(a[i], postfixMin[i+1]));
                }
                ans = Math.max(sum, ans);
            }
            System.out.println(ans);
        }
    }
}
