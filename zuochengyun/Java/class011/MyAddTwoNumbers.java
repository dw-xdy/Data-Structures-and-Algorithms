package class011;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class MyAddTwoNumbers {

    // 定义ListNode类
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 定义Solution类
    static class Solution {

        // 也可以复用老链表
        // 不过这个实现没有这么做，都是生成的新节点(为了教学好懂)
        public static ListNode addTwoNumbers(ListNode h1, ListNode h2) {
            ListNode ans = null, cur = null;
            int carry = 0;
            for (int sum, val; // 声明变量
                 h1 != null || h2 != null; // 执行条件
                 h1 = h1 == null ? null : h1.next, // 每一步h1的跳转
                         h2 = h2 == null ? null : h2.next // 每一步h2的跳转
            ) {

                sum = (h1 == null ? 0 : h1.val)
                        + (h2 == null ? 0 : h2.val)
                        + carry;

                val = sum % 10;
                carry = sum / 10;
                if (ans == null) {
                    ans = new ListNode(val);
                    cur = ans;
                } else {
                    cur.next = new ListNode(val);
                    cur = cur.next;
                }
            }
            if (carry == 1) {
                cur.next = new ListNode(1);
            }
            return ans;
        }
    }

//    public static ListNode addTwoNumbers(ListNode h1, ListNode h2) {
//        ListNode ans = null, cur = null;   //定义两个链表节点, 其中：ans是最开始的节点. cur作为跟踪的节点.
//        int carry = 0; // carry是“进位”的意思, 为了适应两个节点的数字相加 >= 10的情况; 所以“carry”不是“1”就是“0”
//        for (int sum, val; // 声明变量
//             h1 != null || h2 != null; // 执行条件  // 只有当h1 和 h2同时为null才停止for循环.
//             h1 = h1 == null ? null : h1.next, // 每一步h1的跳转
//                     h2 = h2 == null ? null : h2.next // 每一步h2的跳转
//        ) {
//
//            sum = (h1 == null ? 0 : h1.val)
//                    + (h2 == null ? 0 : h2.val)  // sum = 对应的节点值相加 + 可能的进位.
//                    + carry;
//
//            val = sum % 10;          // val 是最后的值, 只用留下“个位”的就行.
//            carry = sum / 10;        // carry 是进位, 所以要留下“十位”.
//            if (ans == null) {             // 当ans为空的时候, 也就是说：当“个位数”相加的时候
//                ans = new ListNode(val);   // 创建一个新的链表节点, ans作为一个头, 其中存放val.
//                cur = ans;                 // 此时“cur”也是指向ans;
//            } else {                          // 当ans不为空的时候, 也就是说：“除了个位数”相加的时候
//                cur.next = new ListNode(val);  // 创建一个新的链表节点, cur指向创建的新节点
//                cur = cur.next;                // cur继续指向下一个链表节点.
//            }
//        }
//        if (carry == 1) {                // 这里是表示“两个链表的最后两个节点数字相加, 若是有相加 >= 10的情况.
//            cur.next = new ListNode(1);  // 创建一个新的链表节点, cur指向创建的新节点, 里面存放的肯定是“1”
//        }
//        return ans;                   //最后返回头结点“ans”, ans是永远不动的.
//    }


    // 辅助方法：打印链表
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }



    // 这个是while版本的写法, 感觉和for循环的基本上是一样的, 没有什么特别的变换,本来也是这样的.
    public static ListNode AddTwoNumbers(ListNode h1, ListNode h2) {
        ListNode ans = null, pre = null;
        int carry = 0;

        while (h1 != null || h2 != null) {
            int sum = 0;
            sum = (h1 == null ? 0 : h1.val) +
                  (h2 == null ? 0 : h2.val) +
                  carry;

            int val = sum % 10;
            carry = sum / 10;

            if (ans == null) {
                ans = new ListNode(val);
                pre = ans;
            } else {
                pre.next = new ListNode(val);
                pre = pre.next;
            }

            h1 = h1 != null ? h1.next : null;
            h2 = h2 != null ? h2.next : null;
        }

        if (carry == 1) {
            pre.next = new ListNode(1);
        }

        return ans;
    }

    public static void main(String[] args) {
        // 创建链表1: 2 -> 4 -> 3
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        // 创建链表2: 5 -> 6 -> 9
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(9);

        // 调用addTwoNumbers方法
        ListNode result = Solution.addTwoNumbers(l1, l2);

        // 打印结果链表
        System.out.print("Result: ");
        printList(result);
    }
}






