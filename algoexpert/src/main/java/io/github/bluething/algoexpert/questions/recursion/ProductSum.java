package io.github.bluething.algoexpert.questions.recursion;

import java.util.ArrayList;
import java.util.List;

public class ProductSum {

    public static void main(String[] args) {
        List<Object> array = new ArrayList<>();
        array.add(Integer.valueOf(5));
        array.add(Integer.valueOf(2));
        array.add(new Integer[]{7, -1});
        array.add(Integer.valueOf(3));
        array.add(new Object[]{Integer.valueOf(6), new Integer[]{13, 8}});
        array.add(Integer.valueOf(4));
        System.out.println("case 01 " + productSum(array));

        array = new ArrayList<>();
        array.add(Integer.valueOf(1));
        array.add(Integer.valueOf(2));
        array.add(new Integer[]{3});
        array.add(Integer.valueOf(4));
        array.add(Integer.valueOf(5));
        System.out.println("case 02 " + productSum(array));

        array = new ArrayList<>();
        array.add(new Integer[]{1, 2});
        array.add(Integer.valueOf(3));
        array.add(new Integer[]{4, 5});
        System.out.println("case 03 " + productSum(array));
    }

    private static int productSum(List<Object> array) {
        // Write your code here.
        return -1;
    }
}
