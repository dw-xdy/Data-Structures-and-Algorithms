import java.util.Arrays;

// 这是左老师的解法, 可能是已给比较深入的理解算法之后使用的解法.
// 无重复字符的最长子串
// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
// 测试链接 : https://leetcode.cn/problems/longest-substring-without-repeating-characters/
public class Code02_LongestSubstringWithoutRepeatingCharacters {

	public static int lengthOfLongestSubstring(String str) {
        char[] s = str.toCharArray();
        int[] last = new int[256];
        int ans = 0;
        
        Arrays.fill(last, -1);

        for (int l = 0, r = 0; r < s.length; r++) {
            ans = Math.max(ans, r - l + 1);
            l = Math.max(l, last[s[r]] + 1);
            last[s[r]] = r;
        }
        return ans;
	}

}

// 灵神的解法, 个人认为比较好理解.
class Solution {
    public int lengthOfLongestSubstring(String S) {
        char[] s = S.toCharArray(); // 转换成 char[] 加快效率（忽略带来的空间消耗）
        int n = s.length;
        int ans = 0;
        int left = 0;
        int[] cnt = new int[128]; // 也可以用 HashMap<Character, Integer>，这里为了效率用的数组
        for (int right = 0; right < n; right++) {
            char c = s[right];
            cnt[c]++;
            while (cnt[c] > 1) { // 窗口内有重复字母
                cnt[s[left]]--; // 移除窗口左端点字母
                left++; // 缩小窗口
            }
            ans = Math.max(ans, right - left + 1); // 更新窗口长度最大值
        }
        return ans;
    }
}
