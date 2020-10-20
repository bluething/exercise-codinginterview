package io.github.bluething.hackerrank.interviewpreparationkit.dictionariesandhashmaps;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/*
* The problem https://www.hackerrank.com/challenges/ctci-ransom-note/problem
* The idea is
* 1. Don't forget about corner cases!
* 2. Get word count of magazine array, save to map
* 3. No need doing (2) for note array
* 4. We only need to iterate note array. In each loop, we decrease word count of magazine map (if the word exist)
* 5. If magazine map don't have a note word, result is 'No'
* 6. If word count in magazine map < 0, result is 'No'
* */
public class RansomNoteTest {

    private String checkMagazine(String[] magazine, String[] note) {

        String result = "Yes";

        // corner case 1, note array is empty
        if(note == null || note.length == 0) {
            result = "No";
        }

        // corner case 2, note array is greater than the length of the magazine array
        if(note.length > magazine.length) {
            result = "No";
        }

        Map<String, Integer> magazineWords = new HashMap<>();
        for (String word : magazine) {
            magazineWords.put(word, magazineWords.getOrDefault(word, 0) + 1);
        }

        for (String word : note) {
            if (magazineWords.get(word) != null) {
                magazineWords.put(word, magazineWords.get(word) - 1);
                if (magazineWords.get(word) < 0) {
                    result = "No";
                    break;
                }
            } else {
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
