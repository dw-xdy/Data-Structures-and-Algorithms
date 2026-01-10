package class098;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code03_ClimbingStairs {
    public static int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        int[][] start = { { 1, 1, 0 } };
        int[][] base = {
                { 1, 1, 0 },
                { 1, 0, 1 },
                { 1, 0, 0 }
                };
        int[][] ans = multiply(start, power(base, n - 2));
        return ans[0][0];
    }



    public static int[][] multiply(int[][] a, int[][] b) {
        int n = a.length;
        int m = b.length;
        int c = a[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < c; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                 }
            }
        }
        return ans;
    }

    public static int[][] power(int[][] m, int p) {
        int n = m.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            ans[i][i] = 1;
        }
        while (p > 0) {
            if ((p & 1) == 1) {
                ans = multiply(ans, m);
            }
            m = multiply(m, m);
            p >>= 1;
        }
        return ans;
    }
}
