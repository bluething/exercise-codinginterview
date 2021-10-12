package io.github.bluething.leetcode.datastructure.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversalTest {

    @Test
    public void case01() {
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2, three, null);
        TreeNode one = new TreeNode(1, null, two);

        List<Integer> expectation = Arrays.asList(3, 2, 1);

        Assert.assertEquals(expectation, postorderTraversal(one));
    }

    @Test
    public void case02() {
        TreeNode three = new TreeNode(3);
        TreeNode two = new TreeNode(2, three, null);
        TreeNode one = new TreeNode(1, null, two);

        List<Integer> expectation = Arrays.asList(3, 2, 1);

        Assert.assertEquals(expectation, postorderTraversalIterative(one));
    }

    private List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> values = new ArrayList<>();
        root.postorderTraversalRecursion(root, values);

        return values;
    }

    private List<Integer> postorderTraversalIterative(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode current = root;
        TreeNode prev = null;

        while (!nodes.empty() || current != null) {
            // push leftmost nodes
            while (current != null) {
                nodes.push(current);
                current = current.left;
            }

            // if the last node don't have right child
            // or
            // the right child is the prev (we already traversed all the nodes of stack.peek())
            if (nodes.peek().right == null || nodes.peek().right == prev) {
                prev = nodes.pop();
                values.add(prev.value);
            } else {
                // visit the right child
                current = nodes.peek().right;
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
