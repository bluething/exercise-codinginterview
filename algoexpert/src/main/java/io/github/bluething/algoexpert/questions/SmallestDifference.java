package io.github.bluething.algoexpert.questions;

import java.util.Arrays;

public class SmallestDifference {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallestDifference(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17})));
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int[] smallestPair = new int[2];
        int smallestDifference = Integer.MAX_VALUE;
        int currentDifference = 0;
        int i = 0;
        int j = 0;
        while (i < arrayOne.length && j < arrayTwo.length) {
            currentDifference = Math.abs(arrayOne[i] - arrayTwo[j]);
            if (smallestDifference > currentDifference) {
                smallestPair[0] = arrayOne[i];
                smallestPair[1] = arrayTwo[j];
                smallestDifference = currentDifference;
            }

            if (arrayOne[i] < arrayTwo[j]) {
                i++;
            } else {
                j++;
            }
        }

        return smallestPair;
    }

    // The idea is sort the array asc
    // In each loop calculate absolute difference, track the smallest
    // If current difference smaller than smallest, fill current to smallest, keep the value.
    // If Math.abs optimize? Or we can move it inside comparison between element to find absolute difference?
}
