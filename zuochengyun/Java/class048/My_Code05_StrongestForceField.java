package class048;

import java.util.Arrays;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code05_StrongestForceField {
    public static int fieldOfGreatestBlessing(int[][] forceField) {
        int n = forceField.length;
        long[] sx = new long[n << 1];
        long[] sy = new long[n << 1];
        for (int i = 0, j = 0, k = 0; i < n; i++) {
            long x = forceField[i][0];
            long y = forceField[i][1];
            long r = forceField[i][2];
            sx[j++] = (x << 1) - r;
            sx[j++] = (x << 1) + r;
            sy[k++] = (y << 1) - r;
            sy[k++] = (y << 1) + r;
        }
        int sizex = sort(sx);
        int sizey = sort(sy);
        int[][] diff = new int[sizex + 2][sizey + 2];
        for (int i = 0, a, b, c, d; i < n; i++) {
            long x = forceField[i][0];
            long y = forceField[i][1];
            long r = forceField[i][2];
            a = rank(sx, (x << 1) - r, sizex);
            b = rank(sy, (y << 1) - r, sizey);
            c = rank(sx, (x << 1) + r, sizex);
            d = rank(sy, (y << 1) + r, sizey);
            add(diff, a, b, c, d);
        }
        int ans = 0;
        for (int i = 1; i < diff.length; i++) {
            for (int j = 1; j < diff[i].length; j++) {
                diff[i][j] += diff[i - 1][j] + diff[i][j - 1] - diff[i - 1][j - 1];
                ans = Math.max(ans, diff[i][j]);

            }
        }
        return ans;
    }


    public static int sort(long[] arr) {
        Arrays.sort(arr);
        int size = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[size - 1] != arr[i]) {
                arr[size++] = arr[i];
            }
        }
        return size;
    }


    public static int rank(long[] nums, long v, int size) {
        int l = 0;
        int r = size - 1;
        int m, ans = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (nums[m] >= v) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans + 1;
    }

    public static void add(int[][] diff, int a, int b, int c, int d) {
        diff[a][b] += 1;
        diff[c + 1][d + 1] += 1;
        diff[c + 1][b] -= 1;
        diff[a][d + 1] -= 1;
    }
}
