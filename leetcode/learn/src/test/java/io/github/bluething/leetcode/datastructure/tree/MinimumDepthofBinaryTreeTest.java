package io.github.bluething.leetcode.datastructure.tree;

import com.sun.source.tree.Tree;
import org.junit.Assert;
import org.junit.Test;

public class MinimumDepthofBinaryTreeTest {

    @Test
    public void case01() {
        TreeNode seven = new TreeNode(7);
        TreeNode fiveTeen = new TreeNode(15);
        TreeNode twenty = new TreeNode(20, fiveTeen, seven);
        TreeNode nine = new TreeNode(9);
        TreeNode three = new TreeNode(3, nine, twenty);

        Assert.assertEquals(2, minDepth(three));
    }

    @Test
    public void case02() {
        TreeNode seven = new TreeNode(7);
        TreeNode fiveTeen = new TreeNode(15);
        TreeNode twenty = new TreeNode(20, fiveTeen, seven);
        TreeNode nine = new TreeNode(9);
        TreeNode three = new TreeNode(3, nine, twenty);

        Assert.assertEquals(2, minDepth(three));
    }

    @Test
    public void case03() {
        TreeNode six = new TreeNode(6);
        TreeNode five = new TreeNode(5, null, six);
        TreeNode four = new TreeNode(4, null, five);
        TreeNode three = new TreeNode(3, null, four);
        TreeNode two = new TreeNode(2, null, three);

        Assert.assertEquals(5, minDepth(two));
    }

    private int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        // don't have child, return 1
        if (root.left == null && root.right == null) {
            return 1;
        }
        // Find min depth from the left
        if (root.left != null) {
            min = Math.min(minDepth(root.left), min);
        }
        // Find min depth from the right
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }

        // increment each layer
        return min + 1;
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
