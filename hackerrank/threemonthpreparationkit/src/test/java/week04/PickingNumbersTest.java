package week04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// Given an array of integers, find the longest subarray where the absolute difference between "any two elements" is less than or equal to 1.
//
// Constraint
// 2 =< n <= 100
// 0 < a[i] <= 100
public class PickingNumbersTest {

    @Test
    public void case01() {
        Assertions.assertEquals(5, pickingNumbers(Arrays.asList(1, 1, 2, 2, 4, 4, 5, 5, 5)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(5, pickingNumbers(Arrays.asList(1, 2, 2, 3, 1, 2)));
    }

    @Test
    public void case03() {
        Assertions.assertEquals(3, pickingNumbers(Arrays.asList(4, 6, 5, 3, 3, 1)));
    }

    // The key is "the absolute difference between any two elements"
    // We can't count as a sub array
    // Using the fact that n value is between 2-100
    // We use array with n length as a frequency count (avoid sorting)
    // The array index is val-1 (1-99)
    // We find the max between longestLength and sum from two consecutive index
    private int pickingNumbers(List<Integer> a) {
        int[] freqValue = new int[100];
        for (Integer val : a) {
            freqValue[val - 1]++;
        }

        int longestLength = freqValue[0];
        for (int i = 1; i < freqValue.length; i++) {
            longestLength = Math.max(longestLength, freqValue[i] + freqValue[i - 1]);
        }

        return longestLength;
    }
}
