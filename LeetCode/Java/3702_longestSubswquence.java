class Solution {
    // 一个脑筋急转弯的题目.
    // 时刻记住异或运算的性质很重要: 异或运算是将两个数字转换为一个数字.
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public int longestSubsequence(int[] nums) {
        int ans = 0;
        int cntZero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                cntZero++;
            }
            ans ^= nums[i];
        }

        if (cntZero == nums.length) {
            return 0;
        }
        
        return ans == 0 ? nums.length - 1 : nums.length;
    }
}
