package class038;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code03_Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        f(nums, 0, ans);
        return ans;
    }

    // 这个函数的意义是将从 i 开始的所有数字的排列全部返回
    public static void f(int[] nums, int i, ArrayList<List<Integer>> ans) {
        if (i == nums.length) {
            ArrayList<Integer> cur = new ArrayList<>();
            for (int num : nums) {
                cur.add(num);
            }
            ans.add(cur);
            return;
        }
        for (int j = i; j < nums.length; j++) {
            swap(nums, i, j);
            f(nums, i + 1, ans);
            swap(nums, i, j);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        List<List<Integer>> ans = permute(nums);
        for (List<Integer> list : ans) {
            for (int num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
