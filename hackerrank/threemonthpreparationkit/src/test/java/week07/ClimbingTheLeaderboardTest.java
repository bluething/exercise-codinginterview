package week07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// An arcade game player wants to climb to the top of the leaderboard and track their ranking.
// The game uses Dense Ranking, so its leaderboard works like this:
// 1. The player with the highest score is ranked number 1 on the leaderboard.
// 2. Players who have equal scores receive the same ranking number, and the next player(s) receive the immediately following ranking number.
public class ClimbingTheLeaderboardTest {

    @Test
    public void case01() {
        Assertions.assertEquals(Arrays.asList(6, 4, 2, 1),
                climbingLeaderboard(Arrays.asList(100, 100, 50, 40, 40, 20, 10), Arrays.asList(5, 25, 50, 120)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(Arrays.asList(6, 5, 4, 2, 1),
                climbingLeaderboard(Arrays.asList(100, 90, 90, 80, 75, 60), Arrays.asList(50, 65, 77, 90, 102)));
    }

    private List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // We need a unique rank value for comparator
        List<Integer> uniqueRank = new ArrayList<>();
        uniqueRank.add(ranked.get(0));
        for (int i = 1; i < ranked.size(); i++) {
            if (ranked.get(i) < uniqueRank.get(uniqueRank.size() - 1)) {
                uniqueRank.add(ranked.get(i));
            }
        }

        List<Integer> playerRanked = new ArrayList<>();
        int start = 0;
        boolean isFound = false;
        // I think player list already in asc order
        for (int i = player.size() - 1; i >= 0; i--) {
            isFound = false;
            // Search in uniqueRank list
            // Find the 1st matching idx
            // Because uniqueRank in 0 base index, we +1 the result
            // Start the search from the last idx we meet and +1 (the next player(s) receive the immediately following ranking number) the index if the condition is match
            for (int j = start; j < uniqueRank.size(); j++) {
                if (player.get(i) >= uniqueRank.get(j)) {
                    playerRanked.add(j+1);
                    start = j;
                    isFound = true;
                    break;
                }
            }

            // The last rank
            if (!isFound) {
                playerRanked.add(uniqueRank.size()+1);
                start = uniqueRank.size();
            }
        }

        Collections.reverse(playerRanked);

        return playerRanked;
    }
}
