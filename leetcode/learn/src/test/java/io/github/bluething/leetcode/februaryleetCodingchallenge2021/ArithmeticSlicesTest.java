package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class ArithmeticSlicesTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(3, numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
    }

    private int numberOfArithmeticSlices(int[] A) {
        if (A.length == 0 || A.length < 2) {
            return 0;
        }

        int count = 0;
        boolean[][] idxChecked = new boolean[A.length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                if (j - i < 2) {
                    continue;
                }
                if ((j - i > 2) && !idxChecked[i][j - 1]) {
                    continue;
                }
                if (A[j] - A[j - 1] == A[j -1] - A[j -2]) {
                   idxChecked[i][j] = true;
                }

                if (idxChecked[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }

    // The key is "if it consists of at least three elements and if the difference between any two consecutive elements is the same"
    // What we need is calculate differences between >=3 consecutive index.
    // Using 2 loop (n ^ 2)
    // In inner loop we check if difference between i and j < 2
    // of if difference > 2, we need to check if the index before is not 'arithmetic'
    // if 3 consecutive index have same difference, mark idx from i to j as  arithmetic

}
