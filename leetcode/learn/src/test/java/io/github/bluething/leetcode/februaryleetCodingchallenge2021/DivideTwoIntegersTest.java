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

    @Test
    public void successWhenInputIsRightFour() {
        Assert.assertEquals(2147483647, divide(-2147483648, -1));
    }

    @Test
    public void successWhenInputIsRightFive() {
        Assert.assertEquals(-2147483648, divide(-2147483648, 1));
    }

    @Test
    public void successWhenInputIsRightSix() {
        Assert.assertEquals(1, divide(-2147483648,-2147483648));
    }

    private int divide(int dividend, int divisor) {
        int sign = (dividend < 0 ^ divisor < 0) ? -1 : 1;
        // handle edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (dividend == divisor) {
            return sign;
        }

        int quotient = 0;
        if (dividend < 0)
            dividend = -dividend;
        if (divisor < 0) {
            divisor =-divisor;
        }
        int bitNumber = 0;
        int multiplication  = divisor;
        while (dividend - divisor >= 0) {
            bitNumber = 0;
            multiplication  = divisor;
            while (multiplication  > 0 && dividend - multiplication >= 0) {
                multiplication = divisor << ++bitNumber;
            }
            dividend -= divisor << (bitNumber - 1);
            quotient += 1 << (bitNumber - 1);
        }

        return sign * quotient;
    }

    // Things we need to remember when doing the division is we only care with absolute value
    // But we need to know the quotient sign, XOR from dividend sign and divisor sign
    // The hard part is dividend can be of value Integer.MIN_VALUE. Which is when we absolute that value we get 0;
    // We can't use long type because the problem statement "could only store integers within the 32-bit signed integer range"
    // We can't use multiplication, division, and mod operator. So we use bitwise operator.
    // We count how many times we can bitwise shift divisor to the left while still staying under dividend
    // Start over with the remaining amount of dividend and repeat this process, adding the results to quotient as we go.
    // However, even I can pass my test cases (which is cover some edge value). Still in some case we hit time Limit Exceeded
    // So I try to handle those case special
}
