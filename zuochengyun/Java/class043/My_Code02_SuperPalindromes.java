package class043;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code02_SuperPalindromes {
    public static int superpalindromesInRange(String left, String right) {
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        long limit = (long) Math.sqrt((double) r);

        long num = 0;
        int ans = 0;
        long seed = 1;
        while (num < limit) {
            num = evenEnlarge(seed);
            if (check(num * num, l, r)) {
                ans++;
            }
            num = oddEnlarge(seed);
            if (check(num * num, l, r)) {
                ans++;
            }
            seed++;
        }
        return ans;
    }


    public static long evenEnlarge(long seed) {
        long ans = seed;
        while (seed != 0) {
            ans = ans * 10 + seed % 10;
            seed /= 10;
        }
        return ans;
    }


    public static long oddEnlarge(long seed) {
        long ans = seed;
        seed /= 10;
        while (seed != 0) {
            ans = ans * 10 + seed % 10;
            seed /= 10;
        }
        return ans;
    }



    public static boolean check(long num, long l, long r) {
        return num >= l && num <= r && isPalindrome(num);
    }


    public static boolean isPalindrome(long num) {
        if (num < 0) {
            return false;
        }
        // 我真是服了, md这个忘了改成 long 类型了, 因为这次我们的数据比较大所以对应的标准应该是 long 类型
        // 我真是服了, 啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        long offset = 1;
        // 注意这么写是为了防止溢出
        while (num / offset >= 10) {
            offset *= 10;
        }
        // 首尾判断
        while (num != 0) {
            if (num / offset != num % 10) {
                return false;
            }
            num = (num % offset) / 10;
            offset /= 100;
        }
        return true;
    }



}
