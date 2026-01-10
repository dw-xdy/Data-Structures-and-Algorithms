package class100;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_strStr {
    public static int strStr(String a, String b) {
        return kmp(a.toCharArray(), b.toCharArray());
    }

    public static int kmp(char[] s1, char[] s2) {
        int x = 0, y = 0;
        int n = s1.length;
        int m = s2.length;
        int[] next = nextArray(s2, m);
        while (x < n && y < m) {
            if (s1[x] == s2[y]) {
                x++;
                y++;
            } else if (y == 0) {
                x++;
            } else {
                y = next[y];
            }
        }
        return y == m ? x - y : -1;
    }

    public static int[] nextArray(char[] s, int m) {
        if (m == 1) {
            return new int[] { -1 };
        }
        int[] next = new int[m];
        next[0] = -1;
        next[1] = 0;
        int i = 2, cn = 0;
        while (i < m) {
            if (s[i - 1] == s[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }
}
