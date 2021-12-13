package io.github.bluething.leetcode.algorithm.binarysearch;

import org.junit.Assert;
import org.junit.Test;

public class CountNegativeNumbersinaSortedMatrixTest {
    @Test
    public void case01() {
        Assert.assertEquals(8, countNegatives(new int[][]{{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}}));
    }

    @Test
    public void case02() {
        Assert.assertEquals(0, countNegatives(new int[][]{{3,2},{1,0}}));
    }

    @Test
    public void case03() {
        Assert.assertEquals(3, countNegatives(new int[][]{{1,-1},{-1,-1}}));
    }

    @Test
    public void case04() {
        Assert.assertEquals(1, countNegatives(new int[][]{{-1}}));
    }

    // Imagine the matrix will be like this, sorted in non-increasing order both row-wise and column-wise
    // x  x  x -x
    // x  x  x -x
    // x  x -x -x
    // -x -x -x -x
    // we can start count from bottom left
    private  int countNegatives(int[][] grid) {
        int count = 0;
        int gridColumn = grid[0].length;
        int row = grid.length - 1;
        int col = 0;
        while (row >= 0 && col < gridColumn) {
            // If the value is negative, for the next iteration move to the upper row and increment the count
            // Because the row already sorted, so we can subtract gridColumn with col (1st idx which value is negative)
            // If the value is positive, move to the next idx
            if (grid[row][col] < 0) {
                row--;
                count += gridColumn - col;
            } else {
                col++;
            }
        }

        return count;
    }
}
