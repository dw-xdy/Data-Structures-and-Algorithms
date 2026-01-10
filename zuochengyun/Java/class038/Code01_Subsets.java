package class038;

import java.util.ArrayList;
import java.util.List;

// 一个整数数组的所有子集, 基本上可以说和上一个题目一样
// 数组中的所有元素各不相同, 返回所有可能的子集
// 测试链接：https://leetcode.cn/problems/subsets/description/

public class Code01_Subsets {

    // 下面的两种方式都是可以通过 LeetCode 上的测试的.
    // 只是记得要将对应函数后面的数字去掉就行.

    public List<List<Integer>> subsets1(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        f1(nums, 0, ans, path);
        return ans;
    }

    // 这个函数意义：收集好从i...开始所有的子集.
    public static void f1(int[] num, int i, ArrayList<List<Integer>> ans, ArrayList<Integer> path) {
        if (i == num.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 我的理解是：此时, 我要这个数字, 然后继续往后递归, 得出ans
        path.add(num[i]);
        f1(num, i + 1, ans, path);
        // 因为我先选择的是要这个数字, 所以我需要恢复现场.
        // 然后我又不要这个数字, 然后继续往后递归, 得出ans
        path.remove(path.size() - 1);
        f1(num, i + 1, ans, path);
    }

    public List<List<Integer>> subsets2(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        f2(nums, 0, new int[nums.length], 0, ans);
        return ans;
    }

    // 这个函数的意义：从 i 开始的所有子集都加入到 ans 中.
    public static void f2(int[] nums, int i, int[] path, int size, ArrayList<List<Integer>> ans) {
        if (i == nums.length) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                cur.add(path[j]);
            }
            ans.add(cur);
            return;
        }
        // 将新加入的元素加入到 path 路径收集信息中去.
        path[size] = nums[i];
        // 这里的意义是将从 i + 1 开始的所有子集都加入到 ans 中, 而且 size 管理 path 的大小.
        f2(nums, i + 1, path, size + 1, ans);
        // 这里的意义是将 i + 1 开始的所有子集都加入到 ans 中, 而且 size 管理 path 的大小.
        f2(nums, i + 1, path, size, ans);
    }


}
