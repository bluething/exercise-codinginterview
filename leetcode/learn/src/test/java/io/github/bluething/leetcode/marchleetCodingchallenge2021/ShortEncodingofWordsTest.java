package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortEncodingofWordsTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(10, minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(2, minimumLengthEncoding(new String[]{"t"}));
    }

    private int minimumLengthEncoding(String[] words) {
        Set<String> uniqueString = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            if (uniqueString.contains(word)) {
                for (int i = 1; i < word.length(); i++) {
                    uniqueString.remove(word.substring(i));
                }
            }
        }

        int minLength = uniqueString.size();
        for (String word : uniqueString) {
            minLength += word.length();
        }

        return minLength;
    }

    // The encoding is add the '#' marker to the end of each word and then join them in a string.
    // We can make the result minimum if there are two or more words that can be combined
    // We join words at the end of a longer word, as suffix
    // How do we find and eliminate the shorter words?
    // We can use nested loop, compare each word to other, using trie solution, 2000 x 2000 processes and a lot of memory
    // The key is 1 <= words[i].length <= 7
    // For each word, we search if they are substring(i) from current word.
    // If yes, remove it.
    // We can use Set data structure, it will minimize duplicate
    // Remaining string in Set are the word for encoding, plus the size of Set (represent the number of #)
}
