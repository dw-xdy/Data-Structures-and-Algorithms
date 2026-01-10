package class078;

import java.io.*;
import java.util.HashMap;

public class Main {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

        HashMap<Integer, TreeNode> map = new HashMap<>();

        // 读取n和rootVal
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int rootVal = (int) in.nval;

        // 构建二叉树
        TreeNode root = new TreeNode(rootVal);
        map.put(rootVal, root);

        for (int i = 0; i < n; i++) {
            in.nextToken();
            int nodeVal = (int) in.nval;
            in.nextToken();
            int leftVal = (int) in.nval;
            in.nextToken();
            int rightVal = (int) in.nval;

            TreeNode node = map.get(nodeVal);
            if (leftVal != 0) {
                node.left = new TreeNode(leftVal);
                map.put(leftVal, node.left);
            }
            if (rightVal != 0) {
                node.right = new TreeNode(rightVal);
                map.put(rightVal, node.right);
            }
        }

        // 求解并输出
        out.println(largestBSTSubtree(root));
        out.flush();
        br.close();
        out.close();
    }

    public static int largestBSTSubtree(TreeNode root) {
        return f(root).maxBstSize;
    }

    public static class Info {
        public long max;
        public long min;
        public boolean isBst;
        public int maxBstSize;

        public Info(long a, long b, boolean c, int d) {
            max = a;
            min = b;
            isBst = c;
            maxBstSize = d;
        }
    }

    public static Info f(TreeNode x) {
        if (x == null) {
            return new Info(Long.MIN_VALUE, Long.MAX_VALUE, true, 0);
        }
        Info infol = f(x.left);
        Info infor = f(x.right);

        long max = Math.max(x.val, Math.max(infol.max, infor.max));
        long min = Math.min(x.val, Math.min(infol.min, infor.min));
        boolean isBst = infol.isBst && infor.isBst && infol.max < x.val && x.val < infor.min;
        int maxBSTSize = isBst ? infol.maxBstSize + infor.maxBstSize + 1 : Math.max(infol.maxBstSize, infor.maxBstSize);

        return new Info(max, min, isBst, maxBSTSize);
    }
}