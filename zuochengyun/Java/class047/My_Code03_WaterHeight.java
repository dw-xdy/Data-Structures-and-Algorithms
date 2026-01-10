package class047;

import java.io.*;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code03_WaterHeight {

    public static int n, m;

    public static int MAXN = 1000001;

    public static int OFFSET = 30001;

    public static int[] arr = new int[OFFSET + MAXN + OFFSET];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int)in.nval;
            in.nextToken();
            m = (int)in.nval;
            for (int i = 0, v, x; i < n; i++) {
                in.nextToken(); v = (int)in.nval;
                in.nextToken(); x = (int)in.nval;
                fall(v, x);
            }
            build();
            int start = OFFSET + 1;
            out.print(arr[start++]);
            for (int i = 2; i <= m; i++) {
                out.print(" " + arr[start++]);
            }

        }
        out.flush();
        out.close();
        br.close();
    }


    public static void fall(int v, int x) {
        set(x - 3 * v, x - 2 * v, 0, v, 1);
        set(x - 2 * v, x, v, -v, -1);
        set(x, x + 2 * v, -v, v, 1);
        set(x + 2 * v, x + 3 * v, v, 0, -1);
    }

    public static void set(int l, int r, int s, int e, int d) {
        arr[l + OFFSET] += s;
        arr[l + 1 + OFFSET] += d - s;
        arr[r + 1 + OFFSET] -= d + e;
        arr[r + 2 + OFFSET] += e;
    }



    public static void build() {
        for (int i = 1; i <= m + OFFSET; i++) {
            arr[i] = arr[i - 1];
        }
        for (int i = 1; i <= m + OFFSET; i++) {
            arr[i] = arr[i - 1];
        }
    }
}
