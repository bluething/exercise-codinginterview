package io.github.bluething.algoexpert.questions.search;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33));
        System.out.println(binarySearchIteration(new int[]{0, 1, 21, 33, 45, 45, 61, 71, 72, 73}, 33));
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

    private static int binarySearchIteration(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        return helperIteration(array, low, high, target);
    }

    private static int helperIteration(int[] array, int low, int high, int target) {
        int mid = 0;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
