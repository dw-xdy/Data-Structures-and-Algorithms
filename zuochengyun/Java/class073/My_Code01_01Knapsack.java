package class073;


import java.io.*;
import java.util.Arrays;

public class My_Code01_01Knapsack {

    public static int MAXN = 101;

    public static int MAXM = 1001;

    public static int[] val = new int[MAXN];

    public static int[] time = new int[MAXN];

    public static int[] dp = new int[MAXM];

    public static int t, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            t = (int) in.nval;
            in.nextToken();
            m = (int) in.nval;
            for (int i = 1; i <= m; i++) {
                in.nextToken();
                time[i] = (int) in.nval;
                in.nextToken();
                val[i] = (int) in.nval;
            }
            out.println(f());
        }
        out.flush();
        br.close();
        out.close();
    }

    public static int f() {
        Arrays.fill(dp, 0, t + 1, 0);
        for (int i = 1; i <= m; i++) {
            for (int j = t; j >= time[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - time[i]] + val[i]);
            }
        }
        return dp[t];
    }
}
