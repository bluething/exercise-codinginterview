package io.github.bluething.leetcode.algorithm.depthfirstsearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class MaxAreaofIslandTest {

    // You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
    // You may assume all four edges of the grid are surrounded by water.
    //The area of an island is the number of cells with a value 1 in the island.
    //Return the maximum area of an island in grid. If there is no island, return 0.

    @Test
    public void case01() {
        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        Assert.assertEquals(6, maxAreaOfIsland(grid));
    }

    @Test
    public void case02() {
        int[][] grid = new int[][]{{0,0,0,0,0,0,0,0}};

        Assert.assertEquals(0, maxAreaOfIsland(grid));
    }

    @Test
    public void case03() {
        int[][] grid = new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };

        Assert.assertEquals(6, maxAreaOfIslandIterative(grid));
    }

    private int maxAreaOfIsland(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    count = Math.max(count, dfs(grid, i, j));
                }
            }
        }
        return count;
    }
    private int dfs(int[][] grid, int i, int j) {
        // if we're outside of the grid or see the sea (0)
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }

        // make it 0, so that next time this cell is encountered, it is not counted again
        grid[i][j] = 0;

        int count = 1;
        //look to see the rest of our area four dimensionally, recursively
        // next line
        count += dfs(grid, i+1, j);
        // next column
        count += dfs(grid, i, j+1);
        // line before
        count += dfs(grid, i-1, j);
        // column before
        count += dfs(grid, i, j-1);

        return count;
    }

    private int maxAreaOfIslandIterative(int[][] grid) {
        int maxArea = 0;
        int count = 0;

        // the helper to calculate new adjacent cells
        int[] di = new int[]{1, -1, 0, 0};
        int[] dj = new int[]{0, 0, 1, -1};

        Stack<int[]> points = new Stack<>();
        int[] tempPoint = new int[2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // if the value is 1
                // start counting and push the coordinate to the stack
                if (grid[i][j] == 1) {
                    count = 0;
                    // make it 0, so that next time this cell is encountered, it is not counted again
                    grid[i][j] = 0;
                    points = new Stack<>();
                    points.push(new int[]{i, j});

                    // as long as stack not empty (proceed all calls with value 1)
                    while (!points.isEmpty()) {
                        count++;
                        tempPoint = points.pop();
                        int oldi = tempPoint[0];
                        int oldj = tempPoint[1];

                        // visit all adjacent cells using di and dj array helper
                        for (int k = 0; k < 4; k++) {
                            int newi = oldi + di[k];
                            int newj = oldj + dj[k];

                            // if the new point (the adjacent cells) still inside the grid and the value is 1
                            if (newi > 0 && newj > 0 && newi < grid.length && newj < grid[0].length &&
                                    grid[newi][newj] == 1) {
                                points.push(new int[]{newi, newj});
                                // make it 0, so that next time this cell is encountered, it is not counted again
                                grid[newi][newj] = 0;                            }

                        }
                    }

                    maxArea = Math.max(maxArea, count);
                }
            }
        }

        return maxArea;
    }
}
