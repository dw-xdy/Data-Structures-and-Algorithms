public class Code05_PrimeFactorWithEuler {


    // 判断从[0...n]有几个质数,
    // 并且每一个数字的质因子有几个(不统计重复的质因数).
    public static int[] eulerDisOmega(int n) {
        boolean[] visit = new boolean[n + 1];
        int[] prime = new int[n / 2 + 1];
        int[] disOmega = new int[n + 1];
        int cnt = 0;

        for (int i = 2; i <= n; i++) {
            if (!visit[i]) {
                prime[cnt++] = i;
                disOmega[i] = 1; // 质数的不同质因数个数=1
            }
            for (int j = 0; j < cnt; j++) {
                if (i * prime[j] > n) {
                    break;
                }
                visit[i * prime[j]] = true;
                if (i % prime[j] != 0) {
                    disOmega[i * prime[j]] = disOmega[i] + 1;
                } else {
                    disOmega[i * prime[j]] = disOmega[i];
                    break;
                }
            }
        }
        return disOmega;
    }


    public static int eulerOmega(int n) {
        boolean[] visit = new boolean[n + 1];
        int[] omega = new int[n + 1];
        int[] prime = new int[n / 2 + 1];
        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (!visit[i]) {
                prime[cnt++] = i;
                omega[i] = 1;
            }
            for (int j = 0; j < cnt; j++) {
                if (i * prime[j] > n) {
                    break;
                }
                visit[i * prime[j]] = true;
                omega[i * prime[j]] = omega[i] + 1;
                if (i % prime[j] == 0) {
                    break;
                }
            }
        }
        return omega[n];
    }
}