package io.github.bluething.algoexpert.questions;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public static void main(String[] args) {
        System.out.println("case 01: " + firstNonRepeatingCharacter("abcdcaf"));
        System.out.println("case 02: " + firstNonRepeatingCharacter("a"));
        System.out.println("case 03: " + firstNonRepeatingCharacter("ab"));
        System.out.println("case 04: " + firstNonRepeatingCharacter(""));
        System.out.println("case 04: " + firstNonRepeatingCharacter("aabbccddeeff"));
    }

    private static int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> freqChar = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            freqChar.put(string.charAt(i), freqChar.getOrDefault(string.charAt(i), 0) + 1);
        }
        int charIdx = -1;
        for (int i = 0; i < string.length(); i++) {
            if (freqChar.get(string.charAt(i)) == Integer.valueOf(1)) {
                charIdx = i;
                break;
            }
        }

        return charIdx;
    }
    // Time complexity O(n)
    // Spca complexity O(1), because the hash table will hold only 26 characters
}
