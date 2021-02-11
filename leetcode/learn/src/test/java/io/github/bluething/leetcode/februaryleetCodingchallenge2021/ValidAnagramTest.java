package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagramTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(true,isAnagram("anagram", "nagaram"));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(false, isAnagram("rat", "car"));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals(false, isAnagram("a", "ab"));
    }

    private boolean isAnagram(String s, String t) {
        if (s.equalsIgnoreCase(t)) {
            return true;
        }

        if (s.length() != t.length()) {
            return false;
        }

        boolean isValid = true;

        Map<Character, Integer> charSFrequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charSFrequency.put(s.charAt(i), charSFrequency.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Character, Integer> charFFrequency = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            charFFrequency.put(t.charAt(i), charFFrequency.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (Character c : charSFrequency.keySet()) {
            if (!charSFrequency.get(c).equals(charFFrequency.get(c))) {
                isValid = false;
            }
        }

        return isValid;
    }
}
