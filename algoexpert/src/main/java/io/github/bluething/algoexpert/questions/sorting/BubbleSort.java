package io.github.bluething.algoexpert.questions.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        System.out.println(Arrays.equals(bubbleSort(new int[]{8, 5, 2, 9, 5, 6, 3}), new int[]{2, 3, 5, 5, 6, 8, 9}));
        System.out.println(Arrays.equals(bubbleSort2(new int[]{8, 5, 2, 9, 5, 6, 3}), new int[]{2, 3, 5, 5, 6, 8, 9}));
    }

    private static int[] bubbleSort(int[] array) {
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

    private static int[] bubbleSort2(int[] array) {
        int temp = 0;
        boolean swapped = false;
        for (int i = 0; i < array.length; i++) {
            swapped = false;

            for (int j = i+1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }

            if (swapped == false) {
                break;
            }
        }
        return array;
    }

    // Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements if they are in wrong order.
    // For little optimization we can stop the loop if inner loop don't swap the value
}
