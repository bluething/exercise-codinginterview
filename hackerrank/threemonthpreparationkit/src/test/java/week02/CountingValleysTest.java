package week02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// An avid hiker keeps meticulous records of their hikes. During the last hike that took exactly [steps] steps, for every step it was noted if it was an uphill, U, or a downhill, D step.
// Hikes always start and end at sea level, and each step up or down represents a  unit change in altitude. We define the following terms:
//
//A mountain is a sequence of consecutive steps above sea level, starting with a step-up from sea level and ending with a step-down to sea level.
//A valley is a sequence of consecutive steps below sea level, starting with a step-down from sea level and ending with a step-up to sea level.
//Given the sequence of up and down steps during a hike, find and print the number of valleys walked through.
public class CountingValleysTest {

    @Test
    public void case01() {
        Assertions.assertEquals(1, countingValleys(8, "UDDDUDUU"));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(1, countingValleys2(8, "UDDDUDUU"));
    }

    // The key is we must know when we enter the valley (seaLevel below 0) and when we up to the surface
    private int countingValleys(int steps, String path) {
        int numOfValleys = 0;
        int seaLevel = 0;
        boolean enterTheValley = false;
        char[] pathChr = path.toCharArray();
        for (int i = 0; i < pathChr.length; i++) {
            if (pathChr[i] == 'U') {
                seaLevel++;
            } else {
                seaLevel--;
            }

            if (enterTheValley && seaLevel == 0) {
                numOfValleys++;
            }

            if (seaLevel < 0) {
                enterTheValley = true;
            } else {
                enterTheValley = false;
            }
        }

        return numOfValleys;
    }

    // Another approach to detect if we finished climb up the valley
    private int countingValleys2(int steps, String path) {
        int numOfValleys = 0;
        int seaLevel = 0;
        char[] pathChr = path.toCharArray();
        for (int i = 0; i < pathChr.length; i++) {
            if (pathChr[i] == 'U') {
                seaLevel++;
            } else {
                seaLevel--;
            }

            if (seaLevel == 0 && pathChr[i] == 'U') {
                numOfValleys++;
            }
        }

        return numOfValleys;
    }
}
