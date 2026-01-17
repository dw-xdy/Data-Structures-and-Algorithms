impl Solution {
    pub fn min_window(str: String, tar: String) -> String {
        let s = str.as_bytes();
        let t = tar.as_bytes();

        let mut debt = t.len() as i32;

        let mut cnts = [0_i32; 256];

        if s.len() < t.len() {
            return "".to_string();
        }
        
        for &b in t {
            cnts[b as usize] -= 1; // 修改：b (u8) 转换为 usize
        }

        let mut start = 0;
        let mut min_len = usize::MAX;

        let mut l = 0;
        for r in 0..s.len() {
            // 修改：s[r] (u8) 直接转换为 usize 作为索引
            if cnts[s[r] as usize] < 0 {
                debt -= 1;
            }
            cnts[s[r] as usize] += 1;

            if debt == 0 {
                // 修改：s[l] (u8) 直接转换为 usize 作为索引
                while cnts[s[l] as usize] > 0 {
                    cnts[s[l] as usize] -= 1;
                    l += 1;
                }

                if r - l + 1 < min_len {
                    start = l;
                    min_len = r - l + 1;
                }
            }
        }
        
        if min_len == usize::MAX {
            "".to_string()
        } else {
            // Rust 字符串切片，索引必须为 usize
            str[start..start + min_len].to_string()
        }
    }
}
