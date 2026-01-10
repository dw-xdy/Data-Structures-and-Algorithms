package class038;

import java.util.HashSet;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code01_Subsequences {

    // 经典写法：
    public static String[] generatePermutation1(String str) {
        char[] s = str.toCharArray();
        HashSet<String> set = new HashSet<>();
        f1(s, 0, new StringBuilder(), set);
        int m = set.size();
        String[] ans = new String[m];
        int i = 0;
        for (String cur : set) {
            ans[i++] = cur;
        }
        return ans;
    }


    // s[i...]: 当前字符串所在的位置.
    // 之前决定的路径path，
    // set收集结果时去重.
    public static void f1(char[] s, int i, StringBuilder path, HashSet<String> set) {
        if (i == s.length) {
            set.add(path.toString());
            return;
        }
        // 我先执行的操作是：选择这个字符
        path.append(s[i]);
        // 我既然已经选择了收集这个字符, 那么我进入到下一个字符的收集或者不收集就行了.
        f1(s, i + 1, path, set);
        // 到现在已经返回来了, 那么我接下来操作的应该是不收集的, 因为我刚刚已经收集了, path中已经还有了.
        // 所以我需要删除添加的那一个.
        path.deleteCharAt(path.length() - 1);
        // 然后我就可以执行不选择的那一个操作了.
        f1(s, i + 1, path, set);
    }



    public static String[] generatePermutation2(String str) {
        char[] s = str.toCharArray();
        HashSet<String> set = new HashSet<>();
        f2(s, 0, new char[s.length], 0, set);
        int m = set.size();
        int i = 0;
        String[] ans = new String[m];
        for (String cur : set) {
            ans[i++] = cur;
        }
        return ans;
    }

    // 注意一下这里传进来的path, path在传进来的时候长度就已经确定了, 是字符串的长度
    // 但是对应的, size是用来管理path的大小的, 而且从下面的代码中也能看出来,
    // 加入到set中的数组是：0 ~ size 的大小.
    public static void f2(char[] s, int i, char[] path, int size, HashSet<String> set) {
        if (i == s.length) {
            set.add(String.valueOf(path, 0, size));
            return;
        }
        path[size] = s[i];
        f2(s, i + 1, path, size + 1, set);
        f2(s, i + 1, path, size, set);
    }




}
