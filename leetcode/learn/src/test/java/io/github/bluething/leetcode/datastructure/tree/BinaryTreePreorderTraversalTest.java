package io.github.bluething.leetcode.datastructure.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePreorderTraversalTest {

    @Test
    public void case01() {
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2, three, null);
        TreeNode one = new TreeNode(1, null, two);

        List<Integer> expectation = Arrays.asList(1, 2, 3);

        Assert.assertEquals(expectation, preorderTraversal(one));
    }

    private List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> values = new ArrayList<>();
        root.preorderTraversalRecursion(root, values);

        return values;
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

        public void preorderTraversalRecursion(TreeNode treeNode, List<Integer> result) {
            if (treeNode != null) {
                result.add(treeNode.value);
                preorderTraversalRecursion(treeNode.left, result);
                preorderTraversalRecursion(treeNode.right, result);
            }
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
