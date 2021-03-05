package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class AverageofLevelsinBinaryTreeTest {

    @Test
    public void successWhenInputIsRight() {
        TreeNode nine = new TreeNode(9);
        TreeNode fifteen = new TreeNode(15);
        TreeNode seven = new TreeNode(7);
        TreeNode twenty = new TreeNode(20, fifteen, seven);
        TreeNode root = new TreeNode(3, nine, twenty);

        List<Double> expectedAvgValues = Arrays.asList(new Double[]{3d, 14.5, 11d});
        Assert.assertEquals(expectedAvgValues, averageOfLevels(root));
    }

    private List<Double> averageOfLevels(TreeNode root) {
        List<Double> avgValues = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>(List.of(root));
        double qLength = 0;
        double row = 0;
        while (!q.isEmpty()) {
            qLength = q.size();
            row = 0;
            for (int i = 0; i < qLength; i++) {
                TreeNode current = q.poll();
                row += current.val;
                if (current.left != null) {
                    q.offer(current.left);
                }
                if (current.right != null) {
                    q.offer(current.right);
                }
            }

            avgValues.add(row / qLength);
        }

        return avgValues;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // Level in binary tree -> breadth first search
    // One of algorithm is using queue
    // We want to push every node to queue, start from root, continue to left and right for each level.
    // The queue will run to the end of the row/level before moving onto the next level.
    // Sum the row's values (row), then divide by the length of the row (qlen) to find the average
    // The row's values will will be sequentially in the queue
    // qLength is how many nodes in row. Produce by left+right offer for each poll

}
