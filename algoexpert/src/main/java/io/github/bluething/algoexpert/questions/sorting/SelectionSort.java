package io.github.bluething.algoexpert.questions.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(selectionSort(new int[]{8, 5, 2, 9, 5, 6, 3}), new int[]{2, 3, 5, 5, 6, 8, 9}));
    }

    private static int[] selectionSort(int[] array) {
        if (array.length == 0) {
            return new int[]{};
        }

        int temp = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        return array;
    }
}
