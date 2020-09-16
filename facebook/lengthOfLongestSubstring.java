package facebook;

import java.util.HashMap;

public class lengthOfLongestSubstring {

    //prev: 跟踪先前遇到的重复的char，hashmap保存了所遇到的char的idx，当遇到重复的时候，要看这个重复的char的idx大还是prev的idx大
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            int n = s.length();
            int prev = 0;
            int res = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    prev = Math.max(prev, map.get(c));
                }
                res = Math.max(i - prev + 1, res);
                map.put(c, i + 1);
            }
            return res;
        }
    }
}
