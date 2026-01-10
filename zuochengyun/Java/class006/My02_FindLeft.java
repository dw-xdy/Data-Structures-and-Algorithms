package class006;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My02_FindLeft {
    public static int findLeft(int[] arr, int num) {
        int ans = -1;
        int l = 0, r = arr.length - 1, m = 0;
        while (l <= r) {
            m = (l + r) / 2;
            if (arr[m] >= num) {
                ans = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }



//    public static int findLeft(int[] arr, int num) {
//        int l = 0, r = arr.length - 1, m = 0;
//        int ans = -1;               //然后设置一个 int ans = -1, 初始值设置为 -1 的原因是：
//        若是在这个有序数组中, 没有一个数字要比 num 大, 那就直接返回 -1, 毕竟一个数组中不可能有一个 < 0 的数字.
//        while (l <= r) {     // 然后开始进行循环, 终止条件是 当左边界 <= 右边界 的时候.
//            m = l + ((r - l) >> 1);
//            if (arr[m] >= num) {   // 若是 arr[m] >= num, 那就更新 ans 的值(ans = m), 因为此时已经有 >= num 的值了,
//                ans = m;           // 但是我们不知道这个 m 是不是最左位置,
//                r = m - 1;        // 所以还是要继续向左二分. 然后更新 r(右边界)的值：r = m - 1;
//            } else {           // 若是 arr[m] < num, 那就不更新 ans 的值, 因为现在还没有 >= num 的值,
//                l = m + 1;     //但是我们不知道右边有没有 >= num 的值, 所以还要更新 l(左边界的值) l = m + 1; 继续二分.
//            }
//        }
//        return ans;            // 最后, 若是有数字 >= num , 那 ans 就会返回对应的 m,
//    }                          // 若是没有 ans 就返回 -1 (表示整个数组中没有一个数字 >= num).


}
