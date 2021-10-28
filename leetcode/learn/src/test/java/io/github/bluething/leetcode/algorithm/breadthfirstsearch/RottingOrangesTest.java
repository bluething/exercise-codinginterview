package io.github.bluething.leetcode.algorithm.breadthfirstsearch;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOrangesTest {
    // You are given an m x n grid where each cell can have one of three values:
    // - 0 representing an empty cell,
    // - 1 representing a fresh orange, or
    // - 2 representing a rotten orange.
    // Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
    // Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

    int[][] directions = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};

    @Test
    public void case01() {
        Assert.assertEquals(4, orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
    }

    private int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        if (row == 1 && col == 1) {
            return grid[0][0] == 1 ? -1 : 0;
        }

        // iterate through the grid
        // if find rotten, put to queue
        // i * col + j, we can extract i and j from this
        // if find fresh orange, increment the counter
        Queue<Integer> rottens = new LinkedList<>();
        int freshOrangeCount = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    rottens.offer(i * col + j);
                } else if (grid[i][j] == 1){
                    freshOrangeCount++;
                }
            }
        }

        int elapsedTime = 0;
        // loop until we don't have any fresh orange and rottens queue already empty
        while (freshOrangeCount != 0 && !rottens.isEmpty()) {
            // proceed the rotten
            int size = rottens.size();
            elapsedTime++;

            // fresh orange become rotten
            for (int i = 0; i < size && freshOrangeCount != 0; i++) {
                // extract the coordinate of the rotten
                int current = rottens.poll();
                int currentRow = current / col;
                int currentCol = current % col;

                // go to 4 direction
                for (int[] d : directions) {
                    int x = currentRow + d[0];
                    int y = currentCol + d[1];
                    // skip if any condition below match
                    // - a and y outside the grid
                    // - we find not fresh orange
                    if (x < 0 || x >= row || y < 0 || y >= col || grid[x][y] != 1) {
                        continue;
                    }

                    // make the fresh orange rotten
                    grid[x][y] = 2;
                    // decrease the value of fresh orange
                    freshOrangeCount--;
                    if (freshOrangeCount == 0) {
                        break;
                    }

                    // put new rotten into the queue
                    // this rotten will infect the neighbors in next iteration
                    rottens.offer(x * col + y);
                }
            }
        }

        // there are case when not all orange become rotten
        return freshOrangeCount == 0 ? elapsedTime : -1;
    }
}
