package io.github.bluething.leetcode.datastructure.tree;

import org.junit.Assert;
import org.junit.Test;

public class PathSumTest {

    @Test
    public void case01() {
        TreeNode one = new TreeNode(1);
        TreeNode thirdTeen = new TreeNode(13);
        TreeNode four = new TreeNode(4, null, one);
        TreeNode eight = new TreeNode(8, thirdTeen, four);
        TreeNode seven = new TreeNode(7);
        TreeNode two = new TreeNode(2);
        TreeNode eleven = new TreeNode(11, seven, two);
        TreeNode four1 = new TreeNode(4, eleven, null);
        TreeNode five = new TreeNode(5, four1, eight);

        Assert.assertTrue(hasPathSum(five, 22));
    }

    @Test
    public void case02() {
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1, two, three);

        Assert.assertFalse(hasPathSum(one, 0));
    }

    @Test
    public void case03() {
        TreeNode empty = new TreeNode();

        Assert.assertFalse(hasPathSum(empty, 0));
    }

    // the idea is everytime we go down the tree, subtract root value from target sum
    // when we reach bottom, check if targetSum is 0
    // doing recursion check for all path if targetSum can be 0
    // at the end of process we will have true/false for each legs
    private boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        targetSum -= root.value;
        if (targetSum == 0 && (root.left == null && root.right == null)) {
            return true;
        }

        boolean left = hasPathSum(root.left, targetSum);
        boolean right = hasPathSum(root.right, targetSum);

        return left || right;
    }

    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int value) {
            this(value, null, null);
        }

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public TreeNode getRight() {
            return right;
        }

        public TreeNode getLeft() {
            return left;
        }

        public int getValue() {
            return value;
        }
    }
}
