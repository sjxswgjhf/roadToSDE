package Bloomberg;

import java.util.HashMap;

public class lt3lengthOfLongestSubstring {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int l = 0;
            int r = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            int n = s.length();
            int res = 0;
            while(r < n){
                while(r < n && !map.containsKey(s.charAt(r))){
                    map.put(s.charAt(r), r);
                    res = Math.max(res, r - l + 1);
                    r++;
                }
                if(r == n){
                    break;
                }
                int tmp = map.get(s.charAt(r)) + 1;
                while(l < tmp){
                    map.remove(s.charAt(l));
                    l++;
                }
                map.put(s.charAt(r), r);
                r++;
            }
            return res;
        }
    }
}
