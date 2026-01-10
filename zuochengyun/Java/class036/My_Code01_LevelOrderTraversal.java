package class036;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code01_LevelOrderTraversal {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;
    }

    public static int MAXN = 2001;

    public static TreeNode[] queue = new TreeNode[MAXN];

    public static int l, r;

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root != null) {
            l = r = 0;
            queue[r++] = root;

            // 这里的做法是将两个功能分开做了, 只是左程云老师的做法是将两个合在了一起.
            while (l < r) {
                int size = r - l;
                // 这里先设置一个list变量. 用来装内层的树节点.
                List<Integer> list = new ArrayList<>();
                // 这里将这一层的所有树节点都放到队列中, 然后将对应的值放到arraylist中.
                for (int i = l; i < r; i++) {
                    TreeNode cur = queue[i];
                    list.add(cur.val);
                }  // 最后将这一层放到最外层的list中.
                ans.add(list);
                // 然后执行 将这一层的下一层节点放入到队列中的操作.
                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue[l++];
                    if (cur.left != null) {
                        queue[r++] = cur.left;
                    }
                    if (cur.right != null) {
                        queue[r++] = cur.right;
                    }
                }
            }
        }
        return ans;
    }


}
