package class089;
public class CountBinaryStrings {

    // 检查5位中1的个数是否不超过3
    private static boolean check(int x) {
        int cnt = 0;
        for (int i = 0; i <= 4; ++i) {
            if (((x >> i) & 1) == 1) {
                cnt++;
            }
        }
        return cnt <= 3;
    }

    public static void main(String[] args) {
        // 使用long类型防止溢出
        // 表示长度为 i 的01串中，最后5位的状态为 j（用5位二进制表示）的所有合法串的数量。
        long[][] dp = new long[26][32]; // 26行对应长度0-25，40列足够覆盖0-31的状态

        // 初始条件：长度为1时，可以是0或1
        dp[1][0] = 1;
        dp[1][1] = 1;

        // 动态规划计算
        for (int i = 2; i <= 24; ++i) {
            for (int j = 0; j <= 31; ++j) {
                if (dp[i - 1][j] != 0) {
                    // 尝试添加1
                    int t1 = (((j << 1) | 1) & 31);
                    if (check(t1)) {
                        dp[i][t1] += dp[i - 1][j];
                    }

                    // 尝试添加0
                    int t2 = (((j << 1)) & 31);
                    if (check(t2)) {
                        dp[i][t2] += dp[i - 1][j];
                    }
                }
            }
        }

        // 计算结果
        long ans = 0;
        for (int i = 0; i <= 31; ++i) {
            ans += dp[24][i];
        }

        System.out.println("满足条件的01串数量为: " + ans);
    }
}