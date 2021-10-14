package io.github.bluething.leetcode.datastructure.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

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

    @Test
    public void case03() {
        TreeNode four1 = new TreeNode(4);
        TreeNode three1 = new TreeNode(3);
        TreeNode two1 = new TreeNode(2, three1, four1);
        TreeNode four2 = new TreeNode(4);
        TreeNode three2 = new TreeNode(3);
        TreeNode two2 = new TreeNode(2, three2, four2);
        TreeNode one = new TreeNode(1, two1, two2);

        Assert.assertTrue(isSymmetricIterative(one));
    }

    @Test
    public void case04() {
        TreeNode three1 = new TreeNode(3);
        TreeNode two1 = new TreeNode(2, null, three1);
        TreeNode three2 = new TreeNode(3);
        TreeNode two2 = new TreeNode(2, null, three2);
        TreeNode one = new TreeNode(1, two1, two2);

        Assert.assertFalse(isSymmetricIterative(one));
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

    // The idea is using stack to save left and right side
    // -- be careful about the order we push --
    // in each iteration we pop two topmost nodes (the mirror nodes)
    // return false if one of the side have null or different value
    // else (both have same value)
    // compare left and right (push into the stack)
    // push left.left and right.right, left.right and right.left
    private boolean isSymmetricIterative(TreeNode root) {
        if (root == null) {
            return true;
        }

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root.left);
        nodes.push(root.right);

        TreeNode tempLeft = null;
        TreeNode tempRight = null;
        while (!nodes.empty()) {
            tempRight = nodes.pop();
            tempLeft = nodes.pop();

            if (tempLeft == null && tempRight == null) {
                continue;
            }

            if (tempLeft == null || tempRight == null || (tempLeft.value != tempRight.value)) {
                return false;
            }

            nodes.push(tempLeft.left);
            nodes.push(tempRight.right);
            nodes.push(tempLeft.right);
            nodes.push(tempRight.left);
        }

        return true;
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
