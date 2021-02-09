package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

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
        Deque<String> tokenPaths = new ArrayDeque<>();
        String token = "";
        for (int i = 0; i < tokens.length; i++) {
            token = tokens[i];
            switch (token) {
                case "":
                    case ".":
                        break;
                case "..":
                    if (!tokenPaths.isEmpty()) {
                        tokenPaths.pollLast();
                    }
                    break;
                default:
                    tokenPaths.offerLast(token);
            }
        }

        StringBuilder canonPath = new StringBuilder("");
        int tokenPathsLength = tokenPaths.size();
        while (tokenPathsLength > 0) {
            canonPath.append("/");
            canonPath.append(tokenPaths.pollFirst());
            tokenPathsLength--;
        }

        if (canonPath.length() == 0) {
            canonPath.append("/");
        }

        return canonPath.toString();
    }

    // The idea is using deque to save the tokens after we split the path by "/"
    // After we fill deque, we iterate until size 0 and we get and remove the 1st element
}
