package week05;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StrongPasswordTest {
    @Test
    public void case01() {
        Assertions.assertEquals(2, minimumNumber(5, "2bbbb"));
    }

    @Test
    public void case02() {
        Assertions.assertEquals(3, minimumNumber(3, "Ab1"));
    }

    private int minimumNumber(int n, String password) {
        int minimumCharAdded = 0;
        int digitCounter = 0;
        int lowercaseCounter = 0;
        int upperCaseCounter = 0;
        int specialCharCounter = 0;
        char[] passwords = password.toCharArray();
        for (int i = 0; i < passwords.length; i++) {
            if (passwords[i] >= 48 && passwords[i] <= 57) {
                digitCounter++;
            } else if (passwords[i] >= 97 && passwords[i] <= 122) {
                lowercaseCounter++;
            } else if (passwords[i] >= 65 && passwords[i] <= 90) {
                upperCaseCounter++;
            } else if ((passwords[i] >= 33 && passwords[i] <= 47) ||
                    (passwords[i] >= 91 && passwords[i] <= 96)) {
                specialCharCounter++;
            }
        }

        if (digitCounter == 0) {
            minimumCharAdded++;
        }
        if (lowercaseCounter == 0) {
            minimumCharAdded++;
        }
        if (upperCaseCounter == 0) {
            minimumCharAdded++;
        }
        if (specialCharCounter == 0) {
            minimumCharAdded++;
        }

        return Math.max(minimumCharAdded, 6 - n);
    }
}
