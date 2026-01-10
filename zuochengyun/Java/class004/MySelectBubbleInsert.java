package class004;

import java.util.Arrays;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class MySelectBubbleInsert {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2};

        sele(arr);

        System.out.println(Arrays.toString(arr));
    }

    public static void sele(int arr[]) {
        int min = 0;
        for (int i = 1; i < arr.length; i++) {
            min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

}


