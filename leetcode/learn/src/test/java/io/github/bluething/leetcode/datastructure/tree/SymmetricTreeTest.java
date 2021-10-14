package io.github.bluething.leetcode.datastructure.tree;

import org.junit.Assert;
import org.junit.Test;

public class SymmetricTreeTest {
    @Test
    public void case01() {
        TreeNode four1 = new TreeNode(4);
        TreeNode three1 = new TreeNode(3);
        TreeNode two1 = new TreeNode(2, three1, four1);
        TreeNode four2 = new TreeNode(4);
        TreeNode three2 = new TreeNode(3);
        TreeNode two2 = new TreeNode(2, three2, four2);
        TreeNode one = new TreeNode(1, two1, two2);

        Assert.assertTrue(isSymmetric(one));
    }

    @Test
    public void case02() {
        TreeNode three1 = new TreeNode(3);
        TreeNode two1 = new TreeNode(2, null, three1);
        TreeNode three2 = new TreeNode(3);
        TreeNode two2 = new TreeNode(2, null, three2);
        TreeNode one = new TreeNode(1, two1, two2);

        Assert.assertFalse(isSymmetric(one));
    }

    private boolean isSymmetric(TreeNode root) {
        return traverse(root.left, root.right);
    }
    // compare left side and right side
    // if both null, return true
    // if one of them null, return false
    // if left and right have same value, doing recursion compare left.left with right.left and left.right with right.left
    // if left and right have different value, return false
    private boolean traverse(TreeNode one, TreeNode two) {
        if (one == null && two == null) {
            return true;
        }
        if ((one != null && two == null) || (one == null && two != null)) {
            return false;
        }
        if (one.value == two.value) {
            return traverse(one.left, two.right) && traverse(one.right, two.left);
        } else {
            return false;
        }
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
