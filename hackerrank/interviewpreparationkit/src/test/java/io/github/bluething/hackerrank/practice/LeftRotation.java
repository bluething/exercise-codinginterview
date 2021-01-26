package io.github.bluething.hackerrank.practice;

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
        Integer temp = Integer.valueOf(0);

        for (int i = 1; i <= d; i++) {
            temp = arr.get(0);
            for (int j = 0; j < arr.size() - 1; j++) {
                arr.set(j, arr.get(j + 1));
            }
            arr.set(arr.size() - 1, temp);
        }

        return arr;
    }
}
