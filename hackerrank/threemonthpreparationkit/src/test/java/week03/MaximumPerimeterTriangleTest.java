package week03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Given an array of stick lengths, use 3 of them to construct a non-degenerate triangle with the maximum possible perimeter.
// Return an array of the lengths of its sides as 3 integers in non-decreasing order.
//
// If there are several valid triangles having the maximum perimeter:
//
// Choose the one with the longest maximum side.
// If more than one has that maximum, choose from them the one with the longest minimum side.
// If more than one has that maximum as well, print any one them.
// If no non-degenerate triangle exists, return -1.
//
// Constraint
// 3 <= n <= 50
// 1 <= sticks[i] <= 10^9
//
// Non-degenerate triangle constraint
// a + b > c
// a + c > b
// b + c > a
public class MaximumPerimeterTriangleTest {

    @Test
    public void case01() {
        Assertions.assertEquals(Arrays.asList(3, 4, 5), maximumPerimeterTriangle(Arrays.asList(1, 2, 3, 4, 5, 10)));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(Arrays.asList(-1), maximumPerimeterTriangle(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void case03() {
        Assertions.assertEquals(Arrays.asList(1000000000, 1000000000, 1000000000), maximumPerimeterTriangle(Arrays.asList(
                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000, 1000000000
        )));
    }

    @Test
    public void case04() {
        Assertions.assertEquals(Arrays.asList(3, 4, 5), maximumPerimeterTriangle2(Arrays.asList(1, 2, 3, 4, 5, 10)));
    }

    @Test
    public void case05() {
        Assertions.assertEquals(Arrays.asList(-1), maximumPerimeterTriangle2(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void case06() {
        Assertions.assertEquals(Arrays.asList(1000000000, 1000000000, 1000000000), maximumPerimeterTriangle2(Arrays.asList(
                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000,
                1000000000, 1000000000, 1000000000, 1000000000, 1000000000
        )));
    }

    private List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        List<Integer> points = Arrays.asList(-1);
        sticks.sort(Comparator.naturalOrder());
        long longestPerimeter = -1L;
        long perimeter = 0L;
        for (int i = 0; i < sticks.size() - 2; i++) {
            if (sticks.get(i) + sticks.get(i+1) > sticks.get(i+2)) {
                perimeter = (long) sticks.get(i) + (long) sticks.get(i+1) + (long) sticks.get(i+2);
                if (perimeter > longestPerimeter) {
                    longestPerimeter = perimeter;
                    points = Arrays.asList(sticks.get(i), sticks.get(i+1), sticks.get(i+2));
                }
            }
        }

        return points;
    }

    private List<Integer> maximumPerimeterTriangle2(List<Integer> sticks) {
        List<Integer> points = Arrays.asList(-1);
        sticks.sort(Comparator.reverseOrder());
        for (int i = 0; i < sticks.size() - 2; i++) {
            if (sticks.get(i) < sticks.get(i + 1) + sticks.get(i + 2)) {
                points = Arrays.asList(sticks.get(i+2), sticks.get(i+1), sticks.get(i));
                break;
            }
        }

        return points;
    }
}
