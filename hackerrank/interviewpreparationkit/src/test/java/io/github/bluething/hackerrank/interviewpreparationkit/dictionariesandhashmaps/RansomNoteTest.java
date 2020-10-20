package io.github.bluething.hackerrank.interviewpreparationkit.dictionariesandhashmaps;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*
* The problem https://www.hackerrank.com/challenges/ctci-ransom-note/problem
* */
public class RansomNoteTest {

    private String checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> magazineWords = new HashMap<>();
        for (String word : magazine) {
            magazineWords.put(word, magazineWords.getOrDefault(word, 0) + 1);
        }

        Map<String, Integer> noteWords = new HashMap<>();
        for (String word : note) {
            noteWords.put(word, noteWords.getOrDefault(word, 0) + 1);
        }

        String result = "Yes";

        for (String word : noteWords.keySet()) {
            if (noteWords.get(word) != magazineWords.get(word)) {
                result = "No";
                break;
            }
        }

        return result;
    }

    @Test
    public void successWhenInputIsRight() {
        String[] magazine = "ive got a lovely bunch of coconuts".split("\\s+");
        String[] note = "ive got some coconuts".split("\\s+");
        Assert.assertEquals("No", checkMagazine(magazine, note));
    }

    @Test
    public void successWhenInputIsRightCaseTwo() {
        String[] magazine = "two times three is not four".split("\\s+");
        String[] note = "two times two is four".split("\\s+");
        Assert.assertEquals("No", checkMagazine(magazine, note));
    }

}
