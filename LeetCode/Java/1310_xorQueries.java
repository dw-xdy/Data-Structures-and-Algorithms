class Solution {

    // 直接进行暴力求解是可以的, 但是无法通过题目测试
    // 时间复杂度是: O(n * m)
    // 空间复杂度是: O(1)
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] nums = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                nums[i] ^= arr[j];
            }
        } 
        return nums;
    }

    // 我们采用前缀异或和的方式进行求解.
    // 时间复杂度为: O(n + m)
    // 空间复杂度为: O(n)
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int m = queries.length;

        int[] sumXor = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sumXor[i] = sumXor[i - 1] ^ arr[i - 1];
        }
        
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1] + 1;
            ans[i] = sumXor[r] ^ sumXor[l];
        }
        return ans;
    }
}
