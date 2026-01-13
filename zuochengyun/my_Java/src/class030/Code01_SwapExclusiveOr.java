package class030;

public class Code01_SwapExclusiveOr {
    public static void main(String[] args) {
        int a = 10;
        int b = 11;
        System.out.println(a);       
        System.out.println(b);

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);       
        System.out.println(b);

        int[] arr = {1, 3};
        swap(arr, 0, 1);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        // 注意: 这个会导致当前数字清零, 因为是自己和自己异或.
        swap(arr, 0, 0);
        System.out.println(arr[0]);
        System.out.println(arr[1]);
    }    


    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
