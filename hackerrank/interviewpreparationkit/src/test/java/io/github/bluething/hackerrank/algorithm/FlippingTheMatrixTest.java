package io.github.bluething.hackerrank.algorithm;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

// Sean invented a game involving a 2nx2n matrix where each cell of the matrix contains an integer.
// He can reverse any of its rows or columns any number of times.
// The goal of the game is to maximize the sum of the elements in the nxn submatrix located in the upper-left quadrant of the matrix.
//
//Given the initial configurations for  matrices, help Sean reverse the rows and columns of each matrix in the best possible way so that the sum of the elements in the matrix's upper-left quadrant is maximal.
public class FlippingTheMatrixTest {

    @Test
    public void case01() {
        Assert.assertEquals(414, flippingMatrix(Arrays.asList(
                Arrays.asList(112, 42, 83, 119),
                Arrays.asList(56, 125, 56, 49),
                Arrays.asList(15, 78, 101, 43),
                Arrays.asList(62, 98, 114, 108))));
    }

    // p1, p2, p3, and p4 is a candidate to fill each point in upper left quadrant
    // The idea is for each point find max possible value that can be flipped
    // |x1  x2  x3  x4|
    // |x5  x6  x7  x8|
    // |x9  x10 x11 x12|
    // |x13 x14 x15 x16|
    // For example, candidate to replace x1 is:
    // x1 itself
    // x4 (row flip)
    // x13 (column flip)
    // x16 (column flip then row)
    private int flippingMatrix(List<List<Integer>> matrix) {
        int sum = 0;
        int quadrantSize = matrix.size() / 2;
        for (int row = 0; row < quadrantSize; row++) {
            for (int col = 0; col < quadrantSize; col++) {
                int p1 = matrix.get(row).get(col);
                int p2 = matrix.get(row).get((2 * quadrantSize) - 1 - col);
                int p3 = matrix.get((2 * quadrantSize) - 1 - row).get(col);
                int p4 = matrix.get((2 * quadrantSize) - 1 - row).get((2 * quadrantSize) - 1 -col);

                sum += Math.max(p1, Math.max(p2, Math.max(p3, p4)));
            }
        }

        return sum;
    }
}