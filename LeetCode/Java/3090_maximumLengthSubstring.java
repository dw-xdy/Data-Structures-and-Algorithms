class Solution {
    // 关于这个题目, 我的思路是正确的, 也是一个负债表的思路, 但是我没有正确分析.
    // 时间复杂度: O(n)
    // 空间复杂度: O(1) -> 其实可以将 256 个int 缩短到 26 个int.
    public static int maximumLengthSubstring(String str) {
        char[] s = str.toCharArray();
        int[] cnts = new int[256];

        int ans = Integer.MIN_VALUE;

        for (int l = 0, r = 0; r < s.length; r++) {
            cnts[s[r]]++;

            while (cnts[s[r]] > 2) {
                cnts[s[l]]--;
                l++;
            }

            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
}

// 灵神的解法, 节约空间.
class Solution {
    public int maximumLengthSubstring(String S) {
        char[] s = S.toCharArray();
        int ans = 0;
        int left = 0;
        int[] cnt = new int[26];
        for (int i = 0; i < s.length; i++) {
            int b = s[i] - 'a';
            cnt[b]++;
            while (cnt[b] > 2) {
                cnt[s[left] - 'a']--;
                left++;
            }
            ans = Math.max(ans, i - left + 1);
        }
        return ans;
    }
}
