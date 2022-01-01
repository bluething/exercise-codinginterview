package week02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// You will be given a list of 32 bit unsigned integers. Flip all the bits (1->0 and 0->1) and return the result as an unsigned integer.
public class FlippingBitsTest {

    @Test
    public void case01() {
        Assertions.assertEquals(2147483648L, flippingBits(2147483647L));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(4294967294L, flippingBits(1L));
    }

    @Test
    public void case03() {
        Assertions.assertEquals(4294967295L, flippingBits(0L));
    }

    // 0xffffffffL = 4294967295 -> unsigned 32-bit integer
    // The bitwise complement (~) of any integer N is equal to - (N + 1)
    // 35 = 00100011 (In Binary)
    // ~35 = 11011100
    // 11011100 = 2's complement of 36 (-36)
    private long flippingBits(long n) {
        System.out.println(~3L);
        return ~n & 0xffffffffL;
    }
}
