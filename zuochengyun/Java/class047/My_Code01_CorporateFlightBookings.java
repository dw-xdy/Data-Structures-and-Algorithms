package class047;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code01_CorporateFlightBookings {
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] arr = new int[n + 2];
        int[] answer = new int[n];
        for (int[] book : bookings) {
            arr[book[0]] += book[2];
            arr[book[1] + 1] -= book[2];
        }

        for (int i = 1; i < arr.length; i++) {
            arr[i] += arr[i - 1];
        }
        for (int i = 0; i < n; i++) {
            answer[i] = arr[i + 1];
        }
        return answer;
    }

}
