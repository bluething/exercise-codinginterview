package week06;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// We define a magic square to be an n x m matrix of distinct positive integers from 1 to n^2 where the sum of any row, column, or diagonal of length n is always equal to the same number: the magic constant.
//
//You will be given a 3x3 matrix  of integers in the inclusive range [1,9]. We can convert any digit  to any other digit  in the range [1,9] at cost of |a-b|. Given s, convert it into a magic square at minimal cost. Print this cost on a new line.
public class FormingAMagicSquareTest {

    @Test
    public void case01() {
        Assertions.assertEquals(1, formingMagicSquare(Arrays.asList(Arrays.asList(4, 9, 2),
        Arrays.asList(3, 5, 7),
        Arrays.asList(8, 1, 5)))
        );
    }

    // See more https://www.youtube.com/watch?v=zPnN046OM34
    // Just compare the known 3x3 magic square for each combination to flatten the input list
    private int formingMagicSquare(List<List<Integer>> s) {
        int numOfElement = s.size() * s.get(0).size();
        List<Integer> flattenS = new ArrayList<>();
        for (int i = 0; i < numOfElement; i++) {
            flattenS.add(s.get(i / s.get(0).size()).get(i % s.get(0).size()));
        }

        List<List<Integer>> known3x3MagicSquare = Arrays.asList(Arrays.asList(4,9,2,3,5,7,8,1,6),
                Arrays.asList(2,7,6,9,5,1,4,3,8),
                Arrays.asList(6,1,8,7,5,3,2,9,4),
                Arrays.asList(8,3,4,1,5,9,6,7,2),
                Arrays.asList(2,9,4,7,5,3,6,1,8),
                Arrays.asList(6,7,2,1,5,9,8,3,4),
                Arrays.asList(8,1,6,3,5,7,4,9,2),
                Arrays.asList(4,3,8,9,5,1,2,7,6));

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < known3x3MagicSquare.size(); i++) {
            int total = 0;
            for (int j = 0; j < known3x3MagicSquare.get(0).size(); j++) {
                if (flattenS.get(j) != known3x3MagicSquare.get(i).get(j)) {
                    total += Math.abs(flattenS.get(j) - known3x3MagicSquare.get(i).get(j));
                }
            }
            if (total < min) {
                min = total;
            }
        }

        return min;
    }
}
