import java.util.Arrays;

class Solution {
    // 时间复杂度: O(n * log n) 因为有排序操作, 滑动窗口时间复杂度: O(n)
    // 空间复杂度: O(n) 因为有排序操作, 滑动窗口空间复杂度: O(1)
    public int minRemoval(int[] nums, int k) {
        Arrays.sort(nums);

        int maxSave = Integer.MIN_VALUE;
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            while ((long)nums[l] * k < nums[r]) {
                l++;
            }

            maxSave = Math.max(maxSave, r - l + 1);
        }
        return nums.length - maxSave;
    }
}
