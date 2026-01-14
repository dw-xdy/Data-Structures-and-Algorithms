class Solution {
    // 这个题目是纯粹的数学推导.
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public boolean doesValidArrayExist(int[] derived) {
        int ans = 0;

        for (int num : derived) {
            ans ^= num;
        }

        return ans == 0;
    }
}
