struct Solution {}

impl Solution {
    pub fn is_anagram(s: String, t: String) -> bool {
        let mut freq_char = [0; 26];
        for sChar in s.as_bytes() {
            freq_char[(sChar - b'a') as usize] += 1;
        }
        for tChar in t.as_bytes() {
            freq_char[(tChar - b'a') as usize] -= 1;
        }
        for freq in freq_char {
            if freq != 0 {
                return false;
            }
        }

        true
    }
}

#[test]
fn test1() {
    assert_eq!(Solution::is_anagram(String::from("anagram"), String::from("nagaram")), true);
}

#[test]
fn test2() {
    assert_eq!(Solution::is_anagram(String::from("rat"), String::from("car")), false);
}