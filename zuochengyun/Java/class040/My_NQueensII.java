package class040;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_NQueensII {
    public static int totalNQueens2(int n) {
        if (n < 1) {
            return 0;
        }
        int limit = (1 << n) - 1;
        return f(limit, 0, 0, 0);
    }


    public static int f(int limit, int col, int left, int right) {
        if (col == limit) {
            return 1;
        }
        int ban = col | left | right;
        int candidate = limit & (~ban);
        int ans = 0;
        int place = 0;
        while (candidate != 0) {
            place = candidate & (-candidate);
            candidate ^= place;
            ans += f(limit, col | place, (left | place) >> 1, (right | place) << 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        int n = 4;
        System.out.println(totalNQueens2(4));
    }
}
