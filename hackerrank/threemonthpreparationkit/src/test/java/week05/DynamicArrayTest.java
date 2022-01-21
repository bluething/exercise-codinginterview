package week05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArrayTest {

    @Test
    public void case01() {
        List<List<Integer>> queries = Arrays.asList(Arrays.asList(1,0,5),
                Arrays.asList(1,1,7),
                Arrays.asList(1,0,3),
                Arrays.asList(2,1,0),
                Arrays.asList(2,1,1));
        List<Integer> expected = Arrays.asList(7, 3);

        Assertions.assertEquals(expected, dynamicArray(2, queries));
    }

    private List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        List<Integer> answers = new ArrayList<>();
        int lastAnswer = 0;
        int idx = 0;
        int queryType = 0;
        int x = 0;
        int y = 0;
        for (List<Integer> query : queries) {
            queryType = query.get(0);
            x = query.get(1);
            y = query.get(2);
            idx = (x ^ lastAnswer) % n;

            if (queryType == 1) {
                arr.get(idx).add(y);
            } else {
                lastAnswer = arr.get(idx).get(y % arr.get(idx).size());
                answers.add(lastAnswer);
            }
        }

        return answers;
    }
}
