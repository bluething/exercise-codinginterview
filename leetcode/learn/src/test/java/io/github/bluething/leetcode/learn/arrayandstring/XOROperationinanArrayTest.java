package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

// The problem https://leetcode.com/problems/xor-operation-in-an-array/
public class XOROperationinanArrayTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(8, xorOperation(5, 0));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(8, xorOperation(4, 3));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals(7, xorOperation(1, 7));
    }

    @Test
    public void successWhenInputIsRightFour() {
        Assert.assertEquals(2, xorOperation(10, 5));
    }

    private int xorOperation(int n, int start) {
        int xorResult = 0;

        for (int i = 0; i < n; i++) {
            xorResult ^= (start + (2 * i));
        }

        return xorResult;
    }
}
