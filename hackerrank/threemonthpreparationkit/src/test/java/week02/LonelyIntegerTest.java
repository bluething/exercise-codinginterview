package week02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// Given an array of integers, where all elements but one occur twice, find the unique element.
public class LonelyIntegerTest {

    @Test
    public void case01() {
        Assertions.assertEquals(4, lonelyinteger(Arrays.asList(1, 2, 3, 4, 3, 2, 1)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(4, lonelyinteger2(Arrays.asList(1, 2, 3, 4, 3, 2, 1)));
    }

    private int lonelyinteger(List<Integer> a) {
        int[] counter = new int[101];
        for (int i = 0; i < a.size(); i++) {
            counter[a.get(i)]++;
        }

        int lonely = 0;
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] == 1) {
                lonely = i;
                break;
            }
        }

        return lonely;
    }

    // keep XORing the values till all but one cancel each other out
    // 1^1 = 0
    // 2^2 = 0
    // 5^1 = 4
    private int lonelyinteger2(List<Integer> a) {
        int lonely = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            lonely ^= a.get(i);
        }

        return lonely;
    }
}
