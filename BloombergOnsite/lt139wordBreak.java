package BloombergOnsite;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lt139wordBreak {

    class Solution {
        HashSet<String> set;
        HashMap<String, Boolean> map;
        public boolean wordBreak(String s, List<String> wordDict) {
            if(s == null){
                return true;
            }
            set = new HashSet<>();
            map = new HashMap<>();
            for(String word : wordDict){
                set.add(word);
            }
            if(set.contains(s)){
                return true;
            }
            return helper(s);
        }

        private boolean helper(String s){
            if(s == null || s.length() == 0){
                return true;
            }
            if(set.contains(s)){
                return true;
            }
            if(map.containsKey(s)){
                return map.get(s);
            }
            for(int i = 1; i <= s.length(); i++){
                String substr = s.substring(0, i);
                if(set.contains(substr)){
                    if(helper(s.substring(i))){
                        map.put(s, true);
                        return true;
                    }
                }
            }
            map.put(s, false);
            return false;
        }
    }
}
