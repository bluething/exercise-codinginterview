package week02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// A space explorer's ship crashed on Mars! They send a series of SOS messages to Earth for help.
// Letters in some SOS messages are altered by cosmic radiation during transmission.
// Given the signal received by Earth as a string, s, determine how many letters of the SOS message have been changed by radiation.
//
// 1 =< s >= 99
// s % 3 = 0
// s will contain only uppercase English letters, ascii[A-Z].
public class MarsExplorationTest {
    @Test
    public void case01() {
        Assertions.assertEquals(3, marsExploration("SOSSPSSQSSOR"));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(1, marsExploration("SOSSOT"));
    }

    // For each iteration, check the next 3 char (inclusive)
    // The key is how we increment the index
    private int marsExploration(String s) {
        int counter = 0;
        int i = -1;
        while (i < s.length()-1){
            if (s.charAt(++i) != 'S') {
                counter++;
            }
            if (s.charAt(++i) != 'O') {
                counter++;
            }
            if (s.charAt(++i) != 'S') {
                counter++;
            }
        }

        return counter;
    }
}
