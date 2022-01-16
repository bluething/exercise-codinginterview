package week04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// The absolute difference is the positive difference between two values a and b, is written |a - b| or |b - a| and they are equal.
// If a=3 and b=2, |3 - 2| = |2 - 3| = 1. Given an array of integers, find the minimum absolute difference between any two elements in the array.
public class MinimumAbsoluteDifferenceInAnArrayTest {

    @Test
    public void case01() {
        Assertions.assertEquals(3, minimumAbsoluteDifference(Arrays.asList(3, -7, 0)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(1, minimumAbsoluteDifference(Arrays.asList(-59, -36, -13, 1, -53, -92, -2, -96, -54, 75)));
    }

    @Test
    public void case03() {
        Assertions.assertEquals(3, minimumAbsoluteDifference(Arrays.asList(1, -3, 71, 68, 17)));
    }

    // Hit time limit exceed
    private int minimumAbsoluteDifference(List<Integer> arr) {
        int minimumDifference = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                minimumDifference = Math.min(minimumDifference, Math.abs(arr.get(i) - arr.get(j)));
            }
        }

        return minimumDifference;
    }
}
