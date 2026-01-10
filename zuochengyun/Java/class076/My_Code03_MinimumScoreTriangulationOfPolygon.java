package class076;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code03_MinimumScoreTriangulationOfPolygon {
    public static int minScoreTriangulation1(int[] arr) {
        int n = arr.length;
        return f1(arr, 0, n - 1);
    }


    // 返回所有情况的最小值.
    public static int f1(int[] arr, int l, int r) {
        if (l == r || l + 1 == r) {
            return 0;
        } else {
            int ans = Integer.MAX_VALUE;
            for (int m = l + 1; m < r; m++) {
                ans = Math.min(ans, f1(arr, l, m) + f1(arr, m, r) + arr[l] * arr[m] * arr[r]);
            }
            return ans;
        }
    }
}
