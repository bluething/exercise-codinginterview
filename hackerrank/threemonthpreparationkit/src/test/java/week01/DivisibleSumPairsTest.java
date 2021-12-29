package week01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// Given an array of integers and a positive integer k, determine the number of (i,j) pairs where i < j and ar[i] + ar[j] is divisible by k
public class DivisibleSumPairsTest {

    @Test
    public void case01() {
        Assertions.assertEquals(5, divisibleSumPairs(6, 3, Arrays.asList(1, 3, 2, 6, 1, 2)));
    }

    private int divisibleSumPairs(int n, int k, List<Integer> ar) {
        int numOfPair = 0;
        for (int i = 0; i < ar.size() - 1; i++) {
            for (int j = i + 1; j < ar.size(); j++) {
                if ((ar.get(i) + ar.get(j)) % k == 0) {
                    numOfPair++;
                }
            }
        }

        return numOfPair;
    }
}
