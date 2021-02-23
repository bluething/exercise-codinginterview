package io.github.bluething.leetcode.februaryleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWordinDictionarythroughDeletingTest {

    @Test
    public void successWhenInputIsRight() {
        Assert.assertEquals("apple", findLongestWord("abpcplea", Arrays.asList("ale","apple","monkey","plea")));
    }

    @Test
    public void successWhenInputIsRightTwo() {
        Assert.assertEquals("a", findLongestWord("abpcplea", Arrays.asList("a","b","c")));
    }

    @Test
    public void successWhenInputIsRightThree() {
        Assert.assertEquals("nbmxgkduynigvzuyblwjepn", findLongestWord("wsmzffsupzgauxwokahurhhikapmqitytvcgrfpavbxbmmzdhnrazartkzrnsmoovmiofmilihynvqlmwcihkfskwozyjlnpkgdkayioieztjswgwckmuqnhbvsfoevdynyejihombjppgdgjbqtlauoapqldkuhfbynopisrjsdelsfspzcknfwuwdcgnaxpevwodoegzeisyrlrfqqavfziermslnlclbaejzqglzjzmuprpksjpqgnohjjrpdlofruutojzfmianxsbzfeuabhgeflyhjnyugcnhteicsvjajludwizklkkosrpvhhrgkzctzwcghpxnbsmkxfydkvfevyewqnzniofhsriadsoxjmsswgpiabcbpdjjuffnbvoiwotrbvylmnryckpnyemzkiofwdnpnbhkapsktrkkkakxetvdpfkdlwqhfjyhvlxgywavtmezbgpobhikrnebmevthlzgajyrmnbougmrirsxi",
                Arrays.asList("jpthiudqzzeugzwwsngebdeai", "nbmxgkduynigvzuyblwjepn")));
    }

    private String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        int idxStart = 0;
        int idxCheck = 0;
        char currentChar = (char) 0;
        for (String word : d) {
            idxStart = 0;
            idxCheck = 0;
            for (int i = 0; i < word.length(); i++) {
                currentChar = word.charAt(i);
                idxCheck = s.indexOf(currentChar, idxStart);
                if (idxCheck != -1) {
                    idxStart = idxCheck + 1;
                } else {
                    break;
                }
            }
            if (idxCheck != -1) {
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                } else if (word.length() == longestWord.length()) {
                    if (word.compareTo(longestWord) < 0) {
                        longestWord = word;
                    }
                }
            }
        }

        return longestWord;
    }
}
