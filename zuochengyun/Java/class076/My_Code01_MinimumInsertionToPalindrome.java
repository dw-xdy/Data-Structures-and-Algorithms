package class076;

import java.util.Arrays;


public class My_Code01_MinimumInsertionToPalindrome {

    // 纯粹的暴力方式实现. 递归实现.
    public static int minInsertions1(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        return f1(s, 0, n - 1);
    }

    // 从题目的定义出发：f1()函数的意义是：返回从s[l...r]返回上修改为回文字符串的最小的插入修改次数.
    public static int f1(char[] s, int l, int r) {
        if (l == r) {
            return 0;
        }
        if (l + 1 == r) {
            return s[l] == s[r] ? 0 : 1;
        }
        if (s[l] == s[r]) {
            return f1(s, l + 1, r - 1);
        } else {
            return Math.min(f1(s, l + 1, r), f1(s, l, r - 1)) + 1;
        }
    }


    // 递归之后的记忆化搜索.
    public static int minInsertions2(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f2(s, 0, n - 1, dp);
    }

    public static int f2(char[] s, int l, int r, int[][] dp) {
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        if (l == r) {
            return 0;
        }
        if (l + 1 == r) {
            return s[l] == s[r] ? 0 : 1;
        }
        int ans = 0;
        if (s[l] == s[r]) {
            ans = f2(s, l + 1, r - 1, dp);
        } else {
            ans = Math.min(f2(s, l + 1, r, dp), f2(s, l, r - 1, dp)) + 1;
        }
        dp[l][r] = ans;
        return ans;
    }


    // 严格位置依赖的动态规划实现.
    public static int minInsertions3(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[][] dp = new int[n][n];
        for (int l = 0; l < n - 1; l++) {
            dp[l][l + 1] = s[l] == s[l + 1] ? 0 : 1;
        }
        for (int l = n - 3; l >= 0; l--) {
            for (int r = l + 2; r < n; r++) {
                if (s[l] == s[r]) {
                    dp[l][r] = dp[l + 1][r - 1];
                } else {
                    dp[l][r] = Math.min(dp[l + 1][r], dp[l][r - 1]) + 1;
                }
            }
        }
        return dp[0][n - 1];
    }



    // 进行严格位置依赖的动态规划 + 空间压缩.
    // 值得注意的是：任何的空间压缩都是记忆上一列的。而不是记忆自己修改之后的值。
    public static int minInsertions4(String str) {
        char[] s = str.toCharArray();
        int n = s.length;
        int[] dp = new int[n];
        if (n < 2) {
            return 0;
        }
        dp[n - 1] = s[n - 2] == s[n - 1] ? 0 : 1;
        for (int l = n - 3; l >= 0; l--) {
            int leftDown = dp[l + 1];
            dp[l + 1] = s[l] == s[l + 1] ? 0 : 1;
            for (int r = l + 2; r < n; r++) {
                int backup = dp[r];
                if (s[l] == s[r]) {
                    dp[r] = leftDown;
                } else {
                    dp[r] = Math.min(dp[r], dp[r - 1]) + 1;
                }
                leftDown = backup;
            }
        }
        return dp[n - 1];
    }
}
