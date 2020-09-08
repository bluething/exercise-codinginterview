package io.github.bluething.hackerrank.interviewpreparationkit.warmup;

import org.junit.Assert;
import org.junit.Test;

/*
* The problem https://www.hackerrank.com/challenges/repeated-string/problem
* */
public class RepeatedStringTest {

    // My idea is count 'a' emersion in string s.
    // Then we find how many s will be added until we reach n length
    // We get number of 'a' in repeated string
    // Maybe there are substring of s at the end of string (to reach n length), find the number
    // Then count 'a' in that string, add up.
    private long repeatedString(String s, long n) {
        long numOfCharA = s.chars().filter(ch -> ch == 'a').count();

        long numOfRepeatedString = n / s.length();
        numOfCharA *= numOfRepeatedString;

        // if substring have partial string at the end
        int remainingLength = (int) (n % s.length());
        if(remainingLength  != 0) {
            String remaining = s.substring(0, remainingLength);
            numOfCharA += remaining.chars().filter(ch -> ch == 'a').count();
        }

        return numOfCharA;
    }

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(7, repeatedString("aba", 10));
    }

    @Test
    public void successWhenInputIsRight2() {
        Assert.assertEquals(1000000000000L, repeatedString("a", 1000000000000L));
    }

}
