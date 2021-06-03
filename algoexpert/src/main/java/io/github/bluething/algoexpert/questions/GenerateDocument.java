package io.github.bluething.algoexpert.questions;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public static void main(String[] args) {
        System.out.println("-- solution 1 --");
        System.out.println("case 01: " + generateDocument("Bste!hetsi ogEAxpelrt x ", "AlgoExpert is the Best!"));
        System.out.println("case 02: " + generateDocument("a hsgalhsa sanbjksbdkjba kjx", ""));
        System.out.println("case 03: " + generateDocument(" ", "hello"));
        System.out.println("case 04: " + generateDocument("     ", "     "));
        System.out.println("case 05: " + generateDocument("A", "a"));
        System.out.println("-- solution 2 --");
        System.out.println("case 01: " + generateDocumentSolution2("Bste!hetsi ogEAxpelrt x ", "AlgoExpert is the Best!"));
        System.out.println("case 02: " + generateDocumentSolution2("a hsgalhsa sanbjksbdkjba kjx", ""));
        System.out.println("case 03: " + generateDocumentSolution2(" ", "hello"));
        System.out.println("case 04: " + generateDocumentSolution2("     ", "     "));
        System.out.println("case 05: " + generateDocumentSolution2("A", "a"));
    }

    private static boolean generateDocument(String characters, String document) {
        boolean canGenerate = true;
        Map<Character, Integer> charFreq = new HashMap<>();
        for (int i = 0; i < characters.length(); i++) {
            charFreq.put(characters.charAt(i), charFreq.getOrDefault(characters.charAt(i), 0) + 1);
        }

        int freq = 0;
        for (int i = 0; i < document.length(); i++) {
            freq = charFreq.getOrDefault(document.charAt(i), 0);
            if (freq <= 0) {
                canGenerate = false;
                break;
            } else {
                charFreq.put(document.charAt(i), freq - 1);
            }
        }

        return canGenerate;
    }
    // The idea is using map to save characters frequency
    // Iterate document, on each char get current frequency then subtract by 1
    // If the frequency <= 0 return false
    // Optimal because we need O(c) space complexity c is number of unique char in characters. Character have a limited number, so c is not big enough to give an impact
    // Time complexity is O(m + n)

    private static boolean generateDocumentSolution2(String characters, String document) {
        boolean canGenerate = true;
        char currentChar = (char) 0;
        int charactersFreq = 0;
        int documentFreq = 0;
        for (int i = 0; i < document.length(); i++) {
            currentChar = document.charAt(i);
            charactersFreq = charFreqInString(currentChar, characters);
            documentFreq = charFreqInString(currentChar, document);
            if (documentFreq > charactersFreq) {
                canGenerate = false;
                break;
            }
        }

        return canGenerate;
    }
    private static int charFreqInString(char c, String s) {
        int freq = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                freq++;
            }
        }

        return freq;
    }
    // The idea is iterate through document, get the char
    // For each char find the frequency in characters and document
    // If frequency in document greater than frequency in characters return false
    // I though it more optimize that the 1st solution because this solution need O(1) space
    // But I'm wrong, the time complexity is O(m * (n + m)). We have implicit nested loop.
}
