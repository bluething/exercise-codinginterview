package week06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Given an integer n, find each x such that:
// 0 <= x <= n
// n + x = n ^ x
//
// 0 <= n <= 10 power 15
public class SumvsXORTest {

    @Test
    public void case01() {
        Assertions.assertEquals(4, sumXor(10L));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(2, sumXor(5L));
    }

    @Test
    public void case03() {
        Assertions.assertEquals(4, sumXor(4L));
    }

    public void case04() {
        Assertions.assertEquals(1099511627776L, sumXor(1099511627776L));
    }

    @Test
    public void case05() {
        Assertions.assertEquals(4, sumXor2(10L));
    }

    @Test
    public void case06() {
        Assertions.assertEquals(2, sumXor2(5L));
    }

    @Test
    public void case07() {
        Assertions.assertEquals(4, sumXor2(4L));
    }

    @Test
    public void case08() {
        Assertions.assertEquals(1099511627776L, sumXor2(1099511627776L));
    }

    // Time limit exceeded
    private long sumXor(long n) {
        long counter = 0L;
        for (long i = 0L; i <= n; i++) {
            if ((n + i) == (n ^ i)) {
                counter++;
            }
        }
        return counter;
    }

    // We need to count how many 0 bit from n
    // The answer is 2 power of num of 0 bit
    // Changing 0 bit with 0 or 1 and changing 1 bit with 0 or 1 fulfil the condition (n + x = n ^ x)
    // How many combination 0 bit can be replaced with 0 and 1.
    private long sumXor2(long n) {
        long counter = 0L;
        while (n > 0) {
            if ((n & 1) == 0) {
                counter++;
            }

            n >>= 1;
        }

        return (long) Math.pow(2, counter);
    }
}
