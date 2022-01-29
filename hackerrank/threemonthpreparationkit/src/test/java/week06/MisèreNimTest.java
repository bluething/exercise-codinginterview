package week06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// Two people are playing game of Misère Nim. The basic rules for this game are as follows:
//
//The game starts with n piles of stones indexed from 0 to n-1. Each pile i (where 0 <= i <= n) has s stones.
//The players move in alternating turns. During each move, the current player must remove one or more stones from a single pile.
//The player who removes the last stone loses the game.
//
//Given the value of n and the number of stones in each pile, determine whether the person who wins the game is the first or second person to move.
// If the first player to move wins, print First on a new line; otherwise, print Second. Assume both players move optimally.
public class MisèreNimTest {

    @Test
    public void case01() {
        Assertions.assertEquals("First", misereNim(Arrays.asList(1, 1)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals("Second", misereNim(Arrays.asList(2, 1, 3)));
    }

    // https://en.wikipedia.org/wiki/Nim
    private String misereNim(List<Integer> s) {
        int sum = 0;
        for (Integer val : s) {
            sum += val;
        }

        String theWinner = "";
        boolean isAllTheValueOne = sum == s.size() ? true : false;
        if (isAllTheValueOne) {
            if (s.size() % 2 == 0) {
                theWinner = "First";
            } else {
                theWinner = "Second";
            }
        } else {
            int xorResult = 0;
            for (Integer val : s) {
                xorResult ^= val;
            }

            if (xorResult == 0) {
                theWinner = "Second";
            } else {
                theWinner = "First";
            }
        }

        return theWinner;
    }
}
