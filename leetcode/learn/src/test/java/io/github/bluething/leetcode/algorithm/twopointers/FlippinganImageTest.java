package io.github.bluething.leetcode.algorithm.twopointers;

import org.junit.Assert;
import org.junit.Test;

public class FlippinganImageTest {

    @Test
    public void case01() {
        Assert.assertArrayEquals(new int[][]{{1,0,0},{0,1,0},{1,1,1}}, flipAndInvertImage(new int[][]{{1,1,0},{1,0,1},{0,0,0}}));
    }

    @Test
    public void case02() {
        Assert.assertArrayEquals(new int[][]{{1,1,0,0},{0,1,1,0},{0,0,0,1},{1,0,1,0}}, flipAndInvertImage(new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}}));
    }

    @Test
    public void case03() {
        Assert.assertArrayEquals(new int[][]{{1,0,0},{0,1,0},{1,1,1}}, flipAndInvertImage2(new int[][]{{1,1,0},{1,0,1},{0,0,0}}));
    }

    @Test
    public void case04() {
        Assert.assertArrayEquals(new int[][]{{1,1,0,0},{0,1,1,0},{0,0,0,1},{1,0,1,0}}, flipAndInvertImage2(new int[][]{{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}}));
    }

    public int[][] flipAndInvertImage(int[][] image) {
        int row = image.length;
        int col = image[0].length;
        for (int i = 0; i < row; i++) {
            image[i] = flip(image[i]);
        }
        for (int i = 0; i < row; i++) {
            image[i] = invert(image[i]);
        }

        return image;
    }

    private int[] flip(int[] array) {
        int i = 0;
        int j = array.length - 1;
        int temp = 0;
        while (i < j) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }

        return array;
    }

    private int[] invert(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                array[i] = 0;
            }
        }

        return array;
    }

    // no need twice operation
    // if the value from right and left are same, just flip them
    // if they are different, don't do anything, flip then inverse will result the same value
    public int[][] flipAndInvertImage2(int[][] image) {
        for (int[] row : image) {
            int i = 0;
            int j = row.length - 1;
            while (i <= j) {
                if (row[i] == row[j]) {
                    row[i] ^= 1;
                    row[j] = row[i];
                }
                i++;
                j--;
            }
        }

        return image;
    }
}
