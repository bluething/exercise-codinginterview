package io.github.bluething.hackerrank.interviewpreparationkit.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class MarkAndToysTest {

    @Test
    public void case01() {
        Assert.assertEquals(4, maximumToys(Arrays.asList(1, 12, 5, 111, 200, 1000, 10), 50));
    }

    @Test
    public void case02() {
        Assert.assertEquals(3, maximumToys(Arrays.asList(1, 2, 3, 4), 7));
    }

    private int maximumToys(List<Integer> prices, int k) {
        int numOfToys = 0;
        int temp = 0;
        int counter = 0;
        int lastWorkingIdx = prices.size() - 1;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            lastWorkingIdx = prices.size() - 1 - counter;

            for (int i = 1; i < prices.size() - counter; i++) {
                if (prices.get(i - 1) < prices.get(i)) {
                    temp = prices.get(i);
                    prices.set(i, prices.get(i - 1));
                    prices.set(i - 1, temp);
                    isSorted = false;
                }
            }
            if (k - prices.get(lastWorkingIdx) > 0) {
                k -= prices.get(lastWorkingIdx);
                numOfToys++;
            }
            counter++;
        }

        return numOfToys;
    }
}
