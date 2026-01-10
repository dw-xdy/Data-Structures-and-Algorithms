package class076;

import java.util.Arrays;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code02_PredictTheWinner {
    public static boolean predictTheWinner1(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int first = f1(nums, 0, n - 1);
        int second = sum - first;
        return first >= second;
    }

    // 返回玩家1能在区间[l...r]范围内得到的最大数值.
    public static int f1(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        if (l + 1 == r) {
            return Math.max(nums[l], nums[r]);
        }
        int p1 = nums[l] + Math.min(f1(nums, l + 2, r), f1(nums, l + 1, r - 1));
        int p2 = nums[r] + Math.min(f1(nums, l + 1, r - 1), f1(nums, l, r - 2));
        return Math.max(p1, p2);
    }


    public static boolean predictTheWinner2(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        int first = f2(nums, 0, n - 1, dp);
        int second = sum - first;
        return first >= second;
    }

    // 返回玩家1能在区间[l...r]范围内得到的最大数值.
    public static int f2(int[] nums, int l, int r, int[][] dp) {
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        if (l == r) {
            return nums[l];
        }
        if (l + 1 == r) {
            return Math.max(nums[l], nums[r]);
        }
        int p1 = nums[l] + Math.min(f2(nums, l + 2, r, dp), f2(nums, l + 1, r - 1, dp));
        int p2 = nums[r] + Math.min(f2(nums, l + 1, r - 1, dp), f2(nums, l, r - 2, dp));
        int ans = Math.max(p1, p2);
        dp[l][r] = ans;
        return ans;
    }


    // 严格位置依赖的动态规划.
    public static boolean predictTheWinner3(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n - 1; i++) {
            dp[i][i] = nums[i];
            dp[i][i + 1] = Math.max(nums[i], nums[i + 1]);
        }
        dp[n - 1][n - 1] = nums[n - 1];
        for (int l = n - 3; l >= 0; l--) {
            for (int r = l + 2; r < n; r++) {
                dp[l][r] = Math.max(
                        Math.min(dp[l + 2][r], dp[l + 1][r - 1]) + nums[l],
                        Math.min(dp[l + 1][r - 1], dp[l][r - 2]) + nums[r]
                );
            }
        }
        int first = dp[0][n - 1];
        int second = sum - first;
        return first >= second;
    }
}
