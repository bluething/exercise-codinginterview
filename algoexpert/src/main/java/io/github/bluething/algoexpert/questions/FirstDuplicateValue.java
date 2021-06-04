package io.github.bluething.algoexpert.questions;

public class FirstDuplicateValue {

    public static void main(String[] args) {
        System.out.println("case 01: " + firstDuplicateValue(new int[]{2, 1, 5, 2, 3, 3, 4}));
        System.out.println("case 02: " + firstDuplicateValue(new int[]{1, 1, 2, 3, 3, 2, 2}));
        System.out.println("case 03: " + firstDuplicateValue(new int[]{1}));
        System.out.println("case 04: " + firstDuplicateValue(new int[]{}));
    }

    private static int firstDuplicateValue(int[] array) {
        int firstDuplicate = -1;
        int visitedIdx = 0;
        for (int i = 0; i < array.length; i++) {
            visitedIdx = Math.abs(array[i]) - 1;
            if (array[visitedIdx] < 0) {
                firstDuplicate = Math.abs(array[i]);
                break;
            } else {
                array[visitedIdx] *= -1;
            }
        }

        return firstDuplicate;
    }
    // The key is value of the array is 1 to n inclusive
    // It means we can treat those value as an index (minus one)
    // Get the value minus one then go to the index
    // If the value positive (the first time we visit) change to negative
    // If the value negative (2nd time visit) it means there are duplicate
}
