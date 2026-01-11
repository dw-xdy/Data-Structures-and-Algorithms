package class066;


public class Code01_fibonacciNumber {
    public static fib1(int n) {
        return f1(n);
    }

    public static f1(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return f(n - 1) + f(n - 2);
    }
} 



