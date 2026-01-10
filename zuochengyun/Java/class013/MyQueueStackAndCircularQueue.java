package class013;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class MyQueueStackAndCircularQueue {

    class Queue {
        int[] queue;
        int l;
        int r;

        public void Queue(int n) {
            queue = new int[n];
        }

        // 插入一个数据
        public int queueIn(int num) {
            return queue[r++] = num;
        }

        // 弹出一个数据
        public int queueOut() {
            return queue[l++];
        }

        // 确定队列长度
        public int queueSize() {
            return r - l;
        }

        // 返回队列头部
        public int queueHead() {
            return queue[l];
        }

        // 返回队列尾部
        public int queueTail() {
            return queue[r - 1];
        }

        // 确认队列是不是“空”
        public boolean isEmpty() {
            return l == r;
        }
    }


    class Stack {
        int[] stack;
        int top = 0;
        public void Stack(int n) {
            stack = new int[n];
        }

        // 判断栈中是不是“空”
        public boolean isEmpty() {
            return top == 0;
        }

        // 栈中插入一个数据
        public int stackIn(int num) {
            return stack[top++];
        }

        // 栈中弹出一个数据
        public int stackOut() {
            return stack[--top];
        }

        // 返回栈中的顶部
        public int stackHead() {
            return stack[top - 1];
        }

        // 返回栈的底部
        public int stackTail() {
            return stack[0];
        }

        // 栈的大小
        public int stackSize() {
            return top;
        }
    }
}
