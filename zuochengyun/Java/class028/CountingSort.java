package class028;

/**
 * @author 冯肖伟
 * @version 1.0
 */
import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("原始数组: " + Arrays.toString(arr));

        countingSort(arr);
        System.out.println("排序后的数组: " + Arrays.toString(arr));
    }

    public static void countingSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return; // 如果数组为空，直接返回
        }

        // 找到数组中的最大值
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // 创建计数数组
        int[] count = new int[max + 1];

        // 统计每个元素的出现次数
        for (int num : arr) {
            count[num]++;
        }

        // 将计数数组中的元素按顺序填回原数组
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[index++] = i; // 根据计数填充原数组
                count[i]--;
            }
        }
    }
}
