package week02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// A pangram is a string that contains every letter of the alphabet.
// Given a sentence determine whether it is a pangram in the English alphabet. Ignore case. Return either pangram or not pangram as appropriate.
public class Pangram {

    @Test
    public void case01() {
        Assertions.assertEquals("not pangram", pangrams("We promptly judged antique ivory buckles for the prize"));
    }

    @Test
    public void case02() {
        Assertions.assertEquals("pangram", pangrams("We promptly judged antique ivory buckles for the next prize"));
    }

    @Test
    public void case03() {
        Assertions.assertEquals("not pangram", pangrams2("We promptly judged antique ivory buckles for the prize"));
    }

    @Test
    public void case04() {
        Assertions.assertEquals("pangram", pangrams2("We promptly judged antique ivory buckles for the next prize"));
    }

    private String pangrams(String s) {
        Map<Character, Integer> freqChar = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            freqChar.put((char)(97 + i), 0);
        }
        freqChar.put((char) (32), 0);

        String sLower = s.toLowerCase();
        for (int i = 0; i < sLower.length(); i++) {
            freqChar.put(sLower.charAt(i), freqChar.getOrDefault(sLower.charAt(i), 0) + 1);
        }
        String result = "pangram";
        for (Map.Entry<Character, Integer> entry : freqChar.entrySet()) {
            if (entry.getValue() == 0) {
                result = "not pangram";
                break;
            }
        }
        return result;
    }

    // No need to count the frequency
    // Just add all the chars in the string to set then check the size
    // If the size is 26 (size of alphabet) then the string is pangram
    private String pangrams2(String s) {
        String result = "not pangram";

        Set<Character> countUnique = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                countUnique.add(Character.toLowerCase(s.charAt(i)));
            }
        }

        if (countUnique.size() == 26) {
            result = "pangram";
        }

        return result;
    }
}
