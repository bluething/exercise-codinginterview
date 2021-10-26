package io.github.bluething.leetcode.algorithm.depthfirstsearch;


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTwoBinaryTreesTest {

    // Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped while the others are not.
    // You need to merge the two trees into a new binary tree.
    // The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node.
    // Otherwise, the NOT null node will be used as the node of the new tree.

    @Test
    public void case01() {
        TreeNode five1 = new TreeNode(5);
        TreeNode three1 = new TreeNode(3, five1, null);
        TreeNode two1 = new TreeNode(2);
        TreeNode one1 = new TreeNode(1, three1, two1);

        TreeNode four2 = new TreeNode(4);
        TreeNode one2 = new TreeNode(1, null, four2);
        TreeNode seven2 = new TreeNode(7);
        TreeNode three2 = new TreeNode(3, null, seven2);
        TreeNode two2 = new TreeNode(2, one2, three2);

        mergeTrees(one1, two2);

        List<Integer> actual = new ArrayList<>();
        printInOrderTree(one1, actual);

        List<Integer> expected = Arrays.asList(5, 4, 4, 3, 5, 7);

        Assert.assertEquals(expected, actual);
    }

    private void printInOrderTree(TreeNode tree, List<Integer> result) {
        if (tree != null) {
            printInOrderTree(tree.left, result);
            result.add(tree.val);
            printInOrderTree(tree.right, result);
        }
    }

    // traverse both tree in preorder, root-left-right
    // if both tree not null, sum the value
    // if the node is null, return the other root
    private TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        root1.val += root2.val;

        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this(val, null, null);
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode getRight() {
            return right;
        }

        public TreeNode getLeft() {
            return left;
        }

        public int getVal() {
            return val;
        }
    }
}
