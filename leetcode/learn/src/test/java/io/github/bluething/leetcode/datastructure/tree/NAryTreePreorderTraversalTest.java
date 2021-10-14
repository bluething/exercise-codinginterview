package io.github.bluething.leetcode.datastructure.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NAryTreePreorderTraversalTest {

    private List<Integer> values;

    @Before
    public void beforeEach() {
        this.values = new ArrayList<>();
    }

    @Test
    public void case01() {
        Node five = new Node(5);
        Node six = new Node(6);
        Node three = new Node(3, Arrays.asList(five, six));
        Node two = new Node(2);
        Node four = new Node(4);
        Node one = new Node(1, Arrays.asList(three, two, four));

        List<Integer> expected = Arrays.asList(1,3,5,6,2,4);

        Assert.assertEquals(expected, preorder(one));
    }

    @Test
    public void case02() {
        Node thirdTeen = new Node(13);
        Node nine = new Node(9, Arrays.asList(thirdTeen));
        Node ten = new Node(10);
        Node five = new Node(5, Arrays.asList(nine, ten));
        Node twelve = new Node(12);
        Node eight = new Node(8, Arrays.asList(twelve));
        Node four = new Node(4, Arrays.asList(eight));
        Node fourteen = new Node(14);
        Node eleven = new Node(11, Arrays.asList(fourteen));
        Node seven = new Node(7, Arrays.asList(eleven));
        Node six = new Node(6);
        Node three = new Node(3, Arrays.asList(six, seven));
        Node two = new Node(2);
        Node one = new Node(1, Arrays.asList(two, three, four, five));

        List<Integer> expected = Arrays.asList(1,2,3,6,7,11,14,4,8,12,5,9,13,10);

        Assert.assertEquals(expected, preorder(one));
    }

    @Test
    public void case03() {
        Node five = new Node(5);
        Node six = new Node(6);
        Node three = new Node(3, Arrays.asList(five, six));
        Node two = new Node(2);
        Node four = new Node(4);
        Node one = new Node(1, Arrays.asList(three, two, four));

        List<Integer> expected = Arrays.asList(1,3,5,6,2,4);

        Assert.assertEquals(expected, preorderIterative(one));
    }

    @Test
    public void case04() {
        Node thirdTeen = new Node(13);
        Node nine = new Node(9, Arrays.asList(thirdTeen));
        Node ten = new Node(10);
        Node five = new Node(5, Arrays.asList(nine, ten));
        Node twelve = new Node(12);
        Node eight = new Node(8, Arrays.asList(twelve));
        Node four = new Node(4, Arrays.asList(eight));
        Node fourteen = new Node(14);
        Node eleven = new Node(11, Arrays.asList(fourteen));
        Node seven = new Node(7, Arrays.asList(eleven));
        Node six = new Node(6);
        Node three = new Node(3, Arrays.asList(six, seven));
        Node two = new Node(2);
        Node one = new Node(1, Arrays.asList(two, three, four, five));

        List<Integer> expected = Arrays.asList(1,2,3,6,7,11,14,4,8,12,5,9,13,10);

        Assert.assertEquals(expected, preorderIterative(one));
    }

    // using preorder, add root value first
    // for each child do recursion (the children will have order from left)
    // with this recursion we traverse the tre in left side first
    // preorder -> root-left-right
    private List<Integer> preorder(Node root) {
        if (root == null) {
            return values;
        }

        values.add(root.val);

        for (Node node : root.children) {
            preorder(node);
        }

        return values;
    }

    // using stack
    // 1st push the root
    // while the stack is not empty add the root value to the list
    // iterate the child and push to the stack
    // -- be careful about the order --
    // if we iterate 0 -> children.size-1 then push, we will have stack in the wrong order (from right->left)
    // we want the order left -> right
    // so iterate the children childreen.szie-1 -> 0
    private List<Integer> preorderIterative(Node root) {
        if (root == null) {
            return values;
        }

        Stack<Node> nodes = new Stack<>();
        nodes.push(root);

        Node temp = null;
        while (!nodes.empty()) {
            temp = nodes.pop();
            values.add(temp.val);

            for (int i = temp.children.size() - 1; i >= 0; i--) {
                nodes.push(temp.children.get(i));
            }
        }

        return values;
    }

    class Node {
        public int val;
        public List<Node> children = new ArrayList<>();

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    }
}
