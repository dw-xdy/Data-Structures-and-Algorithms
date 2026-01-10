package class034;

import java.util.List;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code02_ReverseNodesInkGroup {
    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    // 提交如下的方法
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;            // 设置start为head, 后续需要这个.
        ListNode end = teamEnd(start, k);  // end节点是这一组的最后一个节点.
        if (end == null) {
            return head;      // 若是最后end == null, 说明这一组没有 k 个节点, 所以直接返回head就行了.
        }
        // 第一组很特殊因为牵扯到换头的问题
        head = end;                     // 此时说明end != null, 所以将head指向end, 因为需要翻转这组链表了.
        reverse(start, end);            // 翻转这组链表.
        // 翻转之后start变成了上一组的结尾节点
        ListNode lastTeamEnd = start;
        while (lastTeamEnd.next != null) {    // 这段循环的终止条件是上一组的结尾节点的下一个节点是null.
            start = lastTeamEnd.next;         // 此时下一组的开始节点是上一组的结尾节点的下一个节点
            end = teamEnd(start, k);          // end是这一组的下一个节点.
            if (end == null) {
                return head;            // 还是按照上述的方式, 此时说明这一组链表没有k个节点, 直接返回
            }
            reverse(start, end);      // 翻转这个链表.
            lastTeamEnd.next = end;   // 这一组的最后一个节点的指向的下一个节点修改为end
            lastTeamEnd = start;      // 然后将这一组的最后一个节点修改为start.
        }
        return head;  // 最后返回head.
    }

    // 当前组的开始节点是s，往下数k个找到当前组的结束节点返回
    public static ListNode teamEnd(ListNode s, int k) {
        while (--k != 0 && s != null) {
            s = s.next;          // 这个就不多解释了, 直接看就能明白
        }
        return s;
    }

    // s -> a -> b -> c -> e -> 下一组的开始节点
// 上面的链表通过如下的reverse方法调整成 : e -> c -> b -> a -> s -> 下一组的开始节点
    public static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null, cur = start, next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;                // 这个就是之前讲过的翻转链表的问题, 只是增加了指向下一个组的开始节点.
            cur = next;
        }
        start.next = end;
    }


    public static ListNode swapPairs(ListNode head) {
        ListNode start = head;
        ListNode end = start.next;
        while (start != null) {
            swap(start, end);
            start = end.next;
        }

       return head;
    }

    public static void swap(ListNode node1, ListNode node2) {

    }
}
