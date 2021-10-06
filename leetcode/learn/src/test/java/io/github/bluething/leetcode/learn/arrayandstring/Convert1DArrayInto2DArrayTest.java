package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

public class Convert1DArrayInto2DArrayTest {
    @Test
    public void case01() {
        Assert.assertArrayEquals(new int[][] {{1, 2, 3}}, construct2DArray(new int[]{1, 2, 3}, 1, 3));
    }

    @Test
    public void case02() {
        Assert.assertArrayEquals(new int[][] {{1, 2}, {3, 4}}, construct2DArray(new int[]{1, 2, 3, 4}, 2, 2));
    }

    @Test
    public void case03() {
        Assert.assertArrayEquals(new int[][]{}, construct2DArray(new int[]{1, 2}, 1, 1));
    }

    private int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[][]{};
        }

        int[][] result = new int[m][n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = original[idx++];
            }
        }

        return result;
    }
}
