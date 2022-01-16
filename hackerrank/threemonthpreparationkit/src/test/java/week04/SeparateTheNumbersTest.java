package week04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

// A numeric string, s, is beautiful if it can be split into a sequence of two or more positive integers, a[1], a[2],...,a[n], satisfying the following conditions:
//
// 1. a[i] - a[i-1] = 1 for any 1 <= i <= n (i.e., each element in the sequence is  more than the previous element).
// 2. No a[i]  contains a leading zero. For example, we can split s=10203 into the sequence {1, 02, 03}, but it is not beautiful because 02 and 03 have leading zeroes.
// 3. The contents of the sequence cannot be rearranged. For example, we can split s=312 into the sequence {3, 1, 2}, but it is not beautiful because it breaks our first constraint (i.e., 1-3 != 1).
public class SeparateTheNumbersTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream originalOutput = System.out;

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(output));
    }

    @BeforeEach
    public void tearDown() {
        System.setOut(originalOutput);
    }

    @Test
    public void case01() {
        separateNumbers("99100");
        Assertions.assertEquals("YES 99", output.toString());
    }

    @Test
    public void case02() {
        separateNumbers("101103");
        Assertions.assertEquals("NO", output.toString());
    }

    // The idea is checking from left to right
    // Start with 1 digit into s.length() / 2 (compare the half of the string)
    // For each loop, we check if consecutive string meet the criteria
    // For example 1st loop (1 digit). Calculate expected next string (+1)
    // The next consecutive substring will have the same length with expected value
    // If true, calculate new expected next string (+1) and compare to the next consecutive substring
    private void separateNumbers(String s) {
        boolean result = false;
        String left = "";
        int i = 1;
        while (!result && i <= s.length() / 2) {
            left = s.substring(0, i);
            result = isBeauty(left, s.substring(i++));
        }

        System.out.print(result ? "YES " + left : "NO");
    }
    private boolean isBeauty(String left, String right) {
        if (right.length() == 0) {
            return true;
        }

        String expectedRight = String.valueOf(Long.parseLong(left) + 1);
        if (right.length() < expectedRight.length()) {
            return false;
        }

        String candidate = right.substring(0, expectedRight.length());
        if (candidate.charAt(0) == '0') {
            return false;
        }

        if (!expectedRight.equals(candidate)) {
            return false;
        }

        return isBeauty(expectedRight, right.substring(expectedRight.length()));
    }
}
