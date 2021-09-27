package io.github.bluething.leetcode.learn.recursion;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciNumber {

    @Test
    public void case01() {
        Assert.assertEquals(3, fib(4));
    }

    private  int fib(int n) {
        if (n < 1) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
