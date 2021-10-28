package io.github.bluething.leetcode.algorithm.depthfirstsearch;

import org.junit.Assert;
import org.junit.Test;

public class Matrix01Test {
    int[][] directions = new int[][]{{0,-1},{0,1},{1,0},{-1,0}};
    boolean[][] visited = null;

    @Test
    public void case01() {
        int[][] input = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int[][] expected = new int[][]{{0,0,0},{0,1,0},{0,0,0}};

        Assert.assertArrayEquals(expected, updateMatrix(input));
    }

    @Test
    public void case02() {
        int[][] input = new int[][]{{0,0,0},{0,1,0},{1,1,1}};
        int[][] expected = new int[][]{{0,0,0},{0,1,0},{1,2,1}};

        Assert.assertArrayEquals(expected, updateMatrix(input));
    }

    private int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // if we found 0 then visit all neighbor and init the distance by 0
                if (mat[i][j] == 0) {
                    dfs(mat, i, j, row, col, 0);
                }
            }
        }

        return mat;
    }

    private void dfs(int[][] mat, int i, int j, int row, int col, int distance) {
        // return if any of below condition match
        // 1. i or j outside the array
        // 2. the value is 0 but the distance is not 0, this condition occur when we visit the neighbor
        if (i < 0 || i >= row || j < 0 || j >= col || (mat[i][j] == 0 && distance != 0)) {
            return;
        }

        if (visited[i][j] && mat[i][j] <= distance) {
            return;
        }

        // update the value
        mat[i][j] = distance;
        // mark the coordinate
        visited[i][j] = true;

        // move to 4 directions
        // in each move add the distance by 1
        for (int k = 0; k < 4; k++) {
            dfs(mat, i + directions[k][0], j + directions[k][1], row, col, distance+1);
        }
    }
}
