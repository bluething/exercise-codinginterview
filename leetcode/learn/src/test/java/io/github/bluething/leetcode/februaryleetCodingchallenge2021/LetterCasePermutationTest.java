package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCasePermutationTest {

    @Test
    public void successWhenInputIsRightCaseOne() {
        List<String> expectedPermutation = Arrays.asList(new String[]{"a1b2","a1B2","A1b2","A1B2"});
        Assert.assertEquals(expectedPermutation, letterCasePermutation("a1b2"));
    }

    private List<String> letterCasePermutation(String S) {
        List<String> permutation = new ArrayList<>();
        char[] stringSequence = new char[]{};
        int numOfPermutation = 1 << S.length();
        for (int i = 1; i <= numOfPermutation; i++) {
            stringSequence = S.toCharArray();
            for (int j = 0; j < S.length(); j++) {
                if (!Character.isDigit(stringSequence[j])) {
                    if (((i >> j) & 1) == 1) {
                        if (Character.isUpperCase(stringSequence[j])) {
                            stringSequence[j] = Character.toLowerCase(stringSequence[j]);
                        } else {
                            stringSequence[j] = Character.toUpperCase(stringSequence[j]);
                        }
                    }
                }
            }
            permutation.add(new String(stringSequence));
        }

        return permutation;
    }

    // Power set algorithm, number of permutation == 2^n
    // We find how much we need to get permutation string.
    // Loop through number of permutation
    // In each loop we change string to char array and loop
    // In each loop, we only care about char letter
    // Check if the index in the set
    // If true, change the case
    // It doesn't work if we only permute letter like this case
}
