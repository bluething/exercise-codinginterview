package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;
import java.util.Stack;

public class SimplifyPathTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals("/home", simplifyPath("/home/"));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals("/", simplifyPath("/../"));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals("/home/foo", simplifyPath("/home//foo"));
    }

    @Test
    public void successWhenInputIsRightFour() {
        Assert.assertEquals("/c", simplifyPath("/a/./b/../../c/"));
    }

    private String simplifyPath(String path) {
        String[] tokens = path.split("\\/");
        String token = "";
        Stack<String> paths = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            token = tokens[i];
            switch (token) {
                case "":
                case ".":
                    break;
                case "..":
                    if (!paths.isEmpty()) {
                        paths.pop();
                    }
                    break;
                default:
                    paths.push(token);
            }
        }

        StringBuilder canonPath = new StringBuilder("/");
        Iterator<String> iterator = paths.iterator();
        while (iterator.hasNext()) {
            canonPath.append(iterator.next());
            canonPath.append("/");
        }

        if (canonPath.length() > 1 && canonPath.charAt(canonPath.length() -  1) == '/') {
            canonPath.deleteCharAt(canonPath.length() -  1);
        }

        return canonPath.toString();
    }

    // The idea is using stack to save the tokens after we split the path by "/"
    // After we get the stack, we iterate from bottom to top for canon path construction
    // Question:
    // 1. Stack naturally LIFO, this solution force the stack to FIFO
}
