package class096;

import java.util.Arrays;

public class SG {
    public static int[] sg1(int n, int m) {
        int[] sg = new int[n + 1];
        boolean[] appear = new boolean[m + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(appear, false);
            for (int j = 1; j <= m && i - j >= 0; j++) {
                appear[sg[i - j]] = true;
            }
            for (int s = 0; s <= m; s++) {
                if (!appear[s]) {
                    sg[i] = s;
                    break;
                }
            }
        }
        return sg;
    }


    // 对应的 Bash Game 的修改版本, 是可以通过的
    // 是在只有一个ICG游戏进行的情况下的修改版本.
    public static boolean canWinNim(int n) {
        int m = 3;
        boolean[] sg = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m && i - j >= 0; j++) {
                if (!sg[i - j]) {
                    sg[i] = true;
                    break;
                }
            }
        }
        return sg[n];
    }


    public static boolean[] sg(int n, int m) {
        boolean[] sg = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!sg[i - j]) {
                    sg[i] = true;
                    break;
                }
            }
        }
        return sg;
    }


    public static int sg3(int n) {
        int[] sg = new int[n + 1];
        boolean[] appear = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(appear, false);
            for (int j = 1; j * j <= i; j++) {
                appear[sg[i - j * j]] = true;
            }
            for (int s = 0; s <= n; s++) {
                if (!appear[s]) {
                    sg[i] = s;
                    break;
                }
            }
        }
        return sg[n];
    }

    public static boolean sg4(int n) {
        boolean[] sg = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (!sg[i - j * j]) {
                    sg[i] = true;
                    break;
                }
            }
        }
        return sg[n];
    }


    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return (nums[n - 1] - 1) * (nums[n - 2] - 1);
    }
}
