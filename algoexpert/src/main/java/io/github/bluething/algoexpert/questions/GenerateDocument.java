package io.github.bluething.algoexpert.questions;

import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

    public static void main(String[] args) {
        System.out.println("case 01: " + generateDocument("Bste!hetsi ogEAxpelrt x ", "AlgoExpert is the Best!"));
        System.out.println("case 02: " + generateDocument("a hsgalhsa sanbjksbdkjba kjx", ""));
        System.out.println("case 03: " + generateDocument(" ", "hello"));
        System.out.println("case 04: " + generateDocument("     ", "     "));
        System.out.println("case 05: " + generateDocument("A", "a"));
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
}
