package io.github.bluething.leetcode.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionofTwoArrays2Test {
    @Test
    public void case01() {
        Assert.assertArrayEquals(new int[]{2, 2}, intersect(new int[]{1,2,2,1}, new int[]{2, 2}));
    }
    private int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> idxs = new ArrayList<>();
        Map<Integer, Integer> counterNum = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            counterNum.put(nums1[i], counterNum.getOrDefault(nums1[i], 0) + 1);
        }

        Integer countNum2 = Integer.valueOf(0);
        for (int i = 0; i < nums2.length; i++) {
            countNum2 = counterNum.getOrDefault(nums2[i], 0);
            if (countNum2 > 0) {
                idxs.add(nums2[i]);
                counterNum.put(nums2[i], --countNum2);
            }
        }

        return idxs.stream()
                .mapToInt(i -> i)
                .toArray();
    }
}
