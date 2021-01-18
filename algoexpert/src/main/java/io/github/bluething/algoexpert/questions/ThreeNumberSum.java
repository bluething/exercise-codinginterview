package io.github.bluething.algoexpert.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// The problem https://www.algoexpert.io/questions/Three%20Number%20Sum
public class ThreeNumberSum {

    public static void main(String[] args) {
        threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, -8, 6}, 0).forEach(array -> System.out.println(Arrays.toString(array)));
        System.out.println();
        threeNumberSum(new int[]{1, 2, 3}, 6).forEach(array -> System.out.println(Arrays.toString(array)));
        System.out.println();
        threeNumberSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 15}, 5).forEach(array -> System.out.println(Arrays.toString(array)));
        System.out.println();
        threeNumberSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 15}, 15).forEach(array -> System.out.println(Arrays.toString(array)));
        System.out.println();
        threeNumberSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 15}, 18).forEach(array -> System.out.println(Arrays.toString(array)));
        System.out.println();
        threeNumberSum(new int[]{12, 3, 1, 2, -6, 5, 0, -8, -1, 6}, 0).forEach(array -> System.out.println(Arrays.toString(array)));
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Arrays.sort(array);

        List<Integer[]> triplets = new ArrayList<>();

        int sum = 0;
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            k = array.length - 1;
            for (int j = i + 1; j < k;) {
                sum = array[i] + array[j] + array[k];

                if (sum == targetSum) {
                    triplets.add(new Integer[]{array[i], array[j], array[k]});
                }

                if (sum < targetSum) {
                    j++;
                } else if (sum > targetSum) {
                    k--;
                } else {
                    j++;
                    k--;
                }
            }
        }

        return triplets;
    }

    // The number in each triplet should be ordered in ascending order.
    // The triplets themselves should be ordered in ascending order with respect to the number they hold.

}
