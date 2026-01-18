class Solution {
    public static int maxScore(int[] cardPoints, int k) {
        if (cardPoints.length == k) {
            int enen = 0;
            for (int i = 0; i < cardPoints.length; i++) {
                enen += cardPoints[i];
            }
            return enen;
        }

        int n = cardPoints.length;
        int m = n - k;
        int sum1 = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            // 记录总和.
            sum += cardPoints[i];
            sum1 += cardPoints[i];
            // 窗口不足 m 大小
            if (i - m + 1 < 0) {
                continue;
            }
            // 更新ans;
            ans = Math.min(ans, sum);
            
            // 弹出窗口;
            sum -= cardPoints[i - m + 1];
        }
        return sum1 - ans;
    }
}
