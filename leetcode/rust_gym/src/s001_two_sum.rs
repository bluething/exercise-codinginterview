use std::collections::HashMap;

struct Solution {}

impl Solution {
    pub fn two_sum(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let nums_size = nums.len();
        for i in 0..nums_size - 1 {
            for j in i+1..nums_size {
                if nums[i] + nums[j] == target {
                    return vec![i as i32, j as i32]
                }
            }
        }

        vec![]
    }

    pub fn two_sum_with_hashmap(nums: Vec<i32>, target: i32) -> Vec<i32> {
        let mut map = HashMap::with_capacity(nums.len());
        for (idx, value) in  nums.iter().enumerate() {
            match map.get(&(target - value)) {
                None => {
                    map.insert(value, idx);
                }
                Some(second_idx) => return vec![*second_idx as i32, idx as i32],
            }
        }
        vec![]
    }
}

#[test]
fn test1() {
    assert_eq!(Solution::two_sum(vec![2, 7, 11, 15], 9), vec![0, 1]);
}

#[test]
fn test2() {
    assert_eq!(Solution::two_sum(vec![2, 7, 11, 15], 9999), vec![]);
}

#[test]
fn test3() {
    assert_eq!(Solution::two_sum(vec![3, 2, 4], 6), vec![1, 2]);
}

#[test]
fn test4() {
    assert_eq!(Solution::two_sum(vec![2,5,5,11], 10), vec![1, 2]);
}

#[test]
fn test5() {
    assert_eq!(Solution::two_sum_with_hashmap(vec![2, 7, 11, 15], 9), vec![0, 1]);
}

#[test]
fn test6() {
    assert_eq!(Solution::two_sum_with_hashmap(vec![2, 7, 11, 15], 9999), vec![]);
}

#[test]
fn test7() {
    assert_eq!(Solution::two_sum_with_hashmap(vec![3, 2, 4], 6), vec![1, 2]);
}

#[test]
fn test8() {
    assert_eq!(Solution::two_sum_with_hashmap(vec![2,5,5,11], 10), vec![1, 2]);
}