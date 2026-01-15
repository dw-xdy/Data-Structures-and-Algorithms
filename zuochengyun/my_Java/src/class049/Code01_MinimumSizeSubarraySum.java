package class049;

public class Code01_MinimumSizeSubarraySum {

    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public static int minSubArrayLen(int target, int[] nums) { 
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        // 这里的 r 已经是 ++ 之后的, 在循环中.
        for (int l = 0, r = 0; r < nums.length; r++) {
            sum += nums[r];    // 这里并不需要
            while (sum - nums[l] >= target) {   // 这里也并不需要l++, 会导致出错.
                sum -= nums[l++];
            }
            if (sum >= target) {
                ans = Math.min(ans, r - l + 1);
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
