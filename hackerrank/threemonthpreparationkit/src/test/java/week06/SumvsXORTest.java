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

    @Test
    public void case04() {
        Assertions.assertEquals(1099511627776L, sumXor(1099511627776L));
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
}
