package week04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
