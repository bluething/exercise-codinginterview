package week05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// You will be given a list of integers, arr, and a single integer k.
// You must create an array of length k from elements of arr such that its unfairness is minimized. Call that array arr'. Unfairness of an array is calculated as
// max(arr') - min(arr')
// Integers in arr may not be unique.
public class MaxMinTest {

    @Test
    public void case01() {
        Assertions.assertEquals(3, maxMin(4, Arrays.asList(1, 2, 3, 4, 10, 20, 30, 40, 100, 200)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(2, maxMin(3, Arrays.asList(100, 200, 300, 350, 400, 401, 402)));
    }

    // Use sliding window with size k
    private int maxMin(int k, List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());

        int minimumUnfairness = arr.get(k-1) - arr.get(0);
        for (int i = 1; i + k -1 < arr.size(); i++) {
            minimumUnfairness = Math.min(minimumUnfairness, arr.get(i + k - 1) - arr.get(i));
        }

        return minimumUnfairness;
    }
}
