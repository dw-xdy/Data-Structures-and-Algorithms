package class036;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code08_CompletenessOfBinaryTree {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

//    public static int MAXN = 1001;
//
//    public static TreeNode[] treeQueue = new TreeNode[MAXN];
//
//    public static int[] idQueue = new int[MAXN];
//
//    public static int l, r;
//
//    public static boolean ans = true;
//
//
//    public static boolean isCompleteTree(TreeNode root) {
//        if (root != null) {
//            l = r = 0;
//            treeQueue[r] = root;
//            int i = 1;
//            idQueue[r++] = i;
//            while (l < r) {
//                TreeNode cur = treeQueue[l];
//                int id = idQueue[l++];
//                if (cur.left != null) {
//                    treeQueue[r] = cur.left;
//                    idQueue[r++] = i * 2;
//                }
//                if (cur.right != null) {
//                    treeQueue[r] = cur.right;
//                    idQueue[r++] = i * 2 + 1;
//                }
//            }
//        }

    public static int MAXN = 1001;

    public static TreeNode[] treeNode = new TreeNode[MAXN];  // nodeQueue 用来存储树节点.

    public static int[] idQueue = new int[MAXN];   // idQueue 用来存储节点的编号

    public static int l, r;

    public static boolean ans = true;

    public static boolean isCompleteTree(TreeNode root) {
        l = r = 0;
        treeNode[r] = root;  // 先将根节点放入到 节点队列中.
        idQueue[r++] = 1;   // 并且同时将对应的编号放入到 编号队列中. 我们给根节点设置的编号是：1.
        while (l < r) {
            int size = r - l;
            for (int i = 0; i < size; i++) {
                TreeNode node = treeNode[l];
                int id = idQueue[l++];
                if (node.left != null) {
                    treeNode[r] = node.left;
                    idQueue[r++] = id * 2;
                }
                if (node.right != null) {
                    treeNode[r] = node.right;
                    idQueue[r++] = id * 2 + 1;
                }
            }
        }

        if (idQueue[r - 1] != r) {
            ans = false;
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);
        System.out.println(isCompleteTree(root));

    }
}
