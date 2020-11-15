package Bloomberg2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lt140wordBreakII {

    class Solution {
        HashMap<String, List<String>> map;
        public List<String> wordBreak(String s, List<String> wordDict) {
            HashSet<String> set = new HashSet<>();
            map = new HashMap<>();
            for(String word : wordDict){
                set.add(word);
            }
            return helper(s, set);
        }

        private List<String> helper(String s, HashSet<String> set){
            List<String> res = new ArrayList<>();
            if(s == null || s.length() == 0){
                return res;
            }
            if(map.containsKey(s)){
                return map.get(s);
            }
            if(set.contains(s)){
                res.add(s);
            }
            for(int i = 1; i < s.length(); i++){
                String rightSub = s.substring(i);
                if(!set.contains(rightSub)){
                    continue;
                }
                String leftSub = s.substring(0, i);
                List<String> sublist = helper(leftSub, set);
                if(sublist.size() != 0){
                    for(String str : sublist){
                        res.add(str + " " + rightSub);
                    }
                }
            }
            map.put(s, res);
            return map.get(s);
        }

    }
}
