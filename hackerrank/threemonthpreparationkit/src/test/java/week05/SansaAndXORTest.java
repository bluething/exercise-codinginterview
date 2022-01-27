package week05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// Sansa has an array. She wants to find the value obtained by XOR-ing the contiguous subarrays, followed by XOR-ing the values thus obtained.
// Determine this value.
// Subarray	Operation	Result
//  3		None		3
//  4		None		4
//  5		None		5
//  3,4		3 ^ 4		7
//  4,5		4 ^ 5		1
//  3,4,5	3 ^ 4 ^ 5	2
// Expected answer 3 ^ 4 ^ 5 ^ 7 ^ 1 ^ 2 = 7
//
// The key
// XOR of two identical numbers is 0
// XOR is not ordering-sensible, so we can omit parentheses
// If a value appears even number of times, the result of XOR will be zero
// If the number of occurrences is odd, the result of XOR is, well, the value

public class SansaAndXORTest {

    @Test
    public void case01() {
        Assertions.assertEquals(6, sansaXor(Arrays.asList(3, 4, 5)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(6, sansaXor2(Arrays.asList(3, 4, 5)));
    }

    // Time limit exceeded
    private int sansaXor(List<Integer> arr) {
        int result = 0;
        for (int i = 0; i < arr.size(); i++) {
            for (int j = i; j < arr.size(); j++) {
                for (int k = i; k <= j; k++) {
                    result ^= arr.get(k);
                }
            }
        }

        return result;
    }

    // 1. If the size of the list is even the xor result will 0
    // 2. If the size of the list is odd the net result will be taking (size+1)/2 elements at a time.
    private int sansaXor2(List<Integer> arr) {
        int result = 0;
        if (arr.size() % 2 != 0) {
            for (int i = 0; i < arr.size(); i += 2) {
                result ^= arr.get(i);
            }
        }

        return result;
    }
}
