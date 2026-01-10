package class039;

import java.util.ArrayList;

// 不含有嵌套的表达式求值
// 和有嵌套的相比较, 算是比较简单的, 思路几乎可以说一模一样.
// 而且带有嵌套的题目本身就是这个题目的进阶版本,
// 测试链接：https://leetcode.cn/problems/basic-calculator-ii/description/

public class Code01_BasicCalculatorII {
    public static int calculate(String s) {
        return f(s.toCharArray(), 0);
    }

    public static int f(char[] s, int i) {
        int cur = 0;
        ArrayList<Integer> num = new ArrayList<>();
        ArrayList<Character> op = new ArrayList<>();
        while (i < s.length) {
            if (s[i] >= '0' && s[i] <= '9') {
                cur = cur * 10 + s[i++] - '0';
            } else if (s[i] == ' ') {
                i++;
            } else {
                push(num, op, cur, s[i++]);
                cur = 0;
            }
        }
        push(num, op, cur, '+');
        return compute(num, op);
    }


    public static void push(ArrayList<Integer> num, ArrayList<Character> op, int number, char symbol) {
        int n = num.size();
        if (n == 0 || op.getLast() == '+' || op.getLast() == '-') {
            num.add(number);
            op.add(symbol);
        } else {
            if (op.getLast() == '*') {
                num.set(n - 1, num.get(n - 1) * number);
            } else {
                num.set(n - 1, num.get(n - 1) / number);
            }
            op.set(n - 1, symbol);
        }
    }

    public static int compute(ArrayList<Integer> num, ArrayList<Character> op) {
        int n = num.size();
        int ans = num.get(0);
        for (int i = 1; i < n; i++) {
            ans += op.get(i - 1) == '+' ? num.get(i) : - num.get(i);
        }
        return ans;
    }
}
