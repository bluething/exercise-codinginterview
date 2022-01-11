package week03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// There is a large pile of socks that must be paired by color.
// Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.
public class SalesByMatchTest {

    @Test
    public void case01() {
        Assertions.assertEquals(3, sockMerchant(9, Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(2, sockMerchant(7, Arrays.asList(1, 2, 1, 2, 1, 3, 2)));
    }

    private int sockMerchant(int n, List<Integer> ar) {
        int numOfPairs = 0;
        Set<Integer> uniqueSock = new HashSet<>();
        uniqueSock.add(ar.get(0));
        for (int i = 1; i < ar.size(); i++) {
            if (!uniqueSock.add(ar.get(i))) {
                uniqueSock.remove(ar.get(i));
                numOfPairs++;
            }
        }

        return numOfPairs;
    }
}
