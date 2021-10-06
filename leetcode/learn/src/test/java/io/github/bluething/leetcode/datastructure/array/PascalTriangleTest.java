package io.github.bluething.leetcode.datastructure.array;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangleTest {
    @Test
    public void case01() {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        List<Integer> triangleComponent = new ArrayList<>();

        triangleComponent.add(1);
        pascalTriangle.add(triangleComponent);

        triangleComponent = new ArrayList<>();
        triangleComponent.add(1);
        triangleComponent.add(1);
        pascalTriangle.add(triangleComponent);

        triangleComponent = new ArrayList<>();
        triangleComponent.add(1);
        triangleComponent.add(2);
        triangleComponent.add(1);
        pascalTriangle.add(triangleComponent);

        triangleComponent = new ArrayList<>();
        triangleComponent.add(1);
        triangleComponent.add(3);
        triangleComponent.add(3);
        triangleComponent.add(1);
        pascalTriangle.add(triangleComponent);

        triangleComponent = new ArrayList<>();
        triangleComponent.add(1);
        triangleComponent.add(4);
        triangleComponent.add(6);
        triangleComponent.add(4);
        triangleComponent.add(1);
        pascalTriangle.add(triangleComponent);

        Assert.assertThat(generate(5), CoreMatchers.is(pascalTriangle));
    }

    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();

        if (numRows == 0) {
            return pascalTriangle;
        }

        pascalTriangle.add(new ArrayList<>());
        pascalTriangle.get(0).add(1);

        List<Integer> currRow = new ArrayList<>();
        List<Integer> prevRow = new ArrayList<>();
        for (int i = 1; i < numRows; i++) {
            prevRow = pascalTriangle.get(i -1);
            currRow = new ArrayList<>();

            currRow.add(1);

            for (int j = 1; j < i; j++) {
                currRow.add(prevRow.get(j-1) + prevRow.get(j));
            }

            currRow.add(1);

            pascalTriangle.add(currRow);
        }

        return pascalTriangle;
    }
}
