package week01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// There is a collection of input strings and a collection of query strings.
// For each query string, determine how many times it occurs in the list of input strings.
// Return an array of the results.
// strings = ["aba", "baba", "aba", "xzxb"]
// queries = ["aba", "xzxb", "ab"]
// There are 2 instances of "ab", 1 of "xzxb" and 0 of "ab".
// For each query, add an element to the return array, results = [2, 1, 0]
public class SparseArrayTest {

    @Test
    public void case01() {
        Assertions.assertEquals(Arrays.asList(2, 1, 0),
                matchingStrings(Arrays.asList("aba", "baba", "aba", "xzxb"), Arrays.asList("aba", "xzxb", "ab")));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(Arrays.asList(1, 0, 1),
                matchingStrings(Arrays.asList("def", "de", "fgh"), Arrays.asList("de", "lmn", "fgh")));
    }

    @Test
    public void case03() {
        Assertions.assertEquals(Arrays.asList(1, 3, 4, 3, 2),
                matchingStrings(Arrays.asList("abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf", "na", "asdjf", "na", "basdn", "sdaklfj", "asdjf"),
                        Arrays.asList("abcde", "sdaklfj", "asdjf", "na", "basdn")));
    }

    @Test
    public void case04() {
        Assertions.assertEquals(Arrays.asList(2, 1, 0),
                matchingStrings2(Arrays.asList("aba", "baba", "aba", "xzxb"), Arrays.asList("aba", "xzxb", "ab")));
    }

    @Test
    public void case05() {
        Assertions.assertEquals(Arrays.asList(1, 0, 1),
                matchingStrings2(Arrays.asList("def", "de", "fgh"), Arrays.asList("de", "lmn", "fgh")));
    }

    @Test
    public void case06() {
        Assertions.assertEquals(Arrays.asList(1, 3, 4, 3, 2),
                matchingStrings2(Arrays.asList("abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf", "na", "asdjf", "na", "basdn", "sdaklfj", "asdjf"),
                        Arrays.asList("abcde", "sdaklfj", "asdjf", "na", "basdn")));
    }

    private List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        List<Integer> counters = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            int counter = 0;
            for (int j = 0; j < strings.size(); j++) {
                if (strings.get(j).equals(queries.get(i))) {
                    counter++;
                }
            }
            counters.add(counter);
        }

        return counters;
    }
    private List<Integer> matchingStrings2(List<String> strings, List<String> queries) {
        Map<String, Integer> stringFreq = new HashMap<>();
        for (int i = 0; i < strings.size(); i++) {
            stringFreq.put(strings.get(i), stringFreq.getOrDefault(strings.get(i), 0) + 1);
        }

        List<Integer> counters = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            counters.add(stringFreq.getOrDefault(queries.get(i), 0));
        }

        return counters;
    }

}
