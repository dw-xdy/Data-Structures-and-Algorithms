package class052;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code02_DailyTemperatures {

    public static int MAXN = 100001;

    public static int[] stack = new int[MAXN];

    public static int r;

    public static int[] dailyTemperatures(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        r = 0;
        int cur;
        for (int i = 0; i < n; i++) {
            while (r > 0 && nums[stack[r - 1]] < nums[i]) {
                cur = stack[--r];
                ans[cur] = i - cur;
            }
            stack[r++] = i;
        }
        return ans;
    }
}
