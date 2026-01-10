package class045;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code02_TwoNumbersMaximumXor {
    public static int findMaximumXOR1(int[] nums) {
        build(nums);
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            ans = Math.max(ans, maxXor(num));
        }
        clear();
        return ans;
    }

    public static int cnt;

    public static int MANX = 3000001;

    public static int[][] tree = new int[MANX][2];

    public static int high;

    public static void build(int[] nums) {
        cnt = 1;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        high = 31 - Integer.numberOfLeadingZeros(max);
        for (int num : nums) {
            insert(num);
        }
    }


    public static void insert(int num) {
        int cur = 1;
        for (int i = high, path; i >= 0 ; i--) {
            path = (num >> i) & 1;
            if (tree[cur][path] == 0) {
                tree[cur][path] = ++cnt;
            }
            cur = tree[cur][path];
        }
    }

    public static int maxXor(int num) {
        int ans = 0;
        int cur = 1;
        for (int i = high, status, want; i >= 0; i--) {
            status = (num >> i) & 1;
            want = status ^ 1;
            if (tree[cur][want] == 0) {
                want ^= 1;
            }
            ans |= (status ^ want) << i;
            cur = tree[cur][want];
        }
        return ans;
    }

    public static void clear() {
        for (int i = 1; i <= cnt; i++) {
            tree[i][0] = tree[i][1] = 0;
        }
    }
}
