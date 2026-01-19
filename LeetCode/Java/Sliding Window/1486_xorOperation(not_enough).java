class Solution {
    // 方法 1. (直接暴力) 
    // 时间复杂度: O(n)
    // 空间复杂度: O(1)
    public static int xorOperation(int n, int start) {
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans ^= start + 2 * i;
        }
        return ans;
    }

    // 方法二: 利用数学的方式进行求解
    //  TODO:
}
