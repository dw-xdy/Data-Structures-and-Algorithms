package class038;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code02_Combinations {
    public static List<List<Integer>> combine1(int n, int k) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        f1(arr, 0, k, cur, ans);
        return ans;
    }

    public static void f1(int[] nums, int i, int k, ArrayList<Integer> path, ArrayList<List<Integer>> ans) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        if (i < nums.length) {
            path.add(nums[i]);
            f1(nums, i + 1, k, path, ans);
            path.remove(path.size() - 1);
            f1(nums, i + 1, k, path, ans);
        }
    }




    public static List<List<Integer>> combine2(int n, int k) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> cur = new ArrayList<>();
        f2(n, k, 1, cur, ans);
        return ans;
    }

    public static void f2(int n, int k, int startIndex, ArrayList<Integer> path, ArrayList<List<Integer>> ans) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            f2(n, k, i + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
