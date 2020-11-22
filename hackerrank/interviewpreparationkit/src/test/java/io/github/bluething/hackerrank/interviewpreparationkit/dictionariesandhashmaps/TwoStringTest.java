package io.github.bluething.hackerrank.interviewpreparationkit.dictionariesandhashmaps;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

// The problem https://www.hackerrank.com/challenges/two-strings/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class TwoStringTest {

    private String twoStringsUsingMap(String s1, String s2) {
        String result = "NO";

        String shortestWord = s1.length() > s2.length() ? s2 : s1;
        String longestWord = s1.length() > s2.length() ? s1 : s2;

        Map<Character, Integer> shortestWordMap = new HashMap<>();
        for (int i = 0; i < shortestWord.length(); i++) {
            shortestWordMap.put(Character.valueOf(shortestWord.charAt(i)), Integer.valueOf(i));
        }

        for (int i = 0; i < longestWord.length(); i++) {
            if (shortestWordMap.get(Character.valueOf(longestWord.charAt(i))) != null) {
                result = "YES";
                break;
            }
        }

        return result;
    }

    @Test
    public void successWhenInputIsRight() {
        String s1 = "hello";
        String s2 = "world";
        Assert.assertEquals("YES", twoStringsUsingMap(s1, s2));

    }

    @Test
    public void successWhenInputIsRightCaseTwo() {
        String s1 = "hi";
        String s2 = "world";
        Assert.assertEquals("NO", twoStringsUsingMap(s1, s2));

    }
}
