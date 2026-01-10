package class040;


/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_NQueensI {
    public static int NQueens(int n) {
        if (n < 1) {
            return 0;
        }
        return f(0, new int[n], n);
    }


    public static int f(int i, int[] path, int n) {
        if (i == n) {
            return 1;
        }
        int ans = 0;
        for (int j = 0; j < n; j++) {
            if (check(path, i, j)) {
                path[i] = j;
                ans += f(i + 1, path, n);
            }
        }
        return ans;
    }


    public static boolean check(int[] path, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == path[k] || Math.abs(i - k) == Math.abs(j - path[k])) {
                return false;
            }
        }
        return true;
    }
}
