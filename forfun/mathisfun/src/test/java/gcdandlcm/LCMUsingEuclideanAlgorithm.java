package gcdandlcm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LCMUsingEuclideanAlgorithm {
    @Test
    public void case01() {
        Assertions.assertEquals(8, gcd(64, 40));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(32, gcd(32, 64));
    }

    @Test
    public void case03() {
        Assertions.assertEquals(6, gcd(12, 18));
    }

    @Test
    public void case04() {
        Assertions.assertEquals(36, lcmUsingEuclideanAlgorithm(18, 12));
    }

    private int lcmUsingEuclideanAlgorithm(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }

        return (a * b) / gcd(a, b);
    }
    private int gcd(int a, int b) {
        int remainder = 0;
        do {
            remainder = a % b;
            a = b;
            b = remainder;
        } while (b != 0);

        return a;
    }
}
