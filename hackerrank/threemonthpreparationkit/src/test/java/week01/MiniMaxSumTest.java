package week01;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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
}
