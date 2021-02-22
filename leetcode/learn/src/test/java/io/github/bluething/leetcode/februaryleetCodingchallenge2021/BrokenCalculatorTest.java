package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class BrokenCalculatorTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(1023, brokenCalc(1024, 1));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(3, brokenCalc(3, 10));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals(2, brokenCalc(5, 8));
    }

    @Test
    public void successWhenInputIsRightFour() {
        Assert.assertEquals(2, brokenCalc(2, 3));
    }

    private int brokenCalc(int X, int Y) {
        int numOps = 0;
        while (X < Y) {
            numOps++;
            if (Y % 2 > 0) {
                Y++;
            } else {
                Y /= 2;
            }
        }

        return X - Y + numOps;
    }
}
