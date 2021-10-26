package io.github.bluething.leetcode.algorithm.depthfirstsearch;

import org.junit.Test;

public class PopulatingNextRightPointersinEachNodeTest {
    // You are given a perfect binary tree where all leaves are on the same level, and every parent has two children.
    // Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
    //Initially, all next pointers are set to NULL.

    private Node connect(Node root) {
        dfs(root);
        return root;
    }
    // it's a perfect binary tree
    // 1. all leaves are on the same level
    // 2. every parent has two children
    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        // if the node is not a leaf node
        if (root.left != null) {
            // add reference of immediate right node in current level
            root.left.next = root.right;

            // if the root have next node, add reference to the right child
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }

        // go to the left and right child
        dfs(root.left);
        dfs(root.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
