package io.github.bluething.interview.forfun.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

// From 2D array.
// - Transpose the array
// - Reverse the transposed array
// - Flatten then sort the reversed transposed 2D array
public class ReshapeTheMatrixIITest {

    @Test
    public void case01() {
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, matrixReshape(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}));
    }

    @Test
    public void transposeTheMatrixTest() {
        Assertions.assertArrayEquals(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, transposeTheMatrix(new int[][]{{1, 4, 7}, {2, 5, 8}, {3, 6, 9}}));
    }

    @Test
    public void reverseTheMatrixTest() {
        Assertions.assertArrayEquals(new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}}, reverseTheMatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    @Test
    public void reverse1DMatrixTest() {
        Assertions.assertArrayEquals(new int[]{3, 2, 1}, reverse1DMatrix(new int[]{1, 2, 3}));
    }

    @Test
    public void flattenThenSortTheMatrixTest() {
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, flattenThenSortTheMatrix(new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}}));
    }

    private int[] matrixReshape(int[][] matrix) {
        return flattenThenSortTheMatrix(
                reverseTheMatrix(
                        transposeTheMatrix(matrix)));
    }

    private int[][] transposeTheMatrix(int[][] matrix) {
        int[][] transposedMatrix = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    private int[][] reverseTheMatrix(int[][] matrix) {
        int rowIdx = matrix.length - 1;
        int columnIdx = matrix[0].length - 1;
        int[] temp = new int[columnIdx];
        int topRowIdx = 0;
        int bottomRowIdx = rowIdx;
        while (topRowIdx < bottomRowIdx) {
            matrix[topRowIdx] = reverse1DMatrix(matrix[topRowIdx]);
            matrix[bottomRowIdx] = reverse1DMatrix(matrix[bottomRowIdx]);

            temp = matrix[bottomRowIdx];
            matrix[bottomRowIdx] = matrix[topRowIdx];
            matrix[topRowIdx] = temp;

            topRowIdx++;
            bottomRowIdx--;
        }

        // for square matrix
        if (topRowIdx == bottomRowIdx) {
            matrix[topRowIdx] = reverse1DMatrix(matrix[topRowIdx]);
        }

        return matrix;
    }

    private int[] reverse1DMatrix(int[] matrix) {
        int temp = 0;
        for (int i = 0; i < matrix.length / 2; i++) {
            temp = matrix[i];
            matrix[i] = matrix[matrix.length - 1 - i];
            matrix[matrix.length - 1 - i] = temp;
        }
        return matrix;
    }

    private int[] flattenThenSortTheMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[] oneDMatrix = new int[row * col];
        for (int i = 0; i < oneDMatrix.length; i++) {
            oneDMatrix[i] = matrix[i / row][i % row];
        }

        Arrays.sort(oneDMatrix);

        return oneDMatrix;
    }
}
