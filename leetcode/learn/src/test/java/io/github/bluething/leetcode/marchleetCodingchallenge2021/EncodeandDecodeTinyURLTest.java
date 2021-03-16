package io.github.bluething.leetcode.marchleetCodingchallenge2021;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class EncodeandDecodeTinyURLTest {

    @Test
    public void successWhenInputIsRight() {
        Codec codec = new Codec();
        Assert.assertEquals("https://leetcode.com/problems/design-tinyurl",
                codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
    }

    class Codec {
        Map<String, String> shortUrlDB = new HashMap<>();
        Map<String, String> cacheOriUrlDB = new HashMap<>();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            if (cacheOriUrlDB.containsKey(longUrl)) {
                return cacheOriUrlDB.get(longUrl);
            }

            UUID uuid = UUID.randomUUID();
            while (shortUrlDB.containsKey(uuid.toString().substring(6))) {
                uuid = UUID.randomUUID();
            }
            String uniqueId = uuid.toString().substring(6);
            String shortUrl = "http://tinyurl.com/" + uniqueId;
            shortUrlDB.put(shortUrl, longUrl);
            cacheOriUrlDB.put(longUrl, shortUrl);

            return shortUrl;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return shortUrlDB.get(shortUrl);
        }
    }
}
