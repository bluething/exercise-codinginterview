package io.github.bluething.hackerrank.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// The problem https://www.hackerrank.com/challenges/array-left-rotation/problem
public class LeftRotation {

    @Test
    public void successWhenInputIsRight() {
        List<Integer> expected = new ArrayList<>(Arrays.asList(new Integer[]{5, 1, 2, 3, 4}));
        Assert.assertEquals(expected, rotateLeft(4, new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5}))));
    }


    private List<Integer> rotateLeft(int d, List<Integer> arr) {
        while (d > 0) {
            arr.add(arr.remove(0));
            d--;
        }

        return arr;
    }
}
