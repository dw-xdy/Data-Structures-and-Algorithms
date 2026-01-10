package class051;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code06_WaitingTime2 {
    public static long minimumTime(int[] arr, int w) {
        // max, min 这个是一个很需要注意的点,
        // max 设置为 Integer.MIN_VALUE, 因为后续需要找到最大值.
        // min 设置为 Integer.MAX_VALUE, 因为后续需要找到最小值.
        long min = Integer.MAX_VALUE;
        for (int num : arr) {
            min = Math.min(num, min);
        }
        long l = 0;
        long r = min * w;
        long m;
        long ans = 0;
        while (l <= r) {
            m = l + ((r - l) >> 1);
            if (f(arr, m) >= w) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    public static long f(int[] arr, long time) {
        long ans = 0;
        for (int num : arr) {
            ans += (time / num);
        }
        return ans;
    }
}
