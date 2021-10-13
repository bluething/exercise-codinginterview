package io.github.bluething.leetcode.datastructure.tree;

import java.util.Stack;

public class MaximumDepthOfBinaryTreeTest {
    // traverse both left and right, +1 for each stage
    // find max between both
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }

    // using stack, push the node from left and right
    // 1st stack contain the nodes
    // 2nd stack contain counter for each node in 1st stack
    // +1 currentNodeCount for each left and right child
    // every time we pop 1st stack, we calculate the new currentNodeCount (depth) and max
    private int maxDepthIteration(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Stack<TreeNode> nodes = new Stack<>();
        Stack<Integer> counter = new Stack<>();
        int max = 0;

        nodes.push(root);
        counter.push(1);

        TreeNode current = null;
        int currentNodeCount = 0;
        while (!nodes.empty()) {
            current = nodes.pop();
            currentNodeCount = counter.pop();
            max = Math.max(max, currentNodeCount);

            if (current.left != null) {
                nodes.push(current.left);
                counter.push(currentNodeCount + 1);
            }
            if (current.right != null) {
                nodes.push(current.right);
                counter.push(currentNodeCount + 1);
            }
        }

        return max;
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
