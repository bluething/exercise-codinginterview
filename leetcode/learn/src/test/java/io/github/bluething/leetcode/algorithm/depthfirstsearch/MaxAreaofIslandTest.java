package io.github.bluething.leetcode.algorithm.depthfirstsearch;

import org.junit.Assert;
import org.junit.Test;

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
}
