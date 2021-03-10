package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class AddOneRowtoTreeTest {

    @Test
    public void successWhenInputIsRight() {
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2, three, one);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6, five, null);
        TreeNode root = new TreeNode(4, two, six);
        Assert.assertEquals(1, addOneRow(root, 1, 2).left.val);

    }

    @Test
    public void successWhenInputIsRightTwo() {
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2, three, one);
        TreeNode root = new TreeNode(4, two, null);
        Assert.assertEquals(1, addOneRow(root, 1, 3).left.left.val);
    }

    private TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            return new TreeNode(v, root, null);
        } else if (d == 2) {
            root.left = new TreeNode(v, root.left, null);
            root.right = new TreeNode(v, null, root.right);
        } else {
            if (root.left != null) {
                addOneRow(root.left, v, d - 1);
            }
            if (root.right != null) {
                addOneRow(root.right, v, d - 1);
            }
        }

        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
            this(0, null, null);
        }

        TreeNode(int val) {
            this(val, null, null);
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }

    // The ide is using DFS recursion
    // Walk downwards while reducing d value, until we get to our destination row
    // We will add parent at d row, so we add this at d-2
    // What if d = 1, we don't have a parent for root? Add new root and add old root as left node
}
