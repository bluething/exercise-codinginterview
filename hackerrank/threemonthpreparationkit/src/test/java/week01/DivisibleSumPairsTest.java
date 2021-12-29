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

    @Test
    public void case02() {
        Assertions.assertEquals(5, divisibleSumPairs2(6, 3, Arrays.asList(1, 3, 2, 6, 1, 2)));
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

    // (a + b) % K = 0 (what we have to find)
    // Simplifying: => a%K + b%K = 0
    //  => a%K + b%K = K%K
    //  => b%K = K%K - a%K
    //  => b%K = (K - a%K) % K. {Range of a%K => [0,K-1]}
    // The idea is using an array of max size of n as a counter
    // We count how many times ar[i]%k encountered
    // For each element visited increment numOfPair by the value of an array at index (k - rem) % k
    // (k - rem) % k is the pair of ar.get(i) when (a + b) % K = 0 meet
    private int divisibleSumPairs2(int n, int k, List<Integer> ar) {
        int numOfPair = 0;
        int[] counters = new int[101];
        for (int i = 0; i < ar.size(); i++) {
            int rem = ar.get(i) % k;
            int key = (k - rem) % k;
            numOfPair += counters[key];
            counters[rem]++;
        }

        return numOfPair;
    }
}
