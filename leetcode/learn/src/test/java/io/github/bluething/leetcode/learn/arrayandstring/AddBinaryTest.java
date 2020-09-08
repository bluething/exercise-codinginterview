package learn.src.test.java.io.github.bluething.leetcode.learn.arrayandstring;

import org.junit.Assert;

public class AddBinaryTest {

    private String addBinary(String a, String b) {
        StringBuilder stringBuilder = new StringBuilder();
        int countA = a.length() - 1;
        int countB = b.length() - 1;
        int carry = 0;
        int sum = 0;
        while (countA >= 0 || countB >= 0) {
            sum = 0;
            sum += a.charAt(countA) - '0';
            countA--;
            sum += b.charAt(countB) - '0';
            countB--;

            if (sum % 2 == 0) {
                carry = 1;
                sum = 0;
            } else {
                carry = 0;
            }

            stringBuilder.insert(0, sum);
        }

        return stringBuilder.toString();
    }

    public void successWhenInputIsRight() {
    }
}
