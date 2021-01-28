package io.github.bluething.algoexpert.questions;

import java.util.Arrays;

// The problem https://www.algoexpert.io/questions/Two%20Number%20Sum
public class TwoNumberSum {

    public static void main(String[] args) {
        System.out.println("case 01 " + Arrays.toString(twoNumberSum(new int[]{3, 5, -4, 9, 11, 1, -1, 6}, 10)));
        System.out.println("case 02 " + Arrays.toString(twoNumberSum(new int[]{-21, 301, 12, 4, 65, 56, 210, 356, 9, -47}, 164)));
    }

    private static int[] twoNumberSum(int[] array, int targetSum) {
        int[] pairs = {};

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    pairs = new int[2];
                    pairs[0] = array[i];
                    pairs[1] = array[j];
                }
            }
        }

        return pairs;
    }

    // using 2 pointer, O(n*n)

}
