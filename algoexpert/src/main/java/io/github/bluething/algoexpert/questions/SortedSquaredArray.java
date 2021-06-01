package io.github.bluething.algoexpert.questions;

import java.util.Arrays;

public class SortedSquaredArray {

    public static void main(String[] args) {
        System.out.println("-- solution 1 --");
        System.out.println("case 01: " + Arrays.toString(sortedSquaredArray(new int[]{1, 2, 3, 5, 6, 8, 9})));
        System.out.println("case 02: " + Arrays.toString(sortedSquaredArray(new int[]{1, 2})));
        System.out.println("case 03: " + Arrays.toString(sortedSquaredArray(new int[]{-50, -13, -2, -1, 0, 0, 1, 1, 2, 3, 19, 20})));
        System.out.println();
        System.out.println("-- solution 1 --");
        System.out.println("case 01: " + Arrays.toString(sortedSquaredArraySolution2(new int[]{1, 2, 3, 5, 6, 8, 9})));
        System.out.println("case 02: " + Arrays.toString(sortedSquaredArraySolution2(new int[]{1, 2})));
        System.out.println("case 03: " + Arrays.toString(sortedSquaredArraySolution2(new int[]{-50, -13, -2, -1, 0, 0, 1, 1, 2, 3, 19, 20})));
    }

    private static int[] sortedSquaredArray(int[] array) {
        int[] sortedSquares = new int[array.length];
        int rightOutputIdx = array.length - 1;
        int rightInputIdx = array.length - 1;
        int leftInputIdx = 0;
        while (leftInputIdx < rightInputIdx){
            if (Math.abs(array[leftInputIdx]) < Math.abs(array[rightInputIdx])) {
                sortedSquares[rightOutputIdx] = array[rightInputIdx] * array[rightInputIdx];
                rightInputIdx--;
            } else {
                sortedSquares[rightOutputIdx] = array[leftInputIdx] * array[leftInputIdx];
                leftInputIdx++;
            }
            rightOutputIdx--;
        }

        sortedSquares[rightOutputIdx] = array[leftInputIdx] * array[leftInputIdx];

        return sortedSquares;
    }
    // input array is in descending order, output array is square from input array in descending order
    // the key is, input array can have negative value
    // when we square the negative value, the new value can have different position with the original
    // there are no correlation position between input and output
    // the idea is, fill the output from right (biggest value)
    // iterate the input with 2 pointers, compare array[i] with array[length - 1] (the biggest), we only care about the value, ignore the sign
    // square it the bigger one and put to the end of output array
    // I hit a problem, how to square the last element? So I put additional assignment

    private static int[] sortedSquaredArraySolution2(int[] array) {
        int[] sortedSquares = new int[array.length];
        int smallerValueIdx = 0;
        int largerValueIdx = array.length - 1;
        int smallerValue = 0;
        int largerValue = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            smallerValue = Math.abs(array[smallerValueIdx]);
            largerValue = Math.abs(array[largerValueIdx]);
            if (smallerValue > largerValue) {
                sortedSquares[i] = smallerValue * smallerValue;
                smallerValueIdx++;
            } else {
                sortedSquares[i] = largerValue * largerValue;
                largerValueIdx--;
            }
        }

        return sortedSquares;
    }
    // this solution more clean
    // using 2 pointers but iterate array in own pointer
    // no need to worry about processing last element
}
