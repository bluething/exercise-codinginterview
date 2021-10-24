package io.github.bluething.leetcode.algorithm.depthfirstsearch;

import org.junit.Assert;
import org.junit.Test;

public class FloodFillTest {

    @Test
    public void case01() {
        Assert.assertArrayEquals(new int[][]{{2,2,2}, {2,2,0}, {2,0,1}},
                floodFill(new int[][]{{1,1,1}, {1,1,0}, {1,0,1}}, 1, 1, 2));
    }

    @Test
    public void case02() {
        Assert.assertArrayEquals(new int[][]{{2,2,2}, {2,2,2}},
                floodFill(new int[][]{{0,0,0}, {0,0,0}}, 0, 0, 2));
    }

    private int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) {
            return floodFillDFS(image, sr, sc, newColor, color);
        }
        return image;
    }

    private int[][] floodFillDFS(int[][] image, int sr, int sc, int newColor, int color) {
        if (image[sr][sc] == color) {
            image[sr][sc] = newColor;

            // see line before
            if (sr >= 1) {
                floodFillDFS(image, sr-1, sc, newColor, color);
            }
            // see column before
            if (sc >= 1) {
                floodFillDFS(image, sr, sc-1, newColor, color);
            }
            // see line after
            if (sr + 1 < image.length) {
                floodFillDFS(image, sr+1, sc, newColor, color);
            }
            // see column after
            if (sc + 1 < image[0].length) {
                floodFillDFS(image, sr, sc+1, newColor, color);
            }
        }

        return image;
    }
}
