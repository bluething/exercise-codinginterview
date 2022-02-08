package week07;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// Goodland is a country with a number of evenly spaced cities along a line.
// The distance between adjacent cities is 1 unit. There is an energy infrastructure project planning meeting, and the government needs to know the fewest number of power plants needed to provide electricity to the entire list of cities.
// Determine that number. If it cannot be done, return -1.
//
//You are given a list of city data. Cities that may contain a power plant have been labeled 1. Others not suitable for building a plant are labeled 0.
// Given a distribution range of k, find the lowest number of plants that must be built such that all cities are served. The distribution range limits supply to cities where distance is less than k.
public class GoodlandElectricityTest {

    @Test
    public void case01() {
        Assertions.assertEquals(2, pylons(2, Arrays.asList(0, 1, 1, 1, 1, 0)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(3, pylons(3, Arrays.asList(0, 1, 0, 0, 0, 1, 1, 1, 1, 1)));
    }

    @Test
    public void case03() {
        Assertions.assertEquals(-1, pylons(2, Arrays.asList(0, 1, 0, 0, 0, 1, 0)));
    }

    private int pylons(int k, List<Integer> arr) {
        boolean noLuck = true;
        int currIdx = 0;
        // 1st poly in range k-1
        for (int i = k-1; i > -1; i--) {
            if (arr.get(i) == 1) {
                noLuck = false;
                currIdx = i;
                break;
            }
        }

        if (noLuck) {
            return -1;
        }

        int polyCount = 1;
        while (currIdx < arr.size() - k) {
            // expected next poly
            currIdx = currIdx + 2 * (k-1) + 1;
            noLuck = true;
            // from expected next poly, go back to find the nearest poly in the range k-1
            for (int j = 0; j < 2 * (k-1) + 1; j++) {
                if (arr.get(Math.min(currIdx-j, arr.size() - 1)) == 1) {
                    polyCount++;
                    currIdx -= j;
                    noLuck = false;
                    break;
                }
            }
            if (noLuck) {
                return -1;
            }
        }

        return polyCount;
    }
}