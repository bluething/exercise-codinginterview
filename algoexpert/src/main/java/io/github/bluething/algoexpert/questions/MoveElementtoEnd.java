package io.github.bluething.algoexpert.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MoveElementtoEnd {

    public static void main(String[] args) {
        moveElementToEnd(new LinkedList<>(Arrays.asList(new Integer[]{2, 1, 2, 2, 2, 3, 4, 1})), 2).forEach(array -> System.out.println(array));
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int left = 0;
        int right = array.size() - 1;
        while (left < right) {
            if (array.get(right).equals(Integer.valueOf(toMove))) {
                right--;
            } else if (array.get(left).equals(Integer.valueOf(toMove))){
                array.add(array.remove(left));
                right--;
            } else {
                left++;
            }
        }

        return array;
    }

    // The idea is using two pointer, left and right
    // If value at the end of list equals 2, move pointer to the left
    // If value at the beginning of list equals 2,
    // remove the value then add to the list (automatically add to the end of the list and the list will shift left)
    // move right pointer to the left (because the list will shift left)
    // If none condition above meet, move left pointer to the right.
    // This solution need to shift the array, depend on language if the array perform in place.
}
