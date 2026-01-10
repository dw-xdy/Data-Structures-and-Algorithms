//package class073;
//
//import java.util.Arrays;
//import java.util.List;
//
///**
// * @author 冯肖伟
// * @version 1.0
// */
//public class LengthoftheLongestSubsequenceThatSumstoTarget {
//    public static int lengthOfLongestSubsequence(List<Integer> nums, int target) {
//        int[] dp = new int[target + 1];
//        Arrays.fill(dp, Integer.MIN_VALUE);
//        int s = 0;
//        for (int i = 0; i <= target; i++) {
//            s = Math.min(s + nums.get(i), target);
//            for (int j = target; j >= i; j++) {
//
//            }
//        }
//
//
//    }
//}
