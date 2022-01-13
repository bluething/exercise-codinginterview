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

    // Use juggling algorithm
    // Divide the array in different sets, we have to move elements between sets
    // The size of set is gcd(d, size of the array)
    // See more https://stackoverflow.com/questions/23321216/rotating-an-array-using-juggling-algorithm
    //
    // For example array of size 6, rotate to left by 3
    // We have 2 sets with size 3 (gcd(3, 6))
    // For 1st iteration throw element 1 (i) in the set 1 and throw element 4 (i+d) in the set 2, swap them
    // Do this for 2nd (2 with 5) and 3rd (3 with 6) iteration
    private List<Integer> rotateLeft2(int d, List<Integer> arr) {
        int n = arr.size();
        d %= arr.size();
        int numOfJuggling = gcd(d, n);
        for (int i = 0; i < numOfJuggling; i++) {
            // start element
            int temp = arr.get(i);
            int j = i;
            int k = 0;
            while (true) {
                // position to swap
                k = j + d;
                // there might be cases we have to rotate the array more than n
                if (k >= n) {
                    k -= n;
                }
                if (k == i) {
                    break;
                }
                arr.set(j, arr.get(k));
                j = k;
            }
            arr.set(j, temp);
        }

        return arr;
    }
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }
}
