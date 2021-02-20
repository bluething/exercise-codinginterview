package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
        Map<String, Integer> romanToIntNumber = new HashMap<>();
        romanToIntNumber.put("I", Integer.valueOf(1));
        romanToIntNumber.put("V", Integer.valueOf(5));
        romanToIntNumber.put("X", Integer.valueOf(10));
        romanToIntNumber.put("L", Integer.valueOf(50));
        romanToIntNumber.put("C", Integer.valueOf(100));
        romanToIntNumber.put("D", Integer.valueOf(500));
        romanToIntNumber.put("M", Integer.valueOf(1000));
        romanToIntNumber.put("IV", Integer.valueOf(4));
        romanToIntNumber.put("IX", Integer.valueOf(9));
        romanToIntNumber.put("XL", Integer.valueOf(40));
        romanToIntNumber.put("XC", Integer.valueOf(90));
        romanToIntNumber.put("CD", Integer.valueOf(400));
        romanToIntNumber.put("CM", Integer.valueOf(900));

        int intNumber = 0;
        String romanNumber = "";
        String romanNumberBefore = "";
        int i = s.length() - 1;
        for (; i > 0; i--) {
            romanNumber = String.valueOf(s.charAt(i));
            romanNumberBefore = s.substring(i - 1, i);
            switch (romanNumber) {
                case "I" :
                    intNumber += romanToIntNumber.get(romanNumber);
                    break;
                case "V" :
                    if (romanNumberBefore.equals("I")) {
                        intNumber += romanToIntNumber.get(romanNumberBefore + romanNumber);
                        i--;
                    } else {
                        intNumber += romanToIntNumber.get(romanNumber);
                    }
                    break;
                case "X" :
                    if (romanNumberBefore.equals("I")) {
                        intNumber += romanToIntNumber.get(romanNumberBefore + romanNumber);
                        i--;
                    } else {
                        intNumber += romanToIntNumber.get(romanNumber);
                    }
                    break;
                case "L" :
                    if (romanNumberBefore.equals("X")) {
                        intNumber += romanToIntNumber.get(romanNumberBefore + romanNumber);
                        i--;
                    } else {
                        intNumber += romanToIntNumber.get(romanNumber);
                    }
                    break;
                case "C" :
                    if (romanNumberBefore.equals("X")) {
                        intNumber += romanToIntNumber.get(romanNumberBefore + romanNumber);
                        i--;
                    } else {
                        intNumber += romanToIntNumber.get(romanNumber);
                    }
                    break;
                case "D" :
                    if (romanNumberBefore.equals("C")) {
                        intNumber += romanToIntNumber.get(romanNumberBefore + romanNumber);
                        i--;
                    } else {
                        intNumber += romanToIntNumber.get(romanNumber);
                    }
                    break;
                case "M" :
                    if (romanNumberBefore.equals("C")) {
                        intNumber += romanToIntNumber.get(romanNumberBefore + romanNumber);
                        i--;
                    } else {
                        intNumber += romanToIntNumber.get(romanNumber);
                    }
                    break;
                default :
                    break;
            }
        }

        if (i == 0) {
            romanNumber = String.valueOf(s.charAt(i));
            switch (romanNumber) {
                case "I":
                    intNumber += romanToIntNumber.get(romanNumber);
                    break;
                case "V":
                    intNumber += romanToIntNumber.get(romanNumber);
                    break;
                case "X":
                    intNumber += romanToIntNumber.get(romanNumber);
                    break;
                case "L":
                    intNumber += romanToIntNumber.get(romanNumber);
                    break;
                case "C":
                    intNumber += romanToIntNumber.get(romanNumber);
                    break;
                case "D":
                    intNumber += romanToIntNumber.get(romanNumber);
                    break;
                case "M":
                    intNumber += romanToIntNumber.get(romanNumber);
                    break;
                default:
                    break;
            }
        }

        return intNumber;
    }
}
