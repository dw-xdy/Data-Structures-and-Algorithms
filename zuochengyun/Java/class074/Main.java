package class074;

import java.io.*;

public class Main {

    public static int MAXN = 100001;

    public static int n;

    public static int num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                in.nextToken();
                num = (int) in.nval;
                if (num % 9 == 0 && num % 8 != 0) {
                    ans++;
                }
            }
            out.println(ans);
            out.flush();
        }
        out.flush();
        out.close();
        br.close();
    }

}