package io.github.bluething.leetcode.datastructure.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagramTest {

    @Test
    public void case01() {
        Assert.assertTrue(isAnagram("anagram", "nagaram"));
    }

    @Test
    public void case02() {
        Assert.assertFalse(isAnagram("rat", "car"));
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        boolean isValid = true;
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            charCount.put(s.charAt(i), charCount.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            if (charCount.containsKey(t.charAt(i))) {
                charCount.put(t.charAt(i), charCount.getOrDefault(t.charAt(i), 0) - 1);
                if (charCount.get(t.charAt(i)) < 0) {
                    isValid = false;
                    break;
                }
            } else {
                isValid = false;
                break;
            }
        }

        return isValid;
    }
}
