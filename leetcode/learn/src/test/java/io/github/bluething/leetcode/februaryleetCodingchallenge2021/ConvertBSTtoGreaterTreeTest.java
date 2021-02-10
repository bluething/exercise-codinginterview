package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Test;

public class ConvertBSTtoGreaterTreeTest {

    int sum;

    @Test
    public void successWhenInputIsRight() {
        TreeNode three = new TreeNode(3, null, null);
        TreeNode two = new TreeNode(2, null, three);
        TreeNode zero = new TreeNode(0, null, null);
        TreeNode one = new TreeNode(1, zero, two);
        TreeNode eight = new TreeNode(8, null, null);
        TreeNode seven = new TreeNode(7, null, eight);
        TreeNode five = new TreeNode(5, null, null);
        TreeNode six = new TreeNode(6, five, seven);
        TreeNode four = new TreeNode(4, one, six);

        convertBST(four);
        System.out.println();
    }

    private TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }

        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);

        return root;
    }

    // recursively traverse BTS inorder with reverse order (right - root - left)
    // convert each node with node + sum visited node



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
}
