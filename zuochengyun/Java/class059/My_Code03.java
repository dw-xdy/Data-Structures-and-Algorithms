package class059;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;

public class My_Code03 {

    public static int MAXN = 100001;

    public static int MAXM = 100001;

    public static int cnt;

    public static int n, m;

    public static int f, t;

    public static int[] head = new int[MAXN];

    public static int[] next = new int[MAXM];

    public static int[] to = new int[MAXM];

    public static int[] indegree = new int[MAXN];

    public static int[] ans = new int[MAXN];

    public static PriorityQueue<Integer> heap = new PriorityQueue<>();

    public static void build() {
        cnt = 1;
        Arrays.fill(head, 0, n + 1, 0);
        Arrays.fill(indegree, 0, n + 1, 0);
    }


    public static void addEdge() {
        next[cnt] = head[f];
        to[cnt] = t;
        head[f] = cnt++;
        indegree[t]++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            n = (int) in.nval;
            build();
            in.nextToken();
            m = (int) in.nval;
            for (int i = 0; i < m; i++) {
                in.nextToken();
                f = (int) in.nval;
                in.nextToken();
                t = (int) in.nval;
                addEdge();
            }
            topoSort();
            for (int i = 0; i < n -1; i++) {
                out.print(ans[i] + " ");
            }
            out.println(ans[n - 1]);
            out.flush();
         }

        br.close();
        out.close();
    }


    public static void topoSort() {
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                heap.add(i);
            }
        }
        int fill = 0;
        while (!heap.isEmpty()) {
            int cur = heap.poll();
            ans[fill++] = cur;
            for (int ei = head[cur]; ei > 0; ei = next[ei]) {
                if (--indegree[to[ei]] == 0) {
                    heap.add(to[ei]);
                }
            }
        }
    }
}