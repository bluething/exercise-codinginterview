package io.github.bluething.algoexpert.questions;

public class CaesarCipherEncryptor {

    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("xyz", 2));
        System.out.println(caesarCypherEncryptor("kjwmntauvjjnmsagwgawkagfuaugjhawgnawgjhawjgawbfawghesh", 15));
    }

    public static String caesarCypherEncryptor(String str, int key) {
        int wrapKey = key % 26;
        StringBuilder encryptedString = new StringBuilder("");
        int desAscii = 0;
        for (int i = 0; i < str.length(); i++) {
            desAscii = (int) str.charAt(i) + wrapKey;
            if (desAscii > 122) {
                desAscii = 96 + (desAscii % 122);
            }
            encryptedString.append((char) desAscii);
        }

        return encryptedString.toString();
    }

    // key can be anything integer, we want to find the overlap value, modulo by 26 (num of letter + 1)
    // Find the new ascii value (added by wrapKey)
    // If the value > 122 (z in ascii dec), find the overlap. Module by 122 (+1 from z) the added by 96 (-1 from a)
}
