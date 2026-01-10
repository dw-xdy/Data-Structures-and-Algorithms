package class037;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code02_LowestCommonAncestorBinarySearch {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != p && root != q) {
            if (root.val > Math.min(p.val, q.val) && root.val < Math.max(p.val, q.val)) {
                break;
            }
            root = root.val > Math.max(p.val, q.val) ? root.left : root.right;
        }

        return root;
    }
}
