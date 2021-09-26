package io.github.bluething.hackerrank.interviewpreparationkit.arrays;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// The problem https://www.hackerrank.com/challenges/dynamic-array/problem
public class DynamicArrayTest {

    @Test
    public void successWhenInputIsRight() {
        List<Integer> expecteds = new ArrayList<>();
        expecteds.add(7);
        expecteds.add(3);

        List<List<Integer>> queries = new ArrayList<>();
        List<Integer> query = new ArrayList<>();
        query.add(1);
        query.add(0);
        query.add(5);
        queries.add(query);
        query = new ArrayList<>();
        query.add(1);
        query.add(1);
        query.add(7);
        queries.add(query);
        query = new ArrayList<>();
        query.add(1);
        query.add(0);
        query.add(3);
        queries.add(query);
        query = new ArrayList<>();
        query.add(2);
        query.add(1);
        query.add(0);
        queries.add(query);
        query = new ArrayList<>();
        query.add(2);
        query.add(1);
        query.add(1);
        queries.add(query);

        Assert.assertEquals(expecteds, dynamicArray(2, queries));
    }

    private List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<List<Integer>> twoDArray = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            twoDArray.add(new ArrayList<>());
        }

        List<Integer> lastAnswers = new ArrayList<>();
        int lastAnswer = 0;
        int idx = 0;
        int idy = 0;
        List<Integer> currList = new ArrayList<>();

        for (List<Integer> query: queries) {
            idx = (query.get(1) ^ lastAnswer) % n;
            currList = twoDArray.get(idx);

            if (query.get(0).equals(Integer.valueOf(1))) {
                currList.add(query.get(2));
                twoDArray.set(idx, currList);
            } else if (query.get(0).equals(Integer.valueOf(2))) {
                idy = query.get(2) % currList.size();
                lastAnswer = currList.get(idy);
                lastAnswers.add(lastAnswer);
            }
        }

        return lastAnswers;
    }
}
