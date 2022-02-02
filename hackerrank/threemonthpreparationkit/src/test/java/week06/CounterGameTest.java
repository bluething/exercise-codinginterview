package week06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Louise and Richard have developed a numbers game.
// They pick a number and check to see if it is a power of 2.
// If it is, they divide it by 2. If not, they reduce it by the next lower number which is a power of 2.
// Whoever reduces the number to  wins the game. Louise always starts.
//
//Given an initial value, determine who wins the game.
public class CounterGameTest {

    @Test
    public void case01() {
        Assertions.assertEquals("Richard", counterGame(6));
    }

    @Test
    public void case02() {
        Assertions.assertEquals("Louise", counterGame(1877182773));
    }

    @Test
    public void case03() {
        Assertions.assertEquals("Richard", counterGame(1073741824));
    }

    @Test
    public void case04() {
        Assertions.assertEquals("Louise", counterGame(1900082075));
    }

    @Test
    public void case05() {
        Assertions.assertEquals("Louise", counterGame(2));
    }

    // Need to check the result of log(n) base 2
    // If not fraction (n is a power of 2), divide by 2
    // If fraction, subtract with the lower number which is a power of 2
    private String counterGame(long n) {
        int counter = 0;
        while (n > 1) {
            double log2 = Math.log(n) / Math.log(2);
            if (log2 % 1 == 0.0) {
                n /= 2;
            } else {
                n -= (long) Math.pow(2, Math.floor(log2));
            }
            counter++;
        }
        return counter % 2 == 0 ? "Richard" : "Louise";
    }
}
