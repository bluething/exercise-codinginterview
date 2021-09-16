package io.github.bluething.algoexpert.questions.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(insertionSort(new int[]{8, 5, 2, 9, 5, 6, 3}), new int[]{2, 3, 5, 5, 6, 8, 9}));
    }

    private static int[] insertionSort(int[] array) {
        int temp = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[i]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
    // space O(1)
    // time O(n^2)
    // The array is virtually split into a sorted and an unsorted part.
    // Values from the unsorted part are picked and placed at the correct position in the sorted part.
}
