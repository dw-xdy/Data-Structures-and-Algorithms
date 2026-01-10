package class067;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code01_MinimumPathSum {
    public static int minPathSum1(int[][] grid) {
        return f1(grid, grid.length - 1, grid[0].length - 1);
    }

    // 这个函数的意义是返回从(0, 0) 到 (i, j)的最小的路径和.
    public static int f1(int[][] grid, int i, int j) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if (i > 0) {
            up = f1(grid, i - 1, j);
        }
        if (j > 0) {
            left = f1(grid, i, j - 1);
        }
        return Math.min(up, left) + grid[i][j];
    }


    public static int minPathSum2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }
        return f2(grid, grid.length - 1, grid[0].length - 1, dp);
    }

    // 这个函数的意义是返回从(0, 0) 到 (i, j)的最小的路径和.
    public static int f2(int[][] grid, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans;
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        int up = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if (i > 0) {
            up = f2(grid, i - 1, j, dp);
        }
        if (j > 0) {
            left = f2(grid, i, j - 1, dp);
        }
        ans = grid[i][j] + Math.min(up, left);
        dp[i][j] = ans;
        return ans;
    }


    // 严格位置依赖的动态规划
    public static int minPathSum3(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        // 这里先填好 第 0 列 的所有值. 为后续做准备.
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        // 这里是填好 第 0 行 的所有值, 为后续做准备
        for (int j = 1; j < m; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }

    // 严格位置依赖的动态规划 + 空间压缩技巧
    public static int minPathSum4(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] dp = new int[m];
        dp[0] = grid[0][0];
        for (int j = 1; j < m; j++) {
            dp[j] = dp[j - 1] + grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            // 每次都更新 最开始 0 位置的数字. 为后续实现(填写)做准备.
            dp[0] += grid[i][0];
            for (int j = 1; j < m; j++) {
                dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];
            }
        }
        return dp[m - 1];
    }

}
