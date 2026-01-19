class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int mx = 0;
        for (int x : arrivals) {
            mx = Math.max(mx, x);
        }

        int[] cnt = new int[mx + 1];
        int ans = 0;
        for (int i = 0; i < arrivals.length; i++) {
            int x = arrivals[i];
            // x 进入窗口
            if (cnt[x] == m) { // x 的个数已达上限
                // 注意 x 在未来要离开窗口，但由于已经丢弃，不能在离开窗口时修改 cnt
                // 这里直接置为 0，未来离开窗口就是 cnt[0]--，不影响答案
                arrivals[i] = 0; // 丢弃 arrivals[i]
                ans++;
            } else {
                cnt[x]++;
            }

            // 左端点元素离开窗口，为下一个循环做准备
            int left = i + 1 - w;
            if (left >= 0) {
                cnt[arrivals[left]]--;
            }
        }
        return ans;
    }
}
