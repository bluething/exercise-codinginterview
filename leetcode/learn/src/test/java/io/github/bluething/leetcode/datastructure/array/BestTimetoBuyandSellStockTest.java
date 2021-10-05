package io.github.bluething.leetcode.datastructure.array;

import org.junit.Assert;
import org.junit.Test;

public class BestTimetoBuyandSellStockTest {

    @Test
    public void case01() {
        Assert.assertEquals(5, maxProfit(new int[]{7,1,5,3,6,4}));
    }

    private int maxProfit(int[] prices) {
        int buying = prices[0];
        int provit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buying) {
                buying = prices[i];
            } else {
                provit = Math.max(provit, prices[i] - buying);
            }
        }

        return provit;
    }

    // the key is we buy in present then sell in the future
    // so find the min value than previous one
    // if the value greater than before, calculate the profit
}
