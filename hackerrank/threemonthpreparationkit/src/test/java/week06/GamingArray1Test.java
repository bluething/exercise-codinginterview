package week06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// Andy wants to play a game with his little brother, Bob. The game starts with an array of distinct integers and the rules are as follows:
//
// Bob always plays first.
// In a single move, a player chooses the maximum element in the array. He removes it and all elements to its right.
// For example, if the starting array arr=[2, 3, 5, 4, 1], then it becomes arr'=[2, 3] after removing [3, 4, 1].
// The two players alternate turns.
// The last player who can make a move wins.
// Andy and Bob play  games. Given the initial array for each game, find and print the name of the winner on a new line.
// If Andy wins, print ANDY; if Bob wins, print BOB.
public class GamingArray1Test {

    @Test
    public void case01() {
        Assertions.assertEquals("BOB", gamingArray(Arrays.asList(2, 3, 5, 4, 1)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals("BOB", gamingArray2(Arrays.asList(2, 3, 5, 4, 1)));
    }

    // hit time limit exceed
    private String gamingArray(List<Integer> arr) {
        int end = arr.size();
        int max = Integer.MIN_VALUE;
        int maxIdx = end;
        int counter = 0;
        while (end > 0) {
            for (int i = 0; i < end; i++) {
                if (arr.get(i) > max) {
                    max = arr.get(i);
                    maxIdx = i;
                }
            }

            max = Integer.MIN_VALUE;
            counter++;
            end = maxIdx;
        }

        counter++;

        return counter % 2 == 0 ? "BOB" : "ANDY";
    }

    // The idea is to count how many times the array split
    // Just count how many we find max value from left to right
    private String gamingArray2(List<Integer> arr) {
        int max = Integer.MIN_VALUE;
        int counter = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
                counter++;
            }
        }

        return counter % 2 == 0 ? "ANDY" : "BOB";
    }
}
