package io.github.bluething.algoexpert.questions;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println("case 01: " + longestPalindromicSubstring("abaxyzzyxf"));
        System.out.println("case 02: " + longestPalindromicSubstring("noon high it is"));
        System.out.println("case 03: " + longestPalindromicSubstring("abccbait's highnoon"));
        System.out.println("case 04: " + longestPalindromicSubstring("a"));
    }

    private static String longestPalindromicSubstring(String str) {
        int[] longestIdx = new int[]{0, 1};
        int[] currentLongestIdx = new int[]{1, 0};
        int[] longestOddPalind = new int[]{0, 1};
        int[] longestEvenLaind = new int[]{0, 1};
        for (int i = 1; i < str.length(); i++) {
            longestOddPalind = getLongestPalindIdx(str, i - 1, i + 1);
            longestEvenLaind = getLongestPalindIdx(str, i - 1, i);
            currentLongestIdx = longestOddPalind[1] - longestOddPalind[0] > longestEvenLaind[1] - longestEvenLaind[0] ?
                    longestOddPalind :
                    longestEvenLaind;
            longestIdx = longestIdx[1] - longestIdx[0] > currentLongestIdx[1] - currentLongestIdx[0] ?
                    longestIdx :
                    currentLongestIdx;
        }
        return str.substring(longestIdx[0], longestIdx[1]);
    }
    private static int[] getLongestPalindIdx(String str, int leftIdx, int rightIdx) {
        while (leftIdx >= 0 && rightIdx < str.length()) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                break;
            }
            leftIdx--;
            rightIdx++;
        }
        // remember substring function
        // Returns a new string that is a substring of this string. The substring begins at the specified beginIndex and extends to the character at index endIndex - 1
        // so we need to add 1 to left index
        return new int[]{leftIdx + 1, rightIdx};
    }
    // we can check palindrome by loop the string using 2 pointers (left and right).
    // check if the character from left and right is same.
    // we can check all possible substring (using nested loop) if the substring is palindrome.
    // the problem is time complexity will greater than m^3, in inner loop we need to check is the substring palindrome using another loop.
    // instead of check from edge index, how about we start from current idx then expand the index (to left and right) and check if the character at the edge is same.
    // the palindrome is a symmetrical string with respect to its center.
    // pay attention, the center will be a character (odd number) or empty (even), check both condition.
    // for each cases, find the longest one then compare to existing longest.
}
