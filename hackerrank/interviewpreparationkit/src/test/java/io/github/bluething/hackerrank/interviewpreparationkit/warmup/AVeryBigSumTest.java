package io.github.bluething.hackerrank.interviewpreparationkit.warmup;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AVeryBigSumTest {

    @Test
    public void case01() {
        Assert.assertEquals(5000000015L, aVeryBigSum(Arrays.asList(1000000001L, 1000000002L, 1000000003L, 1000000004L, 1000000005L)));
    }

    private long aVeryBigSum(List<Long> ar) {
        long sum = 0L;
        for (Long val : ar) {
            sum += val.longValue();
        }

        return sum;
    }
}
