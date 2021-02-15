package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class TheKWeakestRowsinaMatrixTest {

    @Test
    public void successWhenInputIsRightCaseOne() {
        int[][] mat = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };

        Assert.assertArrayEquals(new int[]{2,0,3}, kWeakestRows(mat, 3));
    }

    @Test
    public void successWhenInputIsRightCaseTwo() {
        int[][] mat = {
                {1,0,0,0},
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0}
        };

        Assert.assertArrayEquals(new int[]{0, 2}, kWeakestRows(mat, 2));
    }

    private int[] kWeakestRows(int[][] mat, int k) {
        int[] numOfSoldier = new int[mat.length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                numOfSoldier[i] += mat[i][j];
            }
            numOfSoldier[i] = (numOfSoldier[i] * mat.length) + i;
        }

        Arrays.sort(numOfSoldier);
        int[] weakestRow = new int[k];
        for (int i = 0; i < weakestRow.length; i++) {
            weakestRow[i] = numOfSoldier[i] % mat.length;
        }

        return weakestRow;
    }

    // Using modulo, we want to extract rowIndex from numOfSoldier
    // The key is we change how we see the problem (number of soldiers)
    // We can, find number of soldiers for each rows, but at the end we need to sort numOfSoldier based on criteria
    // "A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or they have the same number of soldiers but i is less than j."
    // It's hard (for me) and maybe not optimize.
    // So after we have numOfSoldier in each loop, we multiply by number of rows then added by row index.
    // Why use number of rows? It's constant in all loop and we can use later to get the row index.
    // Sort it.
    // At the end we only nee to iterate numOfSoldier as much as weakestRow.length and get the remainder (this is the row index)
}
