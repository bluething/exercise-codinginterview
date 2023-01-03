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

    pub fn roman_to_int_rev_loop(s: String) -> i32 {
        let mut result = 0;
        let mut prev = 0;
        let mut current : i32;
        for roman in s.chars() {
            match roman {
                'M' => current = 1000,
                'D' => current = 500,
                'C' => current = 100,
                'L' => current = 50,
                'X' => current = 10,
                'V' => current = 5,
                'I' => current = 1,
                _ => current = 0,
            }
            if current > prev {
                // try to get negative value from previous, for example CXL
                // when we enter L we will have
                // result = 110 and current = 10
                // before we add L to the result, we subtract the result with 2*10
                result -= prev * 2;
            }
            prev = current;
            result += current;
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

#[test]
fn test3() {
    assert_eq!(Solution::roman_to_int_rev_loop(String::from("III")), 3);
}

#[test]
fn test4() {
    assert_eq!(Solution::roman_to_int_rev_loop(String::from("IV")), 4);
}