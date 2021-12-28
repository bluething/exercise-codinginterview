package week01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

//                                      Count
//    Game  Score  Minimum  Maximum   Min Max
//     0      12     12       12       0   0
//     1      24     12       24       0   1
//     2      10     10       24       1   1
//     3      24     10       24       1   1
// Given the scores for a season, determine the number of times Maria breaks her records for most and least points scored during the season.
public class BreakingtheRecordsTest {

    @Test
    public void case01() {
        Assertions.assertEquals(Arrays.asList(1, 1), breakingRecords(Arrays.asList(12, 24, 10, 24)));
    }

    private List<Integer> breakingRecords(List<Integer> scores) {
        int min = scores.get(0);
        int max = scores.get(0);
        int minBreakCount = 0;
        int maxBreakCount = 0;
        int currScore = 0;
        for (int i = 1; i < scores.size(); i++) {
            currScore = scores.get(i);
            if (currScore < min) {
                minBreakCount++;
                min = currScore;
            } else if (currScore > max) {
                maxBreakCount++;
                max = currScore;
            }
        }

        return Arrays.asList(maxBreakCount, minBreakCount);
    }
}
