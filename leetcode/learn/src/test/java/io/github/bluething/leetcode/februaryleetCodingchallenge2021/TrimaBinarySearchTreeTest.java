package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Test;

public class TrimaBinarySearchTreeTest {

    @Test
    public void successWhenInputIsRight() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2, one, null);
        TreeNode zero = new TreeNode(0, null, two);
        TreeNode four = new TreeNode(4, null, null);
        TreeNode root = new TreeNode(3, zero, four);
        root.traversePostOrder(trimBST(root, 1, 3));
    }

    // Traverse recursively
    // If meet null, stop recursion and go back up
    // If value < low, go back up and move to right
    // If value > high, go back up and move left
    // Otherwise continue recursively
    private TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }

        if (root.getValue() < low) {
            return trimBST(root.getRight(), low, high);
        } else if (root.getValue() > high) {
            return trimBST(root.getLeft(), low, high);
        }

        root.left = trimBST(root.getLeft(), low, high);
        root.right = trimBST(root.getRight(), low, high);

        return root;
    }

    class TreeNode {
        private final int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this(value, null, null);
        }

        TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public void traversePostOrder(TreeNode treeNode) {
            if (treeNode != null) {
                traversePostOrder(treeNode.getLeft());
                traversePostOrder(treeNode.getRight());
                System.out.print(" " + treeNode.getValue());
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
