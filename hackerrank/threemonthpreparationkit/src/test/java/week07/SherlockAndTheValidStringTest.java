package week07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// Sherlock considers a string to be valid if all characters of the string appear the same number of times.
// It is also valid if he can remove just 1 character at 1 index in the string, and the remaining characters will occur the same number of times.
// Given a string s, determine if it is valid. If so, return YES, otherwise return NO.
public class SherlockAndTheValidStringTest {

    @Test
    public void case01() {
        Assertions.assertEquals("NO", isValid("aabbcd"));
    }

    @Test
    public void case02() {
        Assertions.assertEquals("YES", isValid("abcc"));
    }

    @Test
    public void case03() {
        Assertions.assertEquals("YES", isValid("abc"));
    }

    @Test
    public void case04() {
        Assertions.assertEquals("NO", isValid("aaaabbcc"));
    }

    @Test
    public void case05() {
        Assertions.assertEquals("YES", isValid("aabbc"));
    }

    @Test
    public void case06() {
        Assertions.assertEquals("YES", isValid("aabbccc"));
    }

    private String isValid(String s) {
        int[] charCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 97]++;
        }

        // I want to count how many char have same frequency
        int minOccurrence = Integer.MAX_VALUE;
        int maxOccurrence = Integer.MIN_VALUE;
        Map<Integer, Integer> freqCount = new HashMap<>();
        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] != 0) {
                freqCount.put(charCount[i], freqCount.getOrDefault(charCount[i], 0) + 1);
                minOccurrence = Math.min(minOccurrence, charCount[i]);
                maxOccurrence = Math.max(maxOccurrence, charCount[i]);
            }
        }

        // If the map size 1 means all char have same frequency
        // If the map size > 2 means there are 3 different chars that have different frequency
        if (freqCount.size() == 1) {
            return "YES";
        } else if (freqCount.size() > 2) {
            return "NO";
        }

        // What if the map size is 2? There are 2 char groups that have different frequency
        // The answer is YES if meet one of this condition
        // 1. The min frequency count is 1 and the number of char that have 1 frequency is 1 -> case aabbc
        // 2. The max frequency count is 1 and the different between max and min occurrence is 1 -> case aabbccc
        if ((freqCount.get(minOccurrence) == 1 && minOccurrence == 1) ||
                (freqCount.get(maxOccurrence) == 1 && maxOccurrence == minOccurrence + 1)) {
            return "YES";
        }

        return "NO";
    }
}