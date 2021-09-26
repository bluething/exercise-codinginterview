package io.github.bluething.hackerrank.interviewpreparationkit.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SortingBubbleSortTest {

    @Test
    public void case01() {
        countSwaps(Arrays.asList(1, 2, 3));
    }

    @Test
    public void case02() {
        countSwaps(Arrays.asList(3, 2, 1));
    }

    @Test
    public void case03() {
        countSwaps(Arrays.asList(4, 3, 2, 1));
    }

    private void countSwaps(List<Integer> a) {
        int temp = 0;
        int numSwaps = 0;
        for (int i = 0; i < a.size(); i++) {
            for (int j = i+1; j < a.size(); j++) {
                if (a.get(i) > a.get(j)) {
                    temp = a.get(j);
                    a.set(j, a.get(i));
                    a.set(i, temp);
                    numSwaps++;
                }
            }
        }

        System.out.println("Array is sorted in "+ numSwaps +" swaps.");
        System.out.println("First Element: " + a.get(0));
        System.out.println("Last Element: " + a.get(a.size() - 1));
    }
}
