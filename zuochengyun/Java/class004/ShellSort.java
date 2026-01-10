package class004;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class ShellSort {
    // 希尔排序主方法
    public static void shellSort(int[] arr) {
        int n = arr.length;

        // 初始间隔为数组长度的一半，然后逐步缩小间隔
        for (int gap = n/2; gap > 0; gap /= 2) {
            // 对每个间隔进行插入排序
            gappedInsertionSort(arr, gap);
        }
    }

    // 带间隔的插入排序
    private static void gappedInsertionSort(int[] arr, int gap) {
        int n = arr.length;

        // 从第gap个元素开始，逐个对其所在组进行直接插入排序操作
        for (int i = gap; i < n; i++) {
            int temp = arr[i];
            int j = i;
            while (j >= gap && arr[j - gap] > temp) {
                arr[j] = arr[j - gap];
                j -= gap;
            }
            arr[j] = temp;
        }
    }

    // 打印数组的辅助方法
    public static void printArray(int arr[]) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // 主方法，用于测试
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("排序前的数组:");
        printArray(arr);

        // 执行希尔排序
        shellSort(arr);

        System.out.println("排序后的数组:");
        printArray(arr);
    }
}