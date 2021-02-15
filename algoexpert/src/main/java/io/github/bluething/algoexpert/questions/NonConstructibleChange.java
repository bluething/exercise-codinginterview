package io.github.bluething.algoexpert.questions;

import java.util.Arrays;

public class NonConstructibleChange {

    public static void main(String[] args) {
        System.out.println(nonConstructibleChange(new int[]{5, 7, 1, 1, 2, 3, 22}));
        System.out.println(nonConstructibleChange(new int[]{5, 6, 1, 1, 2, 3, 43}));
    }

    public static int nonConstructibleChange(int[] coins) {
        int minImpossibleSum = 0;

        Arrays.sort(coins);
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > minImpossibleSum + 1) {
                break;
            }
            minImpossibleSum += coins[i];
        }

        return minImpossibleSum + 1;
    }
}
