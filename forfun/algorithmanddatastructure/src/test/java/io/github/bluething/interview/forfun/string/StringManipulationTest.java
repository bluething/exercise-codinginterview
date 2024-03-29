package io.github.bluething.interview.forfun.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

// From a string
// Rearrange the string so that it is contains unique element and sorted by ascending A to Z.
// Convert the string into array of integers, with A = 0, Z = 25
public class StringManipulationTest {
    @Test
    public void case01() {
        Assertions.assertArrayEquals(new int[]{0, 3, 4, 8, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
                convert("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet"));
    }

    @Test
    public void case02() {
        Assertions.assertArrayEquals(new char[]{'a', 'd', 'e', 'i', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u'},
                stringToUniqueSorted("Neque porro quisquam est qui dolorem ipsum quia dolor sit amet"));
    }

    @Test
    public void case03() {
        Assertions.assertArrayEquals(new int[]{0, 3, 4, 8, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
                uniqueSortedCharsToIntArray(new char[]{'a', 'd', 'e', 'i', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u'}));
    }

    private int[] convert(String input) {
        return uniqueSortedCharsToIntArray(stringToUniqueSorted(input));
    }

    private char[] stringToUniqueSorted(String input) {
        int[] freqChar = new int[26];
        for (int i = 0; i < freqChar.length; i++) {
            freqChar[i] = -1;
        }

        int charDecimal = 0;
        Set<Character> uniqueChar = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            char current = Character.toLowerCase(input.charAt(i));
            if (current != ' ') {
                charDecimal = current;
                freqChar[charDecimal - 97] = (char)(charDecimal - 97);
                uniqueChar.add((char) (charDecimal - 97));
            }
        }

        char[] uniqueSortedChar = new char[uniqueChar.size()];
        int i = 0;
        for (int j = 0; j < freqChar.length; j++) {
            if (freqChar[j] != -1) {
                uniqueSortedChar[i] = (char) (freqChar[j] + 97);
                i++;
            }
        }

        return uniqueSortedChar;
    }

    private int[] uniqueSortedCharsToIntArray(char[] input) {
        int[] charToInt = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            charToInt[i] = input[i] - 97;
        }

        return charToInt;
    }
}
