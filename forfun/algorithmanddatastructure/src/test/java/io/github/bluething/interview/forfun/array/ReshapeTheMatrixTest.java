package io.github.bluething.interview.forfun.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// From 2D array.
// Transpose the array
// Flatten the transposed array

public class ReshapeTheMatrixTest {

    @Test
    public void case01() {
        Assertions.assertArrayEquals(new int[]{1, 3, 7, 2, 4, 8, 3, 5, 9}, matrixReshape(new int[][]{{1, 2, 3}, {3, 4, 5}, {7, 8, 9}}));
    }

    @Test
    public void case02() {
        Assertions.assertArrayEquals(new int[][]{{1, 3, 7}, {2, 4, 8}, {3, 5, 9}}, transpose(new int[][]{{1, 2, 3}, {3, 4, 5}, {7, 8, 9}}));
    }

    @Test
    public void case03() {
        Assertions.assertArrayEquals(new int[]{1, 3, 7, 2, 4, 8, 3, 5, 9}, from2Dto1D(new int[][]{{1, 3, 7}, {2, 4, 8}, {3, 5, 9}}));
    }

    private int[] matrixReshape(int[][] matrix) {
        return from2Dto1D(transpose(matrix));
    }

    private int[][] transpose(int[][] matrix) {
        int temp;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                if (i != j) {
                    temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        return matrix;
    }

    private int[] from2Dto1D(int[][] matrix) {
        int column = matrix[0].length;
        int numOfElement = matrix.length * column;
        int[] oneD = new int[numOfElement];
        for (int i = 0; i < numOfElement; i++) {
            oneD[i] = matrix[i / column][i % column];
        }

        return oneD;
    }

}
