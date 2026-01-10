package class006;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My01_FindNumber {
    // 实现“二分搜索”
    public static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        int l = 0, r = arr.length - 1, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (arr[m] == num) {
                return true;
            } else if (arr[m] > num) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }








//    public static boolean exist(int [] arr, int num) {
//        if (arr == null || arr.length == 0) {      // 若是穿进来的数组为“null”或者是“数组长度为0”
//              return false;                        // 就直接返回“false”.
//        }
//        int l = 0;                // 设置一个左边界, 是“0”, 因为数组是从“0”开始的.
//        int r = arr.length - 1;   // 设置一个右边界, 是“arr.length - 1”, 因为数组的最后一个数据的下标是“arr.length - 1”;
//        int m = 0;                // 中间位置.
//        while (l <= r) {             // 终止条件：若是左边界都小于等于右边界了, 那自然就没有了.
//            m = l + ((r - l) >> 1);  // m = (l + r) / 2, 这个是中间位置.
//            if (arr[m] == num) {      // 若是 arr[m] == num, 说明这个数组中存在和 num 相等的值,
//                return true;          // 此时返回 true.
//            } else if (arr[m] > num) { // 若是 arr[m] > num, 说明这个数组右边的所有数字(包括 arr[m])都比 num 大,
//                r = m - 1;           // 然后将 r(右边界)调整为：r = m - 1, 因为 arr[m] 这个数字本身都比 num 大.
//            } else {                 // 若是 arr[m] < num, 说明这个数组左边的所有数字(包括 arr[m]) 都比 num 小,
//                l = m + 1;           // 然后将 l(左边界)调整为：l = m + 1, 因为 arr[m] 这个数字本身都比 num 小.
//            }
//        }
//        return false;                 // 最后若是已经跳出 while循环了, 都没有找到和 num 相等的值,
//                                      // 直接就返回 false, 说明这个数组中没有和 num 相等的值.
//    }
}
