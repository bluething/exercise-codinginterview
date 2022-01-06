package week03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

// There are two -element arrays of integers, A and B. Permute them into some A' and B' such that the relation A'[i]+B'[i] >= k holds for all i where 0 <= i <= n.
//
//There will be q queries consisting of A, B, and k. For each query, return YES if some permutation A', B' satisfying the relation exists. Otherwise, return NO.
public class PermutingTwoArraysTest {

    @Test
    public void case01() {
        Assertions.assertEquals("YES", twoArrays(10,
                new LinkedList<Integer>(Arrays.asList(2, 1, 3)),
                new LinkedList<Integer>(Arrays.asList(7, 8, 9))));
    }

    @Test
    public void case02() {
        Assertions.assertEquals("NO", twoArrays(5,
                new LinkedList<Integer>(Arrays.asList(1, 2, 2, 1)),
                new LinkedList<Integer>(Arrays.asList(3, 3, 3, 4))));
    }

    @Test
    public void case03() {
        Assertions.assertEquals("YES", twoArrays(5,
                new LinkedList<Integer>(Arrays.asList(24, 43, 3, 27, 18, 4, 28, 16, 14, 32, 8, 42, 29, 39, 36, 16, 38, 12, 9, 42, 28, 29, 17, 40, 31, 3, 18, 37, 33, 33, 12, 41, 1, 44, 43, 9, 20, 7)),
                new LinkedList<Integer>(Arrays.asList(49, 38, 6, 48, 11, 44, 38, 24, 9, 10, 31, 23, 25, 11, 2, 32, 11, 37, 30, 14, 30, 3, 20, 16, 30, 12, 33, 43, 31, 23, 16, 51, 43, 47, 0, 21, 9, 21))));
    }

    @Test
    public void case04() {
        Assertions.assertEquals("NO", twoArrays(31,
                new LinkedList<Integer>(Arrays.asList(25, 2)),
                new LinkedList<Integer>(Arrays.asList(21, 1))));
    }

    @Test
    public void case05() {
        Assertions.assertEquals("NO", twoArrays(36,
                new LinkedList<Integer>(Arrays.asList(23, 19, 30, 22, 2, 21, 1, 32, 13, 5, 31, 16, 28, 34, 14, 9, 1, 25, 1, 14, 5, 31, 22, 10, 26)),
                new LinkedList<Integer>(Arrays.asList(19, 29, 25, 8, 6, 10, 15, 1, 28, 11, 3, 1, 2, 21, 6, 18, 17, 4, 1, 35, 28, 27, 1, 15, 17))));
    }

    @Test
    public void case06() {
        Assertions.assertEquals("NO", twoArrays(26,
                new LinkedList<Integer>(Arrays.asList(13, 6, 6, 4, 3, 4, 12, 1, 4, 1, 24, 12, 5, 17, 12, 6, 13, 12, 17, 6, 5, 9, 15, 1, 24, 1, 17, 24, 8, 1, 12, 21, 6, 20, 8, 21, 23, 1, 2, 5, 13, 14, 2)),
                new LinkedList<Integer>(Arrays.asList(22, 19, 2, 2, 11, 18, 9, 22, 17, 12, 1, 14, 16, 17, 8, 6, 15, 1, 9, 8, 14, 19, 22, 2, 11, 7, 23, 4, 8, 13, 1, 4, 23, 11, 20, 1, 1, 20, 13, 9, 11, 3, 17))));
    }
    @Test
    public void case07() {
        Assertions.assertEquals("YES", twoArrays(32,
                new LinkedList<Integer>(Arrays.asList(26, 32, 12, 25, 14, 28, 24, 23, 12, 24, 23, 14, 21, 9, 27, 29, 27, 3, 10, 24, 31, 27, 16, 27, 6, 15, 22, 6, 20, 30, 6, 7, 7, 27, 21, 12, 12, 25, 11, 2, 4, 24, 7, 3, 3)),
                new LinkedList<Integer>(Arrays.asList(13, 34, 8, 27, 20, 33, 9, 22, 30, 37, 11, 11, 8, 26, 30, 9, 17, 12, 11, 16, 9, 13, 11, 12, 28, 28, 25, 30, 5, 31, 16, 31, 22, 10, 37, 18, 14, 6, 12, 36, 9, 26, 33, 23, 33))));
    }

    // 1st I think I can use nested loop
    // In each inner loop I check if A[i] + B[j] >= k, if yes I remove the element from B
    // Then I return "YES" if list B is empty. This is wrong because we can have one to many relation from A to B that satisfy >=k
    // The result is B won't be empty like it should be
    // The solution is we compare A and B in reverse order. A asc and B desc.
    // For same index we check if the sum < k. If true it means we can't permute them to satisfy the condition
    private String twoArrays(int k, List<Integer> A, List<Integer> B) {
        String isSatisfiedPermute = "YES";
        Collections.sort(A, Comparator.naturalOrder());
        Collections.sort(B, Comparator.reverseOrder());
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) + B.get(i) < k) {
                isSatisfiedPermute = "NO";
                break;
            }
        }

        return isSatisfiedPermute;
    }
}
