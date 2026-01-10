package class034;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code05_LinkedListCycleII {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;    // 这里是为了保证链表中的前三个节点不为null, 因为这样才能继续后续的操作.
        }

        ListNode slow = head.next;      // 这里最开始不能设置为头节点, 因为若是这里设置为头节点,
        ListNode fast = head.next.next; // 后面的while循环的条件就始终为false了, 根本没办法进入.
        while (slow != fast) {
            if (fast.next == null || fast.next.next == null) {
                return null;            // 判断是不是一个无环的链表, 若是, 就直接返回null.
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
