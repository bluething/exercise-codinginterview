package io.github.bluething.leetcode.datastructure.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RansomNoteTest {

    @Test
    public void case01() {
        Assert.assertFalse(canConstruct("a", "b"));
    }

    @Test
    public void case02() {
        Assert.assertFalse(canConstruct("aa", "ab"));
    }

    @Test
    public void case03() {
        Assert.assertTrue(canConstruct("aa", "aab"));
    }

    @Test
    public void case01WithSolution2() {
        Assert.assertFalse(canConstruct2("a", "b"));
    }

    @Test
    public void case02WithSolution2() {
        Assert.assertFalse(canConstruct2("aa", "ab"));
    }

    @Test
    public void case03WithSolution3() {
        Assert.assertTrue(canConstruct2("aa", "aab"));
    }

    private boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote.length() == 0) {
            return false;
        }
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        boolean isValid = true;

        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < ransomNote.length(); i++) {
            counter.put(ransomNote.charAt(i), counter.getOrDefault(ransomNote.charAt(i), 0) + 1);
        }

        for (int i = 0; i < magazine.length(); i++) {
            if (counter.containsKey(magazine.charAt(i))) {
                counter.put(magazine.charAt(i), counter.getOrDefault(magazine.charAt(i), 0) - 1);
            }
        }

        for (var entry : counter.entrySet()) {
            if (entry.getValue() > 0) {
                isValid = false;
                break;
            }
        }

        return isValid;
    }

    private boolean canConstruct2(String ransomNote, String magazine) {
        int[] counterChar = new int[26];
        int count = 0;

        for (int i = 0; i < ransomNote.length(); i++) {
            counterChar[ransomNote.charAt(i) - 'a']++;
            count++;
        }

        for (int i = 0; i < magazine.length(); i++) {
            if (counterChar[magazine.charAt(i) - 'a'] > 0) {
                counterChar[magazine.charAt(i) - 'a']--;
                count--;
            }
        }

        return count == 0;
    }
}
