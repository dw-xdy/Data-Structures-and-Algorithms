package class038;

import java.util.Stack;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code06_SortStackWithRecursive {
    public static int deep(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return 0;
        }
        int num = stack.pop();
        int deep = deep(stack) + 1;
        stack.add(num);
        return deep;
    }
}
