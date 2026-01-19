class Solution {
    public boolean hasTrailingZeros(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (num & 1 == 0) {
                ans++;
            }
        }
        return ans >= 2;
    }
}
