package io.github.bluething.hackerrank.interviewpreparationkit.warmup;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/*
* The problem https://www.hackerrank.com/challenges/sock-merchant/problem
* */
public class SockMerchantTest {

    private int sockMerchant(int n, int[] ar) {
        int pair = 0;
        Set uniqueSock = new HashSet();
        for(int i = 0; i < n; i++) {
            if(!uniqueSock.add(ar[i])) {
                pair++;
                uniqueSock.remove(ar[i]);
            }
        }
        return pair;
    }

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(3, sockMerchant(9, new int[]{10, 20, 20, 10, 10, 30, 50, 10, 20}));
    }

}
