package class066;


public class My_Code02_MinimumCostForTickets {
    // 无论提交什么方法都带着这个数组      0  1  2
    public static int[] durations = { 1, 7, 30 };

    // 暴力尝试
    public static int mincostTickets1(int[] days, int[] costs) {
        return f1(days, costs, 0);
    }

    // f1 函数的意义是：从 i 开始, 剩余的天数消耗的最少的金钱.
    public static int f1(int[] days, int[] costs, int i) {
        if (i == days.length) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 0, j = i; k < 3; k++) {
            while (j < days.length && days[i] + durations[k] > days[j]) {
                j++;
            }
            ans = Math.min(ans, costs[k] + f1(days, costs, j));
        }
        return ans;
    }

}
