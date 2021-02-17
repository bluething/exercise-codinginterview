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
        char[] stringSequence = S.toCharArray();
        permute(permutation, stringSequence, 0);

        return permutation;
    }

    private void permute(List<String> permutation, char[] stringSequence, int index) {
        if (index == stringSequence.length) {
            permutation.add(new String(stringSequence));
            return;
        }

        if (Character.isDigit(stringSequence[index])) {
            permute(permutation, stringSequence, index + 1);
            return;
        } else {
            stringSequence[index] = Character.toLowerCase(stringSequence[index]);
            permute(permutation, stringSequence, index + 1);

            stringSequence[index] = Character.toUpperCase(stringSequence[index]);
            permute(permutation, stringSequence, index + 1);
        }
    }

    // Using recursive
}
