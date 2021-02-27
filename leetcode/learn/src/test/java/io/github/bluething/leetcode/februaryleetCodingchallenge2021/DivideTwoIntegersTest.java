package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class DivideTwoIntegersTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(3, divide(10, 3));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(-2, divide(7, -3));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals(0, divide(0, 1));
    }

    private int divide(int dividend, int divisor) {
        int quotient = 0;
        int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend >= divisor) {
            dividend -= divisor;
            quotient++;
        }

        return sign * quotient;
    }

    // Things we need to remember when doing the division is we only care with absolute value
    // But we need to know the quotient sign, XOR from dividend sign and divisor sign
    // We can't use multiplication, division, and mod operator. So we use subtraction operator.
}
