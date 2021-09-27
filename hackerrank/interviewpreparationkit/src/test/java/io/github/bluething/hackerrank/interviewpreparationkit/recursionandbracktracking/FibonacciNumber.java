package io.github.bluething.hackerrank.interviewpreparationkit.recursionandbracktracking;

import org.junit.Assert;
import org.junit.Test;

public class FibonacciNumber {

    @Test
    public void case01() {
        Assert.assertEquals(5, fibonacci(5));
    }

    private int fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
