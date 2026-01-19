class Solution {
    // 我的思路没有问题, 但是代码实现没有成功.
    public static int longestSubarray(int[] nums) {
        int cnt0 = 0;

        int ans = Integer.MIN_VALUE;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            cnt0 += 1 - nums[r];

            while (cnt0 > 1) {
                cnt0 -= 1 - nums[l]; // 维护窗口中的 0 的个数
                l++;
            }

            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}


// 灵神的解法.
class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int cnt0 = 0;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            // 1. 入，nums[right] 进入窗口
            cnt0 += 1 - nums[r]; // 维护窗口中的 0 的个数
            while (cnt0 > 1) { // 不符合题目要求
                // 2. 出，nums[left] 离开窗口
                cnt0 -= 1 - nums[l]; // 维护窗口中的 0 的个数
                l++;
            }
            // 3. 更新答案，注意不是 right-left+1，因为我们要删掉一个数
            ans = Math.max(ans, r - l);
        }
        return ans;
    }
}
