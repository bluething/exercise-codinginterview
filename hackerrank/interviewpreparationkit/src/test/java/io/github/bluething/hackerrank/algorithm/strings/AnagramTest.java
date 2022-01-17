package io.github.bluething.hackerrank.algorithm.strings;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

// Two words are anagrams of one another if their letters can be rearranged to form the other word.
//
//Given a string, split it into two contiguous substrings of equal length.
// Determine the minimum number of characters to change to make the two substrings into anagrams of one another.
public class AnagramTest {

    @Test
    public void case01() {
        Assert.assertEquals(1, anagram("xaxbbbxx"));
    }

    @Test
    public void case02() {
        Assert.assertEquals(5, anagram("fdhlvosfpafhalll"));
    }

    // The idea is count char frequency from 1st half
    // Then in 2nd half check if the map contain the char
    // If yes, subtract the value as long as the value > 0
    // If the value less than 0 it means 2nd half contain more char than 1st half
    // If not, increment the result
    private int anagram(String s) {
        if (s.length() % 2 != 0) {
            return -1;
        }

        int result = 0;
        Map<Character, Integer> freqChar = new HashMap<>();
        for (int i = 0; i < s.length() / 2; i++) {
            freqChar.put(s.charAt(i), freqChar.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = s.length() / 2; i < s.length(); i++) {
            if (freqChar.containsKey(s.charAt(i)) && freqChar.get(s.charAt(i)) > 0) {
                freqChar.put(s.charAt(i), freqChar.get(s.charAt(i)) - 1);
            } else {
                result++;
            }
        }

        return result;
    }
}
