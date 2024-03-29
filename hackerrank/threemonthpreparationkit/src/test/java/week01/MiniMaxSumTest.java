package week01;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers.
// Then print the respective minimum and maximum values as a single line of two space-separated long integers.
public class MiniMaxSumTest {
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
        miniMaxSum(Arrays.asList(1, 2, 3, 4, 5));
        Assertions.assertEquals("10 14", output.toString());
    }

    @Test
    public void case02() {
        miniMaxSum(Arrays.asList(7, 69, 2, 221, 8974));
        Assertions.assertEquals("299 9271", output.toString());
    }

    @Test
    public void case03() {
        miniMaxSum2(Arrays.asList(1, 2, 3, 4, 5));
        Assertions.assertEquals("10 14", output.toString());
    }

    @Test
    public void case04() {
        miniMaxSum2(Arrays.asList(7, 69, 2, 221, 8974));
        Assertions.assertEquals("299 9271", output.toString());
    }

    private void miniMaxSum(List<Integer> arr) {
        arr.sort(Comparator.naturalOrder());

        long min = 0L;
        long max = 0L;
        for (Integer val : arr) {
            max += val;
        }

        min = max - arr.get(arr.size() - 1);
        max = max - arr.get(0);

        System.out.print(min + " " + max);
    }

    private void miniMaxSum2(List<Integer> arr) {
        long min = Integer.MAX_VALUE;
        long max = Integer.MIN_VALUE;
        long sum = 0;
        for (Integer val : arr) {
            min = Math.min(min, val);
            max = Math.max(max, val);
            sum += val;
        }

        System.out.print((sum - max) + " " + (sum - min));
    }
}
