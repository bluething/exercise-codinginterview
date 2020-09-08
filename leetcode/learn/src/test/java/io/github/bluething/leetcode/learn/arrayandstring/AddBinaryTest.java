package io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;
import org.junit.Test;

/*
* The problem https://leetcode.com/explore/learn/card/array-and-string/203/introduction-to-string/1160/
* */
public class AddBinaryTest {

    // The idea is iterate both string, get char from behind.
    // Each iteration add the value, sum.
    // Binary digit is 1 and 0, so we need carry from sum. Shift left 1 the sum and we get the carry.
    // The carry is a sum for next iteration.
    // We need do something with the sum? We use bitwise operator &.
    // Why 1? If sum is 3 (max sum), teh sum will give 1 for stringBuilder
    // Don't forget carry, if > 0, add to stringBuilderstringBuilder
    private String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int countA = a.length() - 1;
        int countB = b.length() - 1;
        int carry = 0;
        int sum = 0;
        while (countA >= 0 || countB >= 0) {
            sum = carry;
            if(countA >= 0) {
                sum += a.charAt(countA) - '0';
                countA--;
            }
            if(countB >= 0) {
                sum += b.charAt(countB) - '0';
                countB--;
            }

            carry = sum >> 1;
            sum = sum & 1;

            stringBuilder.insert(0, sum == 0 ? '0' : '1');
        }

        if(carry > 0) {
            stringBuilder.insert(0, '1');
        }

        return stringBuilder.toString();
    }

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals("100", addBinary("11", "1"));
    }
}
