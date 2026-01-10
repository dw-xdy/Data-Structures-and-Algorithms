package class010;

import class009.MySingleListReverse;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class MyMergeTwoLists {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }



    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }


    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        ListNode head = head1.val <= head2.val ? head1 : head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head == head1 ? head2 : head1;
        ListNode pre = head;
        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                pre.next = cur1;
                cur1 = cur1.next;
            } else {
                pre.next = cur2;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }

//	public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
//		if (head1 == null || head2 == null) {
//			return head1 == null ? head2 : head1; // 若是h1为空, 就直接返回h2, 毕竟一个都是空的了,
//		}                                         // 只能返回另一个了,说明只传递过来一个链表,
//		       									  // 没有合并的必要了.
//
//		ListNode head = head1.val <= head2.val ? head1 : head2; // 比较传进来的两个链表的头节点哪一个小,
//		                                                        // 哪一个值小, 哪个就当合并之后的头结点.
//		ListNode cur1 = head.next;           // cur1 指向的是“合并”的头结点“head”的下一个节点.
//		ListNode cur2 = head == head1 ? head2 : head1; // cur2 指向的是另一个不是总头结点的“头结点”.
//		ListNode pre = head;                 // pre 的意思还是“上一个”, 所以一直跟着对应的已经排好序的节点.
//		while (cur1 != null && cur2 != null) { // 只有“cur1”和“cur2”同时不为空才能进行循环.
//			if (cur1.val <= cur2.val) {
//				pre.next = cur1;           // 这一段while循环中, 看哪一个“cur”比较小
//				cur1 = cur1.next;          // 就将这个作为“总链表”的下一个节点,
//			} else {                       // 又因为“pre”作为一个当前对应的节点, 所以直接进行指向等操作即可
//				pre.next = cur2;           // 然后将比较小的“cur”进行移动, 指向当前链表的下一个节点
//				cur2 = cur2.next;          // 最后“pre”也进行移动, 也指向对应的已经排好序的一个节点.
//			}
//			pre = pre.next;
//		}
//		pre.next = cur1 != null ? cur1 : cur2; // 最后, 无论怎么进行排序, “cur1和cur2”一定会有一个不为空,
//		return head;                           // 这个时候就直接让“pre”指向不是空的那一个节点.
//	}
    // 哪怕是很极端的链表也是可以进行执行的,
    // 比如 第一个链表是：1 -> 2 -> 3 -> 4, 另一个是 5 -> 6 -> 7 -> 8;
    // 这样就相当于只移动“cur1”, 所以之后就直接移动到另一个链表的“5”了, 直接就可以进行连接.

    public static void main(String[] args) {
        // 创建第一个链表: 1 -> 3 -> 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);

        printList(head1);

        // 创建第二个链表: 2 -> 4 -> 6
        ListNode head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        printList(head2);

        // 合并两个链表
        ListNode mergedHead = mergeTwoLists(head1, head2);

        // 打印合并后的链表: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        while (mergedHead != null) {
            System.out.print(mergedHead.val + " -> ");
            mergedHead = mergedHead.next;
        }
        System.out.println("null");
    }

}






