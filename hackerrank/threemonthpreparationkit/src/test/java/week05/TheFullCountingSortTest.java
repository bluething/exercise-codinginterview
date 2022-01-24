package week05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Use the counting sort to order a list of strings associated with integers.
// If two strings are associated with the same integer, they must be printed in their original order, i.e. your sorting algorithm should be stable.
// There is one other twist: strings in the first half of the array are to be replaced with the character - (dash, ascii 45 decimal).
//
// n, number of integer-string pair, is even, the value range is 1 <= n <= 1000000
// s, the string length is 1 <= s <= 10
// x, the integer value range is 0 <= x <= 100

public class TheFullCountingSortTest {
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
        List<List<String >> arr = Arrays.asList(Arrays.asList("0", "ab"),
                Arrays.asList("6", "cd"),
                Arrays.asList("0", "ef"),
                Arrays.asList("6", "gh"),
                Arrays.asList("4", "ij"),
                Arrays.asList("0", "ab"),
                Arrays.asList("6", "cd"),
                Arrays.asList("0", "ef"),
                Arrays.asList("6", "gh"),
                Arrays.asList("0", "ij"),
                Arrays.asList("4", "that"),
                Arrays.asList("3", "be"),
                Arrays.asList("0", "to"),
                Arrays.asList("1", "be"),
                Arrays.asList("5", "question"),
                Arrays.asList("1", "or"),
                Arrays.asList("2", "not"),
                Arrays.asList("4", "is"),
                Arrays.asList("2", "to"),
                Arrays.asList("4", "the"));
        countSort(arr);
        Assertions.assertEquals("- - - - - to be or not to be - that is the question - - - -", output.toString());
    }

    @Test
    public void case02() {
        List<List<String >> arr = Arrays.asList(Arrays.asList("0", "ab"),
                Arrays.asList("6", "cd"),
                Arrays.asList("0", "ef"),
                Arrays.asList("6", "gh"),
                Arrays.asList("4", "ij"),
                Arrays.asList("0", "ab"),
                Arrays.asList("6", "cd"),
                Arrays.asList("0", "ef"),
                Arrays.asList("6", "gh"),
                Arrays.asList("0", "ij"),
                Arrays.asList("4", "that"),
                Arrays.asList("3", "be"),
                Arrays.asList("0", "to"),
                Arrays.asList("1", "be"),
                Arrays.asList("5", "question"),
                Arrays.asList("1", "or"),
                Arrays.asList("2", "not"),
                Arrays.asList("4", "is"),
                Arrays.asList("2", "to"),
                Arrays.asList("4", "the"));
        countSort2(arr);
        Assertions.assertEquals("- - - - - to be or not to be - that is the question - - - -", output.toString());
    }

    // Time limit exceeded
    private void countSort(List<List<String>> arr) {
        List<List<String>> sortedArr = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            sortedArr.add(new ArrayList<>());
        }
        for (int i = 0; i < arr.size() / 2; i++) {
            sortedArr.get(Integer.valueOf(arr.get(i).get(0))).add("-");
        }

        for (int i = (arr.size() / 2); i < arr.size(); i++) {
            sortedArr.get(Integer.valueOf(arr.get(i).get(0))).add(arr.get(i).get(1));
        }

        StringBuilder sb = new StringBuilder("");
        for (List<String> strings : sortedArr) {
            for (String value : strings) {
                sb.append(value).append(" ");
            }
        }

        System.out.print(sb.toString().trim());

    }

    // Time limit exceeded
    private void countSort2(List<List<String>> arr) {
        List<StringBuilder> sortedArr = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            sortedArr.add(new StringBuilder(""));
        }
        for (int i = 0; i < arr.size() / 2; i++) {
            sortedArr.get(Integer.valueOf(arr.get(i).get(0))).append("- ");
        }

        for (int i = (arr.size() / 2); i < arr.size(); i++) {
            sortedArr.get(Integer.valueOf(arr.get(i).get(0))).append(arr.get(i).get(1)).append(" ");
        }

        StringBuilder sb = new StringBuilder("");
        for (StringBuilder stringBuilder : sortedArr) {
            sb.append(stringBuilder);
        }

        System.out.print(sb.toString().trim());
    }
}
