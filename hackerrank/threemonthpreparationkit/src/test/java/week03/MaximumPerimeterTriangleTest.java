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

    // The important thing is understood what is non-degenerate triangle
    // After that we only need to check every triplet that satisfy the constraint
    // To make the solution simpler, sort the list, and check triplet from 3 consecutive elements
    // Why?
    // If arr[i] < arr[i+1] < arr[i+2] (sorted) can’t form a non-degenerate triangle then
    // arr[i-1], arr[i+1] and arr[i+2] or arr[i], arr[i+1] and arr[i+3] can’t form a non-degenerate triangle because
    // arr[i-1] + arr[i+1] will be even less than arr[i] + arr[i+1] for case arr[i-1], arr[i+1] and arr[i+2]
    // arr[i] + arr[i+1] must be less than arr[i+3] for case arr[i], arr[i+1] and arr[i+3]
    //
    // The problem is constraint of stick value, we can't use int type when add the value
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

    // This solution eliminate the need of cast to long
    // Because we only care of the longest perimeter we sort the sticks desc
    // If we found the triplet that construct non-degenerate triangle then that is the answer
    // Don't forget to put the answer in right order
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
