package class038;

import java.util.ArrayList;
import java.util.List;

// LeetCode : 17. 电话号码的字母组合
// 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
// 测试链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/
public class phone {

    private static final String[] MAPPING =
            new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private final List<String> ans = new ArrayList<>();
    private char[] digits;
    private char[] path;

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        if (n == 0) {
            return List.of();
        }
        this.digits = digits.toCharArray();
        path = new char[n]; // 注意 path 长度一开始就是 n，不是空数组
        f(0);
        return ans;
    }


    // 这个函数的意义是：从i...开始所有的字符都枚举好.
    private void f(int i) {
        if (i == digits.length) {
            ans.add(new String(path));
            return;
        }
        for (char c : MAPPING[digits[i] - '0'].toCharArray()) {
            path[i] = c; // 直接覆盖
            f(i + 1);
        }
    }

}
