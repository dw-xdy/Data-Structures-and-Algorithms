// 最小覆盖子串
// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串
// 如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
// 测试链接 : https://leetcode.cn/problems/minimum-window-substring/
public class Code03_MinimumWindowSubstring { 
    
    public static String minWindow(String str, String tar) { 
		if (str.length() < tar.length()) {
			return "";
		}
        char[] s = str.toCharArray();   
        char[] t = tar.toCharArray();
        // 总负债
        int debt = t.length;

        // 负债表
        int[] cnts = new int[256];

        for (char c : t) {
            cnts[c]--;
        }

        int len = Integer.MAX_VALUE;
        int start = 0;
        int l = 0;
        for (int r = 0; r < s.length; r++) {
            if (cnts[s[r]] < 0) {
                debt--;
            }                
            // 因为只要我经过了这个字符, 那么这个字符在欠债表中就必须 + 1.
            cnts[s[r]]++;
            if (debt == 0) {
                while (cnts[s[l]] > 0) {
                    cnts[s[l]]--;
                    l++;
                }
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    start = l;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : str.substring(start, start + len);
    }
}
