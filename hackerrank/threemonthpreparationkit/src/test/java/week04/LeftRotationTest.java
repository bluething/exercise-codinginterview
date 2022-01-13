package week04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left.
// Given an integer, d, rotate the array that many steps left and return the result.
public class LeftRotationTest {

    @Test
    public void case01() {
        Assertions.assertEquals(Arrays.asList(5, 1, 2, 3, 4), rotateLeft(4, Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(Arrays.asList(5, 1, 2, 3, 4), rotateLeft2(4, Arrays.asList(1, 2, 3, 4, 5)));
    }

    // Time limit exceed
    private List<Integer> rotateLeft(int d, List<Integer> arr) {
        int temp = 0;
        for (int i = 1; i <= d; i++) {
            int j = 0;
            temp = arr.get(j);
            while (j < arr.size() - 1) {
                arr.set(j, arr.get(j + 1));
                j++;
            }
            arr.set(j, temp);
        }

        return arr;
    }

    private List<Integer> rotateLeft2(int d, List<Integer> arr) {
        return arr;
    }
}
