package class047;

import java.util.Arrays;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class hjkgfdsajkhwkjhffdsa {


    public static int[] arr = new int[30];

    public static void fall1(int v, int x) {
        set(x - 3 * v + 1, x - 2 * v, 1, v, 1);
        set(x - 2 * v + 1, x, v - 1, -v, -1);
        set(x + 1, x + 2 * v, -v + 1, v, 1);
        set(x + 2 * v + 1, x + 3 * v - 1, v - 1, 1, -1);
    }


    // 注意：这里是不能有重叠区域的, 所以这个fall2的方法无法通过.
    public static void fall2(int v, int x) {
        set(x - 3 * v, x - 2 * v, 0, v, 1);
        set(x - 2 * v, x, v, -v, -1);
        set(x, x + 2 * v, -v, v, 1);
        set(x + 2 * v, x + 3 * v, v, 0, -1);
    }

    public static void set(int l, int r, int s, int e, int d) {
        arr[l] += s;
        arr[l + 1] += d - s;
        arr[r + 1] -= d + e;
        arr[r + 2] += e;
    }

    public static void build() {
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
    }

    public static void main(String[] args) {
//        fall1(3, 10);
        fall2(3, 10);
        build();
        System.out.println(Arrays.toString(arr));
    }
}
