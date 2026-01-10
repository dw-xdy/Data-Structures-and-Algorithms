package class038;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class Code02_Combine {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        f(nums, 0, new int[nums.length], 0, ans);
        return ans;
    }

    // 思考：我传入 i 是为了找到从 i 开始的所有组合. 会通过 f() 这个函数给到我.
    public static void f(int[] nums, int i, int[] path, int size, List<List<Integer>> ans) {
        // 这里说明到达了终止位置
        if (i == nums.length) {
            ArrayList<Integer> cur = new ArrayList<>();
            // 既然已经到了终止位置, 那么接下来要做的就是将path中的所有东西都加入到cur中.
            for (int j = 0; j < size; j++) {
                cur.add(path[j]);
            }
            // 最后直接将cur加入ans.
            ans.add(cur);
        } else {
            // 下一组的第一个数的位置
            int j = i + 1;
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            // 此时 j 已经确定了, 所以后续的所有实现都是从 j 开始的所有组合都会通过 f() 这个函数给到我.
            // 当前数x，要0个
            f(nums, j, path, size, ans);
            // 当前数x，要1个、要2个、要3个...都尝试
            // 之后的所有情况都是要从 j 开始的东西, 但是 size 在增加, 因为我们需要放入 i 位置的数字.
            for (; i < j; i++) {
                // 这里我们先让 num[i] 位置的数字加入 path,
                path[size++] = nums[i];
                // 然后将之后的所有的实现都给 path 加上
                f(nums, j, path, size, ans);
            }
        }
    }


}
