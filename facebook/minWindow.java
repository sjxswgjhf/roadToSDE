package facebook;

import java.util.HashMap;

public class minWindow {

    class Solution {
        public String minWindow(String s, String t) {
            if(s.length() < t.length()){
                return "";
            }
            int minLen = Integer.MAX_VALUE;
            HashMap<Character, Integer> counts = new HashMap<>();
            for(int i = 0 ; i < t.length() ; i++){
                counts.put(t.charAt(i), counts.getOrDefault(t.charAt(i), 0) + 1);
            }
            int required = counts.size();
            int formed = 0;
            int l = 0, r = 0;
            int resIdx = 0;
            for(r = 0; r < s.length(); r++){
                char c = s.charAt(r);
                Integer count = counts.get(c);
                if(count == null){
                    continue;
                }
                counts.put(c, count - 1);
                if(count == 1){
                    formed++;
                }
                while(formed == required){
                    if(minLen > r - l + 1){
                        minLen = r - l + 1;
                        resIdx = l;
                    }
                    char tmp = s.charAt(l++);
                    Integer tmpcount = counts.get(tmp);
                    if(tmpcount == null){
                        continue;
                    }
                    counts.put(tmp, tmpcount + 1);
                    if(tmpcount == 0){
                        formed--;
                    }
                }
            }
            return minLen == Integer.MAX_VALUE ? "" : s.substring(resIdx, resIdx + minLen);
        }
    }
}
