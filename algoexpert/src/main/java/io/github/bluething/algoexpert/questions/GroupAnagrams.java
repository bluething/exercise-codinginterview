package io.github.bluething.algoexpert.questions;

import java.util.*;

public class GroupAnagrams {

    public static void main(String[] args) {
        System.out.println("case 01");
        groupAnagrams(Arrays.asList(new String[]{"yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"})).
                forEach(list -> list.
                        forEach(array -> System.out.println(array)));
        System.out.println("case 02");
        groupAnagrams(Arrays.asList(new String[]{})).
                forEach(list -> list.
                        forEach(array -> System.out.println(array)));
        System.out.println("case 03");
        groupAnagrams(Arrays.asList(new String[]{"test"})).
                forEach(list -> list.
                        forEach(array -> System.out.println(array)));
        System.out.println("case 04");
        groupAnagrams(Arrays.asList(new String[]{"abc", "cba", "bca"})).
                forEach(list -> list.
                        forEach(array -> System.out.println(array)));
    }

    private static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> anagrams = new HashMap<>();
        char[] sortedChar = null;
        String sortedWord = "";
        for (String word : words) {
            sortedChar = word.toCharArray();
            Arrays.sort(sortedChar);
            sortedWord = new String(sortedChar);

            if (anagrams.containsKey(sortedWord)) {
                anagrams.get(sortedWord).add(word);
            } else {
                anagrams.put(sortedWord, new ArrayList<String>(Arrays.asList(word)));
            }
        }

        return new ArrayList<>(anagrams.values());
    }
    // There are twi options if we want to check if two string is anagrams or not.
    // 1. Sort both string and check if they have same char in same position.
    // 2. Count the char. If they have same number of char means both string is an anagram.
    // For this problem I think we use option 1 with some modification.
    // We can use map to achieve grouping. The question is what the key?
    // We can use sorted word as a key. Because same sorted word means anagram.
    // Loop the words, in each loop we sort the word.
    // Check if map contain sorted word key.
    // If yes (it's the anagram), add the word to current value
    // If not (the new word), put to the map.

}
