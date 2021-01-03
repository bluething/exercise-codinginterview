package io.github.bluething.algoexpert.questions;

import java.util.Arrays;
import java.util.List;

// The problem https://www.algoexpert.io/questions/Validate%20Subsequence
public class ValidateSubsequence {

    public static void main(String[] args) {
        System.out.println("case 1 " + isValidSubsequence(
                Arrays.asList(new Integer[]{5, 1, 22, 25, 6, -1, 8, 10}),
                Arrays.asList(new Integer[]{1, 6, -1, 10})));

        System.out.println("case 1 " + isValidSubsequence(
                Arrays.asList(new Integer[]{5, 1, 22, 25, 6, -1, 8, 10}),
                Arrays.asList(new Integer[]{5, 1, 22, 22, 25, 6, -1, 8, 10})));

        System.out.println("case 1 " + isValidSubsequence(
                Arrays.asList(new Integer[]{5, 1, 22, 25, 6, -1, 8, 10}),
                Arrays.asList(new Integer[]{5, 1, 22, 22, 6, -1, 8, 10})));

        System.out.println("case 1 " + isValidSubsequence(
                Arrays.asList(new Integer[]{5, 1, 22, 25, 6, -1, 8, 10}),
                Arrays.asList(new Integer[]{1, 6, -1, 10, 11, 11, 11, 11})));

        System.out.println("case 1 " + isValidSubsequence(
                Arrays.asList(new Integer[]{5, 1, 22, 25, 6, -1, 8, 10}),
                Arrays.asList(new Integer[]{5, 1, 22, 25, 6, -1, 8, 10, 10})));

    }

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        // Write your code here.
        boolean isValid = true;
        int idxSequence = 0;

        if (array.size() < sequence.size()) {

            isValid = false;

        } else {

            int arrayIdx = 0;
            int sequenceIdx = 0;

            while ((arrayIdx < array.size()) && (sequenceIdx < sequence.size())) {
                if (array.get(arrayIdx).equals(sequence.get(sequenceIdx))) {
                    sequenceIdx++;
                }
                arrayIdx++;
            }

            if (sequenceIdx != sequence.size()) {
                isValid = false;
            }

        }

        return isValid;
    }

}
