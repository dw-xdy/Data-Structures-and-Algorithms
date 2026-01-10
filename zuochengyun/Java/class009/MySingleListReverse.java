package class009;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class MySingleListReverse {
    // 单链表节点
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

    // 反转单链表
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next = null;
        while (head != null) {
            //注意这里：赋值方面的问题(引用数据类型),
            //“=”号左边的是你要修改的地方, “=”右边的是你需要指向的地方.
            next = head.next;
            //next的问题说明：
            //若是将带着“next”的放到左边, 说明修改在本身(head)上修改,
            //若是将带着“next”的放到右边, 说明是将本身指向next指向的位置
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

//    public static ListNode reverseList(ListNode head) {
//        ListNode pre = null;
//        ListNode next = null;
//        while (head != null) {// 截止条件是head指向null;
//            next = head.next; // 1. 先将next指针指向下一个节点;
//            head.next = pre;  // 2. 然后将head指向的节点的指针指向上一个节点;
//            pre = head;       // 3. 然后将pre指针指向head指向的节点(作用是：为下一次的迭代做铺垫);
//            head = next;      // 4. 最后将head指针指向next指向的节点, 这样就可以进行下一次循环了.
//        }
//        return pre;
//    }


    // 打印链表
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 创建一个单链表: 1 -> 2 -> 3 -> 4 -> 5
        // 第一种方式
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);

        // 第二种方式
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        ListNode list3 = new ListNode(3);
        ListNode list4 = new ListNode(4);
        ListNode list5 = new ListNode(5);

        list1.next = list2;
        list2.next = list3;
        list3.next = list4;
        list4.next = list5;


        // 打印原始链表
        System.out.println("原始链表:");
        printList(list1);

        // 反转链表
        ListNode reversedHead = reverseList(list1);

        // 打印反转后的链表
        System.out.println("反转后的链表:");
        printList(reversedHead);
    }
}
