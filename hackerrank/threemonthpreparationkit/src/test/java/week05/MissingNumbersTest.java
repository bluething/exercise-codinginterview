package week05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

// Given two arrays of integers, find which elements in the second array are missing from the first array.
//
// If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number.
// Return the missing numbers sorted ascending.
// Only include a missing number once, even if it is missing multiple times.
// The difference between the maximum and minimum numbers in the original list is less than or equal to 100.
public class MissingNumbersTest {

    @Test
    public void case01() {
        List<Integer> arr = Arrays.asList(203, 204, 205, 206, 207, 208, 203, 204, 205, 206);
        List<Integer> brr = Arrays.asList(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204);
        List<Integer> expected = Arrays.asList(204, 205, 206);

        Assertions.assertEquals(expected, missingNumbers(arr, brr));
    }

    private List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        Map<Integer, Integer> arrFreq = new TreeMap<>();
        for (Integer val : arr) {
            arrFreq.put(val, arrFreq.getOrDefault(val, 0) + 1);
        }

        Map<Integer, Integer> brrFreq = new TreeMap<>();
        for (Integer val : brr) {
            brrFreq.put(val, brrFreq.getOrDefault(val, 0) + 1);
        }

        List<Integer> missingValues = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : brrFreq.entrySet()) {
            if (!arrFreq.containsKey(entry.getKey())) {
                missingValues.add(entry.getKey());
            } else if (!arrFreq.get(entry.getKey()).equals(entry.getValue())){
                missingValues.add(entry.getKey());
            }
        }

        return missingValues;
    }
}
