package class012;

/**
 * @author 冯肖伟
 * @version 1.0
 */

public class MyPartitionList {
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

    public static void main(String[] args) {
        // 创建链表 1 -> 4 -> 3 -> 2 -> 5 -> 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);


        int x = 3;
        ListNode partitionedHead = Solution.partition(head, x);

        // 打印分区后的链表
        ListNode current = partitionedHead;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    class Solution {

//        public static ListNode partition(ListNode head, int x) {
//            ListNode leftHead = null, leftTail = null;
//            ListNode rightHead = null, rightTail = null;
//            ListNode next = null;
//
//            while (head != null) {
//                    next = head.next;
//                    head.next = null;
//                if (head.val < x) {
//                    if (leftHead == null) {
//                        leftHead = head;
//                        leftTail = head;
//                    } else {
//                        leftTail.next = head;
//                        leftTail = leftTail.next;
//                    }
//                } else {
//                    next = head.next;
//                    head.next = null;
//                    if (rightHead == null) {
//                        rightHead = head;
//                        rightTail = head;
//                    } else {
//                        rightTail.next = head;
//                        rightTail = rightTail.next;
//                    }
//                }
//                head = next;
//            }
//
//            if (leftHead == null) {
//                return rightHead;
//            }
//            leftTail.next = rightHead;
//            return leftHead;
//        }



        public static ListNode partition(ListNode head, int x) {
            ListNode leftHead = null, leftTail = null; // < x的区域
            ListNode rightHead = null, rightTail = null; // >=x的区域
            ListNode next = null;

            while (head != null) {
                next = head.next;
                head.next = null;
                if (head.val <= x) {
                    if (leftHead == null) {
                        leftHead = head;
                    } else {
                        leftTail.next = head;
                    }
                    leftTail = head;
                } else {
                    if (rightHead == null) {
                        rightHead = head;
                    } else {
                        rightTail.next = head;
                    }
                    rightTail = head;
                }
                head = next;
            }
            if (leftHead == null) {
                return rightHead;
            }
            // < x的区域有内容！
            leftTail.next = rightHead;
            return leftHead;
        }



//        public static ListNode partition(ListNode head, int x) {
//            ListNode leftHead = null, leftTail = null; // < x的区域   设计一个“小头”, “小尾”;
//            ListNode rightHead = null, rightTail = null; // >=x的区域 设计一个“大头”, “大尾”;
//            ListNode next = null;  // 设计一个“next指针”, 方便“head”的下一步跳转,
//
//            while (head != null) {       // 循环停止条件是：当“head节点”指向“null”的时候
//                next = head.next;        // 将“next”指针指向“head”节点指向的节点.
//                head.next = null;        // 然后将“head”节点设置为null.
//                if (head.val <= x) {     // 若是“head.val“小于给定的“值x”, 这时候进入“< x”的区域
//                    if (leftHead == null) {  // 若是此时“小头, 小尾”都是“null”
//                        leftHead = head;     // 就让“小头, 小尾”都指向这个节点.
//                    } else {                 // 若是此时只有“小尾”是“null”.
//                        leftTail.next = head; // 这个时候就直接让“小尾”的下一个节点指向head.
//                    }                         // 然后将“小尾”指向“head(当前节点)”.
//                    leftTail = head;    // 这段代码的意义写的很巧妙.反正无论什么情况都是要将小尾(大尾)
//                                        // 指向当前节点的. 所以直接将其放到外面.
//                } else {
//                    if (rightHead == null) {   // 后面的代码中和上面的分析过程是一样的.
//                        rightHead = head;      // 直接“照猫画虎”就行了
//                    } else {
//                        rightTail.next = head;
//                    }
//                    rightTail = head;
//                }
//                head = next;                 // 这个时候“next”指针意义就有了, 为了让“head”向下跳转.
//            }
//            if (leftHead == null) {          // 若是“小头”为“null”, 就直接返回“大头”
//                return rightHead;
//            }
//            // < x的区域有内容！
//            leftTail.next = rightHead;    // 将“小尾”连接到“大尾”, 这样就成了一个链表了
//            return leftHead;              // 最后返回“小头”.
//        }




    }
}
