package class021;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class MyCode01_MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 2, 3, 9, 3, 2, 1};

        mergeSort(arr, 0, arr.length - 1);

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }
        int m = (l + r) / 2;
        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);
        merge(arr, l, m, r);
    }

    public static void merge(int[] arr, int l, int m, int r) {
        int i = l;
        int a = l;
        int b = m + 1;
        int[] help = new int[100];

        while (a <= m && b <= r) {
            help[i++] = arr[a] <= arr[b] ? arr[a++] : arr[b++];
        }

        while (a <= m) {
            help[i++] = arr[a++];
        }

        while (b <= r) {
            help[i++] = arr[b++];
        }

        for (i = l; i <= r; i++) {
            arr[i] = help[i];
        }


    }
}
