package io.github.bluething.algoexpert.questions.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {

    public static void main(String[] args) {
        List<Object> array = new ArrayList<>();
        array.add(5);
        array.add(2);
        array.add(Arrays.asList(7, -1));
        array.add(3);
        array.add(Arrays.asList(6, Arrays.asList(-13, 8)));
        array.add(4);
        System.out.println("case 01 " + productSum(array));

        array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(Arrays.asList(3));
        array.add(4);
        array.add(5);
        System.out.println("case 02 " + productSum(array));

        array = new ArrayList<>();
        array.add(Arrays.asList(1, 2));
        array.add(3);
        array.add(Arrays.asList(4, 5));
        System.out.println("case 03 " + productSum(array));
    }

    private static int productSum(List<Object> array) {
        return productSumRec(array, 1);
    }

    private static int productSumRec(List<Object> array, int multiplier) {
        int sum = 0;
        for (Object obj : array) {
            if (obj instanceof List) {
                List<Object> values = (List<Object>) obj;
                sum += productSumRec(values, multiplier++);
            } else {
                sum += (int) obj;
            }
        }
        return sum * multiplier;
    }
}
