package io.github.bluething.algoexpert.questions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// The problem https://www.algoexpert.io/questions/Two%20Number%20Sum
public class TwoNumberSum {

    public static void main(String[] args) {
        System.out.println("case 01 " + Arrays.toString(twoNumberSum(new int[]{3, 5, -4, 9, 11, 1, -1, 6}, 10)));
        System.out.println("case 02 " + Arrays.toString(twoNumberSum(new int[]{-21, 301, 12, 4, 65, 56, 210, 356, 9, -47}, 164)));
    }

    private static int[] twoNumberSum(int[] array, int targetSum) {
        int[] pairResult = {};

        Map<Integer, Integer> pairCandidate = new HashMap<>();
        int missingNumber = 0;
        for (int i = 0; i < array.length; i++) {
            missingNumber = targetSum - array[i];
            pairCandidate.put(Integer.valueOf(missingNumber), Integer.valueOf(array[i]));
        }

        for (int i = 0; i < array.length; i++) {
            missingNumber = targetSum - array[i];
            if (pairCandidate.get(Integer.valueOf(array[i])) == Integer.valueOf(missingNumber)) {
                pairResult = new int[2];
                pairResult[0] = array[i];
                pairResult[1] = missingNumber;
            }
        }

        return pairResult;
    }

    // using 2 pointer, O(n*n)
    // X + Y = targetSum, X -> current index value, save Y to hash map<Y, X>
    // next iteration find current index in hashmap

}
