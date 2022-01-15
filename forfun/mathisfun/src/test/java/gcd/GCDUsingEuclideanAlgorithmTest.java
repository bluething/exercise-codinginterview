package gcd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GCDUsingEuclideanAlgorithmTest {

    @Test
    public void case01() {
        Assertions.assertEquals(8, gcdUsingEuclideanAlgorithm(64, 40));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(32, gcdUsingEuclideanAlgorithm(32, 64));
    }

    @Test
    public void case03() {
        Assertions.assertEquals(8, gcdUsingEuclideanAlgorithmWithSubtraction(64, 40));
    }

    @Test
    public void case04() {
        Assertions.assertEquals(32, gcdUsingEuclideanAlgorithmWithSubtraction(32, 64));
    }

    // modulo == many subtractions at a time
    public int gcdUsingEuclideanAlgorithm(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcdUsingEuclideanAlgorithm(b, a%b);
    }

    // smaller number is subtracted from a bigger number
    public int gcdUsingEuclideanAlgorithmWithSubtraction(int a, int b) {
        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        // base case
        if (a == b) {
            return a;
        }

        if (a > b) {
            return gcdUsingEuclideanAlgorithmWithSubtraction(a-b, b);
        }
        return gcdUsingEuclideanAlgorithmWithSubtraction(a, b-a);
    }
}
