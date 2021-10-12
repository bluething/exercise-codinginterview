package io.github.bluething.leetcode.datastructure.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversalTest {
    @Test
    public void case01() {
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2, three, null);
        TreeNode one = new TreeNode(1, null, two);

        List<Integer> expectation = Arrays.asList(1, 3, 2);

        Assert.assertEquals(expectation, inorderTraversal(one));
    }

    @Test
    public void case02() {
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2, three, null);
        TreeNode one = new TreeNode(1, null, two);

        List<Integer> expectation = Arrays.asList(1, 3, 2);

        Assert.assertEquals(expectation, inorderTraversalUsingIteration(one));
    }

    @Test
    public void case03() {
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode two = new TreeNode(2, four, five);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1, two, three);

        List<Integer> expectation = Arrays.asList(4, 2, 5, 1, 3);

        Assert.assertEquals(expectation, inorderTraversalUsingIteration(one));
    }

    private List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> values = new ArrayList<>();
        root.inorderTraversalRecursion(root, values);

        return values;
    }

    // the idea is we push value in the left until don't have child
    // when temp is null (the left bottom of tree) add the value into the list
    // then move to the right, set temp for the right node and try to push value in the left
    private List<Integer> inorderTraversalUsingIteration(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> values = new ArrayList<>();
        TreeNode temp = root;
        Stack<TreeNode> nodes = new Stack<>();
        while (!nodes.empty() || temp != null) {
            if (temp != null) {
                nodes.push(temp);
                temp = temp.left;
            } else {
                values.add(nodes.peek().value);
                temp = nodes.pop().right;
            }
        }

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

        public void inorderTraversalRecursion(TreeNode treeNode, List<Integer> result) {
            if (treeNode != null) {
                inorderTraversalRecursion(treeNode.left, result);
                result.add(treeNode.value);
                inorderTraversalRecursion(treeNode.right, result);
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
