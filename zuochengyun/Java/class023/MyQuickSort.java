package class023;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class MyQuickSort {
     public static int[] arr = new int[10000];

    public static void main(String[] args) {

    }


    public static int partition(int l, int r, int x) {
        int a = 0, xi = 0;

        for (int i = l; i <= r; i++) {
           if (arr[i] <= x) {
               swap(i, a);
               if (arr[a] == x) {
                   xi = a;
               }
               a++;
           }
        }
        swap(xi, a - 1);
        return a - 1;
    }

    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
