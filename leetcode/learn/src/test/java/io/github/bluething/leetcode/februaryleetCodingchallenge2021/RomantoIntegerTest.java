package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class RomantoIntegerTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals(58, romanToInt("LVIII"));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals(1994, romanToInt("MCMXCIV"));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals(9, romanToInt("IX"));
    }

    @Test
    public void successWhenInputIsRightFour() {
        Assert.assertEquals(1476, romanToInt("MCDLXXVI"));
    }

    private int romanToInt(String s) {
        int intNumber = 0;
        char currentRoman = (char) 0;
        char nextRoman = (char) 0;
        for (int i = 0; i < s.length(); i++) {
            currentRoman = s.charAt(i);
            nextRoman = i == s.length() - 1 ? '0' : s.charAt(i + 1);
            if ((currentRoman == 'I' && (nextRoman == 'V' || nextRoman == 'X')) ||
                    (currentRoman == 'X' && (nextRoman == 'L' || nextRoman == 'C')) ||
                    (currentRoman == 'C' && (nextRoman == 'D' || nextRoman == 'M'))) {
                intNumber -= romanCharToInt(currentRoman);
            } else {
                intNumber += romanCharToInt(currentRoman);
            }
        }

        return intNumber;
    }

    private int romanCharToInt(char romanChar) {
        int number = 0;
        switch (romanChar) {
            case 'I':
                number = 1;
                break;
            case 'V':
                number = 5;
                break;
            case 'X':
                number = 10;
                break;
            case 'L':
                number = 50;
                break;
            case 'C':
                number = 100;
                break;
            case 'D':
                number = 500;
                break;
            case 'M':
                number = 1000;
                break;
            default :
                number = 0;
                break;
        }

        return number;
    }

    // The key is this condition
    // I can be placed before V (5) and X (10) to make 4 and 9.
    // X can be placed before L (50) and C (100) to make 40 and 90.
    // C can be placed before D (500) and M (1000) to make 400 and 900.
    // We can translate those condition like subtract currentRoman from number then add nextRoman to number
    // We doing this one by one from left to right
    // For example IX
    // 1st loop subtact I, next loop add X
}
