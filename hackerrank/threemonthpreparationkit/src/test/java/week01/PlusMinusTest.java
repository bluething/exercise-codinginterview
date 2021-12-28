package week01;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

// Given an array of integers, calculate the ratios of its elements that are positive, negative, and zero.
// Print the decimal value of each fraction on a new line with  places after the decimal.
//
// Note: This challenge introduces precision problems.
// The test cases are scaled to six decimal places, though answers with absolute error of up to  are acceptable.
public class PlusMinusTest {

    private static final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private static final PrintStream originalOutput = System.out;

    @BeforeAll
    public static void setup() {
        System.setOut(new PrintStream(output));
    }

    @AfterAll
    public static void tearDown() {
        System.setOut(originalOutput);
    }

    @Test
    public void case01() {
        plusMinus(Arrays.asList(-4, 3, -9, 0, 4, 1));
        Assertions.assertEquals("0.500000\n0.333333\n0.166667", output.toString());
    }

    private void plusMinus(List<Integer> arr) {
        float positiveCount = 0f;
        float negativeCount = 0f;
        float zeroCount = 0f;
        for (Integer val : arr) {
            if (val > 0) {
                positiveCount++;
            } else if (val < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        positiveCount = positiveCount / arr.size();
        negativeCount = negativeCount / arr.size();
        zeroCount = zeroCount / arr.size();

        System.out.println(String.format("%6f", positiveCount));
        System.out.println(String.format("%6f", negativeCount));
        System.out.print(String.format("%6f", zeroCount));
    }
}
