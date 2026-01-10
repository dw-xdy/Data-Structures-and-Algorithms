package class072;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class LongestInceasing {
    public static int[] lengthOfLIS2WithDP(int[] nums) {
        int n = nums.length;
        int[] ends = new int[n];
        int[] dp = new int[n]; // dp数组，记录每个位置的最长递增子序列的长度
        int len = 0;
        for (int i = 0, find; i < n; i++) {
            find = bs1(ends, len, nums[i]);
            if (find == -1) {
                ends[len++] = nums[i];
                dp[i] = len; // 当前元素是ends数组的新元素，所以dp[i] = len + 1
            } else {
                ends[find++] = nums[i];
                dp[i] = find; // 当前元素替换了ends数组中的某个元素，所以dp[i] = find + 1
            }
        }
        return dp; // 返回dp数组
    }

    // 二分搜索，找到>=num的最左位置
    public static int bs1(int[] ends, int len, int num) {
        int l = 0, r = len - 1, m, ans = -1;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (ends[m] >= num) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }


    public static int[] lengthOfLIS2With(int[] nums) {
        int n = nums.length;
        int[] ends = new int[n];
        int[] dp = new int[n];
        int len = 0;
        int find;
        for (int i = 0; i < n; i++) {
            find = bs(ends, len, nums[i]);
            if (find == -1) {
                ends[len++] = nums[i];
                dp[i] = len;
            } else {
                ends[find++] = nums[i];
                dp[i] = find;
            }
        }
        return dp;
    }

    public static int bs(int[] ends, int len, int num) {
        int l = 0, r = len - 1;
        int ans = -1;
        int m;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (ends[m] >= num) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
