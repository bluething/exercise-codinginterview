package gcdandlcm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GCDUsingBruteForceAlgorithmTest {
    @Test
    public void case01() {
        Assertions.assertEquals(8, gcdUsingBruteForceAlgorithm(64, 40));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(32, gcdUsingBruteForceAlgorithm(32, 64));
    }

    // O(min(a, b))
    private int gcdUsingBruteForceAlgorithm(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }

        return gcd;
    }
}
