package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class BestTimetoBuyandSellStockwithTransactionFeeTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(8, maxProfit(new int[]{1,3,2,8,4,9}, 2));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(6, maxProfit(new int[]{1,3,7,5,10,3}, 3));
    }

    private int maxProfit(int[] prices, int fee) {
        int buying = 0;
        int selling = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            buying = Math.max(buying, selling + prices[i] - fee);
            selling = Math.max(selling, buying - prices[i]);
        }

        int maxProfit = buying;

        return maxProfit;
    }

    // the key you must sell the stock before you buy again
    // state machine logic.
    // - no stock and being ready to buy
    // - owning stock and being ready to sell
    // at 1st day we ready to buy or ready to sell (subtracts from price)
    // loop for the next n-1 days
    // ready to buy can be done by:
    // 1. ready to buy and do nothing
    // 2. ready to sell and selling
    // ready to sell can be done by:
    // 1. ready to sell and do nothing
    // 2. selling and previous buying and price today
}
