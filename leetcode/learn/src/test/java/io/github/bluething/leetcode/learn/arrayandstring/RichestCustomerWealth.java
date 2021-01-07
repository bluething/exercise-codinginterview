package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

public class RichestCustomerWealth {

    @Test
    public void successWhenInputIsRightCaseOne() {
        Assert.assertEquals(6, maximumWealth(new int[][]{{1,2,3},{3,2,1}}));
    }

    @Test
    public void successWhenInputIsRightCaseTwo() {
        Assert.assertEquals(17, maximumWealth(new int[][]{{2,8,7},{7,1,3},{1,9,5}}));
    }

    public int maximumWealth(int[][] accounts) {
        int[] sumEachCustomer = new int[accounts.length];

        int maxSum = 0;

        for (int i = 0; i < accounts.length; i++) {

            for (int j = 0; j < accounts[i].length; j++) {
                sumEachCustomer[i] += accounts[i][j];
            }

            if (maxSum <= sumEachCustomer[i]) {
                maxSum = sumEachCustomer[i];
            }
        }


        return maxSum;
    }

}
