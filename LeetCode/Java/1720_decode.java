class Solution {
    // 直接通过 ^ 运算的性质, 即交换律进行实现即可.
    // 时间复杂度: O(n)
    // 空间复杂度: O(n)
    public int[] decode(int[] encoded, int first) {
        int[] arr = new int[encoded.length + 1];
        arr[0] = first;

        for (int i = 0; i < encoded.length; i++) {
            arr[i + 1] = arr[i] ^ encoded[i];
        }
        return arr;
    }
}
