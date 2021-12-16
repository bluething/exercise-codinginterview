package io.github.bluething.hackerrank.interviewpreparationkit.warmup;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class SimpleArraySumTest {

    @Test
    public void case01() {
        Assert.assertEquals(31, simpleArraySum(Arrays.asList(1, 2, 3, 4, 10, 11)));
    }

    private int simpleArraySum(List<Integer> ar) {
        int sum = 0;
        for (Integer val : ar) {
            sum += val.intValue();
        }

        return sum;
    }
}
