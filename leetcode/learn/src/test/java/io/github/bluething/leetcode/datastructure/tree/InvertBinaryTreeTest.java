package io.github.bluething.leetcode.datastructure.tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

public class InvertBinaryTreeTest {
    @Test
    public void case01() {
        TreeNode inputNine = new TreeNode(9);
        TreeNode inputSix = new TreeNode(6);
        TreeNode inputSeven = new TreeNode(7, inputSix, inputNine);
        TreeNode inputOne = new TreeNode(1);
        TreeNode inputThree = new TreeNode(3);
        TreeNode inputTwo = new TreeNode(2, inputOne, inputThree);
        TreeNode inputFour = new TreeNode(4, inputTwo, inputSeven);

        TreeNode outputNine = new TreeNode(9);
        TreeNode outputSix = new TreeNode(6);
        TreeNode outputSeven = new TreeNode(7, outputNine, outputSix);
        TreeNode outputOne = new TreeNode(1);
        TreeNode outputThree = new TreeNode(3);
        TreeNode outputTwo = new TreeNode(2, outputOne, outputThree);
        TreeNode outputFour = new TreeNode(4, outputSeven, outputTwo);

        Assert.assertEquals(outputFour.left.value, invertTree(inputFour).left.value);

    }

    @Test
    public void case02() {
        TreeNode inputNine = new TreeNode(9);
        TreeNode inputSix = new TreeNode(6);
        TreeNode inputSeven = new TreeNode(7, inputSix, inputNine);
        TreeNode inputOne = new TreeNode(1);
        TreeNode inputThree = new TreeNode(3);
        TreeNode inputTwo = new TreeNode(2, inputOne, inputThree);
        TreeNode inputFour = new TreeNode(4, inputTwo, inputSeven);

        TreeNode outputNine = new TreeNode(9);
        TreeNode outputSix = new TreeNode(6);
        TreeNode outputSeven = new TreeNode(7, outputNine, outputSix);
        TreeNode outputOne = new TreeNode(1);
        TreeNode outputThree = new TreeNode(3);
        TreeNode outputTwo = new TreeNode(2, outputOne, outputThree);
        TreeNode outputFour = new TreeNode(4, outputSeven, outputTwo);

        Assert.assertEquals(outputFour.left.value, invertTreeIterative(inputFour).left.value);

    }

    private TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }

    // watch the stack push order
    private TreeNode invertTreeIterative(TreeNode root) {
        if (root == null) {
            return  null;
        }

        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);

        TreeNode temp = null;
        while (!nodes.empty()) {
            temp = nodes.pop();
            if (temp != null) {
                nodes.push(temp.right);
                nodes.push(temp.left);

                temp = root.left;
                root.left = root.right;
                root.right = temp;
            }
        }

        return root;
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
