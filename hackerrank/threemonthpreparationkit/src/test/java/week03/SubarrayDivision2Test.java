package week03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

// Two children, Lily and Ron, want to share a chocolate bar. Each of the squares has an integer on it.
//
//Lily decides to share a contiguous segment of the bar selected such that:
//
//The length of the segment matches Ron's birth month, and,
//The sum of the integers on the squares is equal to his birthday.
//Determine how many ways she can divide the chocolate.
public class SubarrayDivision2Test {

    @Test
    public void case01() {
        Assertions.assertEquals(2, birthday(Arrays.asList(2, 2, 1, 3, 2), 4, 2));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(1, birthday(Arrays.asList(4), 4, 1));
    }

    // For every window, check if the sum equal to d
    // The tricky part is how to decide the window
    private int birthday(List<Integer> s, int d, int m) {
        int numOfSegment = 0;
        int sum = 0;
        int i = 0;
        int j = 0;
        while (i + m <= s.size()) {
            j = 0;
            sum = 0;
            while (j < m) {
                sum += s.get(i + j);
                j++;
            }

            if (sum == d) {
                numOfSegment++;
            }

            i++;
        }

        return numOfSegment;
    }
}
