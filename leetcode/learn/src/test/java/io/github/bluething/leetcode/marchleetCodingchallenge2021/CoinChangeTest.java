package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CoinChangeTest {

    private int ans = 10001;

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(3, coinChange(new int[]{1,2,5}, 11));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(-1, coinChange(new int[]{2}, 3));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals(0, coinChange(new int[]{1}, 0));
    }

    @Test
    public void successWhenInputIsRightFour() {
        Assert.assertEquals(1, coinChange(new int[]{1}, 1));
    }

    @Test
    public void successWhenInputIsRightFive() {
        Assert.assertEquals(2, coinChange(new int[]{1}, 2));
    }

    @Test
    public void successWhenInputIsRightSix() {
        Assert.assertEquals(2, coinChange(new int[]{5, 4, 1}, 8));
    }

    @Test
    public void successWhenInputIsRightSeven() {
        Assert.assertEquals(3, coinChange(new int[]{1, 2, 5}, 11));
    }

    private int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        recursion(amount, 0, coins.length - 1, coins);

        return ans < 10001 ? ans : -1;
    }

    private void recursion(int amount, int num, int cIdx, int[] coins) {
        if (amount == 0) {
            ans = Math.min(num, ans);
        } else if (amount > 0 && cIdx >= 0) {
            int quotient  = amount / coins[cIdx];

            if (quotient  + num >= ans) {
                return;
            }

            while (quotient  >= 0) {
                recursion(amount - quotient  * coins[cIdx], num + quotient--, cIdx - 1, coins);
            }
        }
    }
}
