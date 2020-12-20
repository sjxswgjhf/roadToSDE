package BloombergOnsite;

import java.util.HashMap;
import java.util.HashSet;

public class lt3lengthOfLongestSubstring {

    class Solution2 {
        /*
        HashMap + Sliding Window

        */
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int l = 0;
            int r = 0;
            int n = s.length();
            int max = 0;
            while(r < n){
                if(map.containsKey(s.charAt(r))){
                    l = Math.max(l, map.get(s.charAt(r)) + 1);
                }
                max = Math.max(r - l + 1, max);
                map.put(s.charAt(r), r);
                r++;
            }
            return max;
        }
    }

    class Solution {
        /*
        HashSet + Sliding Window
        */
        public int lengthOfLongestSubstring(String s) {
            HashSet<Character> set = new HashSet<>();
            int l = 0;
            int r = 0;
            int n = s.length();
            int max = 0;
            while(r < n){
                while(r < n && !set.contains(s.charAt(r))){
                    set.add(s.charAt(r));
                    r++;
                }
                max = Math.max(max, r - l); //r is one position ahead, no need add 1
                set.remove(s.charAt(l));
                l++;
            }
            return max;
        }
    }
}
