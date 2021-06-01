package io.github.bluething.leetcode.juneleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class MaxAreaofIslandTest {

    @Test
    public void successWhenInputIsRight() {
        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        Assert.assertEquals(6, new Solution().maxAreaOfIsland(grid));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        int[][] grid = new int[][]{{0,0,0,0,0,0,0,0}};
        Assert.assertEquals(0, new Solution().maxAreaOfIsland(grid));
    }

    class Solution {
        private int m;
        private int n;

        public int maxAreaOfIsland(int[][] grid) {
            int maxArea = 0;
            m = grid.length;
            n = grid[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] > 0) {
                        maxArea = Math.max(maxArea, traverseArea(i, j, grid));
                    }
                }
            }

            return maxArea;
        }
        // for each row, doing recursive for every 1 found

        private int traverseArea(int i, int j, int[][] grid) {
            if (i < 0 || j < 0 ||
                    i >= m || j >= n ||
                    grid[i][j] < 1) {
                return 0;
            }

            grid[i][j] = 0;

            return 1 +
                    traverseArea(i-1, j, grid) + traverseArea(i, j-1, grid) +
                    traverseArea(i+1, j, grid) + traverseArea(i, j+1, grid);
        }
        // if the value at [i,j] is 0, return it
        // if not (is 1) change to 0, we don't want to process it again in the next iteration (when checking edge)
        // because we already found 1, we use constant 1 as return value, added with all four edges check result
        // we check all four edges with recursive

    }
    // the solution I wrote is for learning recursive
    // I find the solution from https://dev.to/seanpgallivan
}
