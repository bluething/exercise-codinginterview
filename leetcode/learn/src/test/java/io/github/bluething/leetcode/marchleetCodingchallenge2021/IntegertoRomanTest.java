package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

public class IntegertoRomanTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals("III", intToRoman(3));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals("IV", intToRoman(4));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals("LVIII", intToRoman(58));
    }

    @Test
    public void successWhenInputIsRightFive() {
        Assert.assertEquals("MCMXCIV", intToRoman(1994));
    }

    private String intToRoman(int num) {
        int[] base = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder roman = new StringBuilder();
        int quotient = 0;
        int reminder = 0;
        while (num != 0) {
            for (int i = 0; i < base.length; i++) {
                if (num >= base[i]) {
                    quotient = num / base[i];
                    num = num % base[i];
                    roman.append(intToRomanChar(base[i], quotient));
                }
            }
        }

        return roman.toString();
    }

    private String intToRomanChar(int num, int count) {
        StringBuilder roman = new StringBuilder();
        String romanChar = "";
        switch (num) {
            case 1000:
                romanChar = "M";
                break;
            case 900:
                romanChar = "CM";
                break;
            case 500:
                romanChar = "D";
                break;
            case 400:
                romanChar = "CD";
                break;
            case 100:
                romanChar = "C";
                break;
            case 90:
                romanChar = "XC";
                break;
            case 50:
                romanChar = "L";
                break;
            case 40:
                romanChar = "XL";
                break;
            case 10:
                romanChar = "X";
                break;
            case 9:
                romanChar = "IX";
                break;
            case 5:
                romanChar = "V";
                break;
            case 4:
                romanChar = "IV";
                break;
            default:
                romanChar = "I";
                break;
        }

        for (int i = 1; i <= count; i++) {
            roman.append(romanChar);
        }

        return roman.toString();
    }
}
