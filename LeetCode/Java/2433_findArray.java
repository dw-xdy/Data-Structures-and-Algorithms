class Solution {
    // 利用了 ^ 运算的性质: 交换律.
    // 主要是公式的推导: 只要是列几个式子, 一下子就能看出来这个规律了.
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public int[] findArray(int[] pref) {
        int[] arr = new int[pref.length];
        arr[0] = pref[0];

        for (int i = 1; i < pref.length; i++) {
            arr[i] = pref[i - 1] ^ pref[i];
        }
        return arr;
    }
}
