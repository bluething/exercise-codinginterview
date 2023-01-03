// https://leetcode.com/problems/roman-to-integer/

use std::collections::HashMap;

struct Solution {}

impl Solution {
    pub fn roman_to_int(s: String) -> i32 {
        let values = HashMap::from([
            (b'\0', 0),
            (b'I', 1),
            (b'V', 5),
            (b'X', 10),
            (b'L', 50),
            (b'C', 100),
            (b'D', 500),
            (b'M', 1000)
        ]);

        let mut result = 0;
        let mut prev = b'\0';
        for roman in s.bytes().rev() {
            let value = values[&roman];
            if values[&prev] <= value {
                result += value;
            } else {
                result -= value;
            }

            prev = roman;
        }

        result
    }
}

#[test]
fn test1() {
    assert_eq!(Solution::roman_to_int(String::from("III")), 3);
}

#[test]
fn test2() {
    assert_eq!(Solution::roman_to_int(String::from("IV")), 4);
}