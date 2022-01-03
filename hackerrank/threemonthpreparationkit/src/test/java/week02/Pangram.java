package week02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
}
