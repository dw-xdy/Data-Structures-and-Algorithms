package class036;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code03_WidthOfBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static int MAXN = 3001;

    public static TreeNode[] nodeQueue = new TreeNode[MAXN];

    public static int[] idQueue = new int[MAXN];

    public static int l, r;

    public static int widthOfBinaryTree(TreeNode root) {
        l = r = 0;
        int ans = 1;
        idQueue[r] = 1;
        nodeQueue[r++] = root;

        while (l < r) {
            int size = r - l;
            ans = Math.max(ans, idQueue[r - 1] - idQueue[l] + 1);

            for (int i = 0; i < size; i++) {
                TreeNode cur = nodeQueue[l];
                int id = idQueue[l++];
                if (cur.left != null) {
                    idQueue[r] = id * 2;
                    nodeQueue[r++] = cur.left;
                }
                if (cur.right != null) {
                    idQueue[r] = id * 2 + 1;
                    nodeQueue[r++] = cur.right;
                }
            }
        }
        return ans;
    }

}
