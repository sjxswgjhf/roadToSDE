package BloombergOnsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lt140wordBreakII {
    /*
    分割当前的string, 如果当前substring是在字典里面的，剩下的那些是不是在字典里，并构成的解是什么
    */
    class Solution {
        HashMap<String, List<String>> memo;
        public List<String> wordBreak(String s, List<String> wordDict) {
            HashSet<String> set = new HashSet<>();
            for(String word : wordDict){
                set.add(word);
            }
            memo = new HashMap<>();
            return helper(s, set);
        }

        private List<String> helper(String s, HashSet<String> set){
            if(s == null || s.length() == 0){
                return null;
            }
            if(memo.containsKey(s)){
                return memo.get(s);
            }
            List<String> res = new ArrayList<>();
            if(set.contains(s)){
                res.add(s);
            }
            for(int i = 1; i < s.length(); i++){
                String leftSub = s.substring(0, i);
                if(set.contains(leftSub)){
                    List<String> list = helper(s.substring(i), set);
                    for(String str : list){
                        res.add(leftSub+" " + str);
                    }
                }
            }
            memo.put(s, res);
            return memo.get(s);
        }
    }
}
