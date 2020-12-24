package BloombergOnsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lt140wordBreakII {
    class SolutionSecond {

        HashSet<String> set;
        HashMap<String, List<String>> map;

        public List<String> wordBreak(String s, List<String> wordDict) {
            if(s == null){
                return new ArrayList<>();
            }
            set = new HashSet<>();
            for(String word : wordDict){
                set.add(word);
            }
            map = new HashMap<>();
            return helper(s);
        }

        private List<String> helper(String s){
            if(s == null || s.length() == 0){
                return null;
            }
            if(map.containsKey(s)){
                return map.get(s);
            }
            //res 存了当前s的解
            List<String> res = new ArrayList<>();
            //如果字典里有了s，加入当前的解
            if(set.contains(s)){
                res.add(s);
            }
            //遍历s的substring，找别的解
            for(int i = 1; i < s.length(); i++){
                //左半边在set里面的话，我们递归求解右半部分的list，返回的substring跟左半部分合起来，就是当前s的所有解
                String substr = s.substring(0, i);
                if(set.contains(substr)){
                    List<String> tmp = helper(s.substring(i));
                    for(String str : tmp){
                        res.add(substr+" "+str);
                    }
                }
            }
            map.put(s, res);
            return res;
        }
    }


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
