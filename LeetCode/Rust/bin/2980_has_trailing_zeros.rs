impl Solution {
    pub fn has_trailing_zeros(nums: Vec<i32>) -> bool {
        nums.into_iter().filter(|num| num & 1 == 0).len() > 2
    }
}
