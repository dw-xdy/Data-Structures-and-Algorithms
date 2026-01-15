impl Solution {
    pub fn min_sub_array_len(target: i32, nums: Vec<i32>) -> i32 {
        let mut ans = i32::MAX;
        let mut sum = 0;
        let mut l = 0;  // 左指针
        
        for r in 0..nums.len() {
            sum += nums[r];  // 扩展右边界
            
            while sum - nums[l] >= target {
                sum -= nums[l];
                l += 1;
            }
            
            // 更新最小长度
            if sum >= target {
                ans = ans.min((r - l + 1) as i32);
            }
        }
        
        if ans == i32::MAX { 0 } else { ans }
    }
}
