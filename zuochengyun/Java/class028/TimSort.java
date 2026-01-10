package class028;

/**
 * @author 冯肖伟
 * @version 1.0
 */
import java.util.Arrays;

public class TimSort {
    private static final int RUN = 32; // 插入排序的最小长度

    // 插入排序
    private static void insertionSort(int[] arr, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= left && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // 合并两个已排序的子数组
    private static void merge(int[] arr, int left, int mid, int right) {
        // 获取两段子数组的大小
        int len1 = mid - left + 1;
        int len2 = right - mid;

        // 临时存储子数组
        int[] leftArray = new int[len1];
        int[] rightArray = new int[len2];

        for (int i = 0; i < len1; i++) leftArray[i] = arr[left + i];
        for (int j = 0; j < len2; j++) rightArray[j] = arr[mid + 1 + j];

        // 合并两个子数组
        int i = 0, j = 0, k = left;
        while (i < len1 && j < len2) {
            if (leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // 拷贝剩余元素
        while (i < len1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while (j < len2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // TimSort 主方法
    public static void timSort(int[] arr) {
        int n = arr.length;

        // 先对数组的每个部分进行插入排序
        for (int i = 0; i < n; i += RUN) {
            insertionSort(arr, i, Math.min(i + RUN - 1, n - 1));
        }

        // 然后合并已排序的子数组
        for (int size = RUN; size < n; size *= 2) {
            for (int left = 0; left < n; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + 2 * size - 1), (n - 1));

                if (mid < right) {
                    merge(arr, left, mid, right);
                }
            }
        }
    }

    // 主程序入口，测试类
    public static void main(String[] args) {
        int[] arr = {5, 21, 7, 23, 19};
        System.out.println("原始数组: " + Arrays.toString(arr));

        TimSort.timSort(arr);

        System.out.println("排序后的数组: " + Arrays.toString(arr));
    }
}

