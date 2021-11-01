package io.github.bluething.algoexpert.questions.search;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33));
    }

    private static int binarySearch(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int mid = low + ((high - low) / 2);

        return helper(array, low, high, mid, target);
    }

    private static int helper(int[] array, int low, int high, int mid, int target) {
        if (low > high) {
            return -1;
        }

        mid = low + ((high - low) / 2);
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return helper(array, low, mid-1, mid, target);
        } else {
            return helper(array, mid+1, high, mid, target);
        }
    }
}
