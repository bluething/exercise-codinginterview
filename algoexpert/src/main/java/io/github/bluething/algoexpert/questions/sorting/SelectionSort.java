package io.github.bluething.algoexpert.questions.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(selectionSort(new int[]{8, 5, 2, 9, 5, 6, 3}), new int[]{2, 3, 5, 5, 6, 8, 9}));
        System.out.println(Arrays.equals(selectionSort(new int[]{2, 1}), new int[]{1, 2}));
    }

    private static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }

        int startIdx = 0;
        int currentSmallestIdx = 0;
        int temp = 0;

        while (startIdx < array.length - 1) {
            currentSmallestIdx = startIdx;
            for (int i = startIdx + 1; i < array.length; i++) {
                if (array[currentSmallestIdx] > array[i]) {
                    currentSmallestIdx = i;
                }
            }

            temp = array[currentSmallestIdx];
            array[currentSmallestIdx] = array[startIdx];
            array[startIdx] = temp;

            startIdx++;
        }

        return array;
    }
}
