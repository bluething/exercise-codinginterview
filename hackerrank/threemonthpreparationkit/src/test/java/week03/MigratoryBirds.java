package week03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// Given an array of bird sightings where every element represents a bird type id, determine the id of the most frequently sighted type.
// If more than 1 type has been spotted that maximum amount, return the smallest of their ids.
// 5 <= n <= 2 x 10^5
// It is guaranteed that each type is 1, 2, 3, 4, or 5.
public class MigratoryBirds {

    @Test
    public void case01() {
        Assertions.assertEquals(1, migratoryBirds(Arrays.asList(1, 1, 2, 2, 3)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(3, migratoryBirds(Arrays.asList(1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4)));
    }

    private int migratoryBirds(List<Integer> arr) {
        int[] birdSightFreq = new int[5];
        for (int i = 0; i < arr.size(); i++) {
            birdSightFreq[arr.get(i) - 1]++;
        }

        int birdId = 0;
        int maxSightFreq = birdSightFreq[0];
        for (int i = 1; i < birdSightFreq.length; i++) {
            if (birdSightFreq[i] > maxSightFreq) {
                maxSightFreq = birdSightFreq[i];
                birdId = i;
            }
        }

        return birdId + 1;
    }
}
