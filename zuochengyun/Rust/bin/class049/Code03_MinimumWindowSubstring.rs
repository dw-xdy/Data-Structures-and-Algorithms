impl Solution {
    pub fn min_window(s: String, t: String) -> String {
        let s = str.as_bytes();
        let t = tar.as_bytes();

        let mut debt = t.len() as i32;

        let mut cnts = [0_i32; 256];

        if s.len() < t.len() {
            return "".to_string();
        }
        
        for &b in t {
            cnts[b as usize] -= 1;
        }

        let mut start = 0;
        let mut min_len = usize::MAX;

        let mut l = 0;
        for r in 0..s.len() {
            if cnts[s[r]] < 0 {
                debt -= 1;
            }
            cnts[s[r]] += 1;

            if debt == 0 {
                while cnts[s[l]] > 0 {
                    cnts[s[l]] -= 1;
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
            // Rust 的切片语法，注意是从 String 截取
            str[start_idx..start_idx + min_len].to_string()
        }
    }
}
