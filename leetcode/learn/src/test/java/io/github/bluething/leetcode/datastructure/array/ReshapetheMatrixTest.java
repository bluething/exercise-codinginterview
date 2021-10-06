package io.github.bluething.leetcode.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

public class ReshapetheMatrixTest {
    @Test
    public void case01() {
        Assert.assertArrayEquals(new int[][]{{1,2,3,4}}, matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4));
    }

    private int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat[0].length;
        if (mat.length * n != r * c) {
            return mat;
        }

        int[][] result = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            result[i/c][i%c] = mat[i/n][i%n];
        }

        return result;
    }

    // the formula
    // convert 2d into 1d -> M[i][j]=M[n*i+j]
    // n = number of columns
    // convert 1d into 2d -> M[i] => M[i/n][i%n]
}
