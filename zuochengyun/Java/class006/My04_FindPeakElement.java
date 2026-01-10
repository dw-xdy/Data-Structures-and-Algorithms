package class006;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My04_FindPeakElement {
    // 这里返回的是“索引”不是一个具体的数据!!!!!!!!!!!!!!
    public static void main(String[] args) {
        int[] arr = {1, 12, 9, 7, 8, 17, 3};

        int peek = findPeakElement(arr);
        System.out.println(peek);

    }

    public static int findPeakElement(int[] arr) {
        int n = arr.length;
        if (arr.length == 1) {
            return 0;             // 若是数组的长度为“1”, 那就说明这个数字一定是“峰值”
        }                         // 因为题目的条件就是数组越界坐标的数字是“无穷小”的.
        if (arr[0] > arr[1]) {
            return 0;              // 先对“下标为0”的位置进行判断, 若是arr[0] > arr[1],
        }                          // 那就说明“arr[0]”一定是一个“峰值”.
        if (arr[n - 1] > arr[n - 2]) {
            return n - 1;          // 然后对“下标为n - 1”的位置进行判断, 若是arr[n - 1] > arr[n - 2]
        }                          // 那就说明“arr[n - 1]”一定是一个峰值.
        int l = 1, r = n - 2, m = 0, ans = -1;  // 既然“arr[0]和arr[n - 1]”都不是峰值, 那就说明峰值一定在“1 ~ n - 2”之间.
        while (l <= r) {             // 进入循环, 循环条件还是左边界小于右边界.
            m = (l + r) / 2;         // 还是将“m”设置为“中点”.
            if (arr[m - 1] > arr[m]) {        // 若是“中点”左边的数字比“中点”的数字大,
                r = m - 1;                    // 则说明：左边一定有“峰值”
            } else if (arr[m] < arr[m + 1]) {  // 若是“中点”右边的数字比“中点”的数字大,
                l = m + 1;                     // 则说明：右边一定有“峰值”.
            } else {
                ans = m;// 最后, 只有一种情况, 就是当“arr[m]”的值同时比“中点”左边的数字和“中点”右边的数字同时都大.
                break;  // 此时跳出循环.
            }
            // 若是你问出现{1, 12, 9, 7, 8, 17, 3}, 中点“7”的左侧和右侧同时比“中点”大, 会怎么样
            // 这种情况, 自己调试一下就行了, 我调试的结果是在执行到“if (arr[m - 1] > arr[m])”这一步的时候,
            // 就已经符合这个条件判断的情况了, 所以直接继续向着左侧二分了.
        }
        return ans;   // 最后返回一个峰值.
    }
}
