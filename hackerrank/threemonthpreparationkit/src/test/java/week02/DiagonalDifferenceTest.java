package week02;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class DiagonalDifferenceTest {

    @Test
    public void case01() {
        List<List<Integer>> arr = Arrays.asList(Arrays.asList(11, 2, 4),
                Arrays.asList(4, 5, 6),
                Arrays.asList(10, 8, -12));

        Assertions.assertEquals(15, diagonalDifference(arr));
    }

    @Test
    public void case02() {
        List<List<Integer>> arr = Arrays.asList(Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(9, 8, 9));

        Assertions.assertEquals(2, diagonalDifference(arr));
    }

    private int diagonalDifference(List<List<Integer>> arr) {
        int width = arr.get(0).size() - 1;
        int height = arr.size();
        int iLeft = 0;
        int sumLeft = 0;
        int sumRight = 0;
        int iRight = width;
        int j = 0;
        while (iLeft <= width && iRight >= 0 && j <= height) {
            sumLeft += arr.get(j).get(iLeft);
            sumRight += arr.get(j).get(iRight);
            iLeft++;
            iRight--;
            j++;
        }

        return Math.abs(sumLeft - sumRight);
    }
}
