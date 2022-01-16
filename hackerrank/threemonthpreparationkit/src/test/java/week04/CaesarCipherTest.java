package week04;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Julius Caesar protected his confidential information by encrypting it using a cipher.
// Caesar's cipher shifts each letter by a number of letters. If the shift takes you past the end of the alphabet, just rotate back to the front of the alphabet.
// In the case of a rotation by 3, w, x, y and z would map to z, a, b and c.
//
// Note: The cipher only encrypts letters; symbols, such as -, remain unencrypted.
public class CaesarCipherTest {
    @Test
    public void case01() {
        Assertions.assertEquals("okffng-Qwvb", caesarCipher("middle-Outz", 2));
    }

    @Test
    public void case02() {
        Assertions.assertEquals("fff.jkl.gh", caesarCipher("www.abc.xy", 87));
    }

    private String caesarCipher(String s, int k) {
        k %= 26;
        char[] stringChars = s.toCharArray();
        for (int i = 0; i < stringChars.length; i++) {
            char currentChar = stringChars[i];
            if (currentChar >= 65 && currentChar <= 90) {
                currentChar  = (char) ((char) ((currentChar - 65 + k) % 26) + 65);
            } else if (currentChar >= 97 && currentChar <= 122) {
                currentChar  = (char) ((char) ((currentChar - 97 + k) % 26) + 97);
            }

            stringChars[i] = currentChar;
        }

        return new String(stringChars);
    }
}
