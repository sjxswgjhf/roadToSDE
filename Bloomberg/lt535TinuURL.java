package Bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lt535TinuURL {

/*
现实中是用database来处理，后缀是primary key value，但是这题没有数据库，那么我们可以用hashcode来处理，当前可能存在collision的情况，
，所以让我想到了FKS，two level hashing，build是 expected O(n), query是O(1), space lv1 hash use n buckets(sum bi*bi < 4n),
lv2 use 8n at most, [bi]->[2bi*bi]
 */
    public class Codec {

        Map<Integer, String> map = new HashMap<>();
        String pattern = "http://tinyurl.com/";
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            int key = longUrl.hashCode();
            map.put(key, longUrl);
            return pattern + key;
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            String s = shortUrl.replace(pattern, "");
            return map.get(Integer.parseInt(s));
        }
    }

    public class Codec2 {

        List<String> list = new ArrayList<>();
        int i = 0;
        String pattern = "http://tinyurl.com/";
        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {
            list.add(longUrl);
            return pattern + i++;
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

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
}
