package Bloomberg2;

import java.util.ArrayList;
import java.util.List;

public class lt535encodeString {

    public class Codec {

        List<String> list = new ArrayList<>();
        int id = 0;
        String pattern = "http://tinyurl.com/";
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            list.add(longUrl);
            return pattern+id++;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String s = shortUrl.replace(pattern, "");
            return list.get(Integer.parseInt(s));
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
}
