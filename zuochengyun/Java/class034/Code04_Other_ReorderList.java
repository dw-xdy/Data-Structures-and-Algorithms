package class034;

/**
 * @author 冯肖伟
 * @version 1.0
 */

// 重排链表
// 测试链接：https://leetcode.cn/problems/reorder-list/
public class Code04_Other_ReorderList {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reorderList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = reverse(slow.next, slow);
        slow.next = null;
        ListNode left = head;
        ListNode next = null;
        while (left != null && right != null) {
            next = left.next;
            left.next = right;
            right = right.next;
            left.next.next = next;
            left = next;
        }
        return head;
    }


    // 我单独实现了一个翻转链表的函数, 在这个题目中, 这个connectNode 对应的是 slow 节点
    // 若是不加入一个connectNode节点, 会将这个链表断开, 无论是奇数个数还是偶数个数的链表
    // 比如：不加的情况：1 -> 2 -> 3 -> 4 会变成：1 -> 2 -> null  3 <- 4 这样2, 3节点之间会断开,
    // 加入了这个connect之后：1 -> 2 -> 3 -> 4 会变成：1 -> 2 <- 3 <- 4, 2 -> null, 这样就不会断开了.
    public static ListNode reverse(ListNode head, ListNode connectNode) {
        ListNode pre = connectNode;
        ListNode next = null;

        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
