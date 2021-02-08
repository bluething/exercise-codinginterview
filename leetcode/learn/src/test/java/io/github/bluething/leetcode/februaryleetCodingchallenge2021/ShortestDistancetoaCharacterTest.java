package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class ShortestDistancetoaCharacterTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertArrayEquals(new int[]{3,2,1,0,1,0,0,1,2,2,1,0}, shortestToChar("loveleetcode", 'e'));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertArrayEquals(new int[]{3,2,1,0}, shortestToChar("aaab", 'b'));
    }

    private int[] shortestToChar(String s, char c) {
        int[] distances = new int[s.length()];
        int pos = Integer.MIN_VALUE / 2;

        // from left to right
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            distances[i] = i - pos;
        }

        pos = Integer.MAX_VALUE / 2;

        // from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                pos = i;
            }
            distances[i] = Math.min(distances[i], pos - i);
        }

        return distances;
    }

    // The idea is we move from left to right then right to left
    // From left to right we calculate distance i from pos (i <= pos)
    // Pos is the position of c, 1st we assume this position is big enough negative
    // Why big enough negative? Because we calculate distance with i - pos, and this value must positive
    // If we dont find c in the first n loop, the pos should have enough negative value
    // When we meet 1st c, pos value will fill with the index
    // From right to left we calculate distance pos from i (i >= pos)
    // The difference is, when we assign the difference to distance[i], we need to make sure the value entered has the smallest value

}
