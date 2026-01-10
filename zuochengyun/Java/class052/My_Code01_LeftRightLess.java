package class052;

import java.io.*;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code01_LeftRightLess {

    public static int MAXN = 1000001;

    public static int[] arr = new int[MAXN];

    public static int[] stack = new int[MAXN];

    public static int[][] ans = new int[MAXN][2];

    public static int n, r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            compute();
            for (int i = 0; i < n; i++) {
                out.println(ans[i][0] + " " + ans[i][1]);
            }
        }
        out.flush();
        out.close();
        br.close();
    }

    public static void compute() {
        r = 0;
        int cur;
        // 遍历阶段.
        for (int i = 0; i < n; i++) {
            while (r > 0 && arr[stack[r - 1]] >= arr[i]) {
                cur = stack[--r];
                ans[cur][0] = r > 0 ? stack[r - 1] : -1;
                ans[cur][1] = i;
            }
            stack[r++] = i;
        }
        // 清算阶段.
        while (r > 0) {
            cur = stack[--r];
            ans[cur][0] = r > 0 ? stack[r - 1] : -1;
            ans[cur][1] = -1;
        }
        // 修正阶段.
        for (int i = n - 2; i >= 0 ; i--) {
            if (ans[i][1] != -1 && arr[i] == arr[ans[i][1]]) {
                ans[i][1] = ans[ans[i][1]][1];
            }
        }
    }
}
