package io.github.bluething.hackerrank.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

// https://www.hackerrank.com/challenges/missing-numbers/problem
public class MissingNumbersTest {

    @Test
    public void case01() {
        Assert.assertEquals(Arrays.asList(204, 205, 206),
                missingNumbers(Arrays.asList(203, 204, 205, 206, 207, 208, 203, 204, 205, 206),
                        Arrays.asList(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204)));
    }

    private List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        TreeMap<Integer, Integer> counter = new TreeMap<>();
        for (Integer val : brr) {
            counter.put(val, counter.getOrDefault(val, 0) - 1);
        }
        for (Integer val : arr) {
            counter.put(val, counter.getOrDefault(val, 0) + 1);
        }

        List<Integer> missingValues = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : counter.entrySet()) {
            if (entry.getValue() < 0) {
                missingValues.add(entry.getKey());
            }
        }

        return missingValues;
    }
}
