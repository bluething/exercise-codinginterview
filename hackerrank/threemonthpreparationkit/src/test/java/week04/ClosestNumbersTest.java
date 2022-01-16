package week04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

// Sorting is useful as the first step in many different tasks. The most common task is to make finding things easier, but there are other uses as well.
// In this case, it will make it easier to determine which pair or pairs of elements have the smallest absolute difference between them.
//
// Given a list of unsorted integers, arr, find the pair of elements that have the smallest absolute difference between them.
// If there are multiple pairs, find them all.
//
// All a[i] are unique in arr.
public class ClosestNumbersTest {

    @Test
    public void case01() {
        Assertions.assertEquals(Arrays.asList(-20, 30),
                closestNumbers(Arrays.asList(-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(Arrays.asList(-520, -470, -20, 30),
                closestNumbers(Arrays.asList(-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854, -520, -470)));
    }

    @Test
    public void case03() {
        Assertions.assertEquals(Arrays.asList(2, 3, 3, 4, 4, 5), closestNumbers(Arrays.asList(5, 4, 3, 2)));
    }

    @Test
    public void case04() {
        Assertions.assertEquals(Arrays.asList(-20, 30),
                closestNumbers2(Arrays.asList(-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854)));
    }

    @Test
    public void case05() {
        Assertions.assertEquals(Arrays.asList(-520, -470, -20, 30),
                closestNumbers2(Arrays.asList(-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854, -520, -470)));
    }

    @Test
    public void case06() {
        Assertions.assertEquals(Arrays.asList(2, 3, 3, 4, 4, 5), closestNumbers2(Arrays.asList(5, 4, 3, 2)));
    }

    // The key is value in arr is unique
    // We only need to calculate abs value from a[i+1]-a[i] then see if the value is the smallest or not
    // I use stack to help store the pairs
    private List<Integer> closestNumbers(List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());
        Stack<Integer> closetPairs = new Stack<>();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - 1; i++) {
            int arr1 = arr.get(i);
            int arr2 = arr.get(i + 1);
            int difference = Math.abs(arr1 -  arr2);
            if (difference < minDistance) {
                minDistance = difference;
                closetPairs.clear();
                closetPairs.push(arr1);
                closetPairs.push(arr2);
            } else if (difference == minDistance) {
                closetPairs.push(arr1);
                closetPairs.push(arr2);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!closetPairs.isEmpty()) {
            result.add(closetPairs.pop());
        }
        result.sort(Comparator.naturalOrder());

        return result;
    }

    // More efficient, no need to double sort
    private List<Integer> closestNumbers2(List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());
        List<Integer> uniquePairs = new ArrayList<>();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size() - 1; i++) {
            int arr1 = arr.get(i);
            int arr2 = arr.get(i + 1);
            int difference = Math.abs(arr1 -  arr2);
            if (difference < minDistance) {
                minDistance = difference;
                uniquePairs = new ArrayList<>();
                uniquePairs.add(arr1);
                uniquePairs.add(arr2);
            } else if (difference == minDistance) {
                uniquePairs.add(arr1);
                uniquePairs.add(arr2);
            }
        }

        return uniquePairs;
    }
}
