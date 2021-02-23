package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class Searcha2DMatrixIITest {

    @Test
    public void successWhenInputIsRight() {
        int[][] matrix = {{1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };

        Assert.assertTrue(searchMatrix(matrix, 5));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        int[][] matrix = {{1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };

        Assert.assertFalse(searchMatrix(matrix, 20));
    }

    @Test
    public void successWhenInputIsRightThree() {
        int[][] matrix = {{-5}};

        Assert.assertFalse(searchMatrix(matrix, -10));
    }

    private boolean searchMatrix(int[][] matrix, int target) {
        boolean isFound = false;
        int i = 0;
        int j = 0;
        while (i < matrix.length && !isFound) {
            if (matrix[i][0] > target) {
                i++;
                continue;
            }
            j = 0;
            while (j < matrix[i].length && !isFound) {
                if (matrix[i][j] == target) {
                    isFound = true;
                }
                j++;
            }

            i++;
        }

        return isFound;
    }
}
