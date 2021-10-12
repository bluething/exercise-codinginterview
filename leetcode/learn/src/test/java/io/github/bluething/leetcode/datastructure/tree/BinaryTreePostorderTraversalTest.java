package io.github.bluething.leetcode.datastructure.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePostorderTraversalTest {

    @Test
    public void case01() {
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2, three, null);
        TreeNode one = new TreeNode(1, null, two);

        List<Integer> expectation = Arrays.asList(3, 2, 1);

        Assert.assertEquals(expectation, postorderTraversal(one));
    }
    private List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> values = new ArrayList<>();
        root.postorderTraversalRecursion(root, values);

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

        public void postorderTraversalRecursion(TreeNode treeNode, List<Integer> result) {
            if (treeNode != null) {
                postorderTraversalRecursion(treeNode.left, result);
                postorderTraversalRecursion(treeNode.right, result);
                result.add(treeNode.value);
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
