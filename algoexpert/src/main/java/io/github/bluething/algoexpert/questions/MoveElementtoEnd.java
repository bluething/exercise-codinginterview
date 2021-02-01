package io.github.bluething.algoexpert.questions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MoveElementtoEnd {

    public static void main(String[] args) {
        moveElementToEnd(new LinkedList<>(Arrays.asList(new Integer[]{2, 1, 2, 2, 2, 3, 4, 2})), 2).forEach(array -> System.out.println(array));
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        Integer temp = Integer.valueOf(0);
        int left = 0;
        int right = array.size() - 1;
        while (left < right) {
            while (left < right && array.get(right).equals(Integer.valueOf(toMove))) {
                right--;
            }
            if (array.get(left).equals(Integer.valueOf(toMove))) {
                temp = array.get(right);
                array.set(right, array.get(left));
                array.set(left, temp);
            }
            left++;
        }

        return array;
    }

    // The idea is using two pointer, left and right
    // try to find value equals to toMove at the end of array, if found move right to left
    // if left most value equals to toMove, swap the value with right place
    // move left pointer to the left
}
