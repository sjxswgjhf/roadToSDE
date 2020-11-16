package Bloomberg2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lt139wordBreak {


    class SolutionBU{
        /*
        从后往前
        */
        public boolean wordBreak(String s, List<String> wordDict) {
            if(s == null || s.length() == 0){
                return true;
            }
            HashSet<String> set = new HashSet<>();
            for(String word : wordDict){
                set.add(word);
            }
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
        /*
         bottom up是从小到大.
         dp[i]是不是true，取决于有没有一个dp[j]是true，并且j~i的str是在set里面
        */
            for(int i = 1; i <= s.length(); i++){
                for(int j = 0; j < i; j++){
                    if(dp[j] && set.contains(s.substring(j, i))){
                        dp[i] = true;
                    }
                }
            }
            return dp[s.length()];
        }

    }





    class SolutionTopDown {
        /*
        从后往前
        */
        HashSet<String> set;
        HashMap<String, Boolean> map;
        public boolean wordBreak(String s, List<String> wordDict) {
            if(s == null || s.length() == 0){
                return true;
            }
            map = new HashMap<>();
            set = new HashSet<>();
            for(String word : wordDict){
                set.add(word);
            }
            return wordBreak(s);
        }

        private boolean wordBreak(String s){
            if(s == null || s.length() == 0){
                return true;
            }
            if(map.containsKey(s)){
                return map.get(s);
            }
            boolean res = false;
            int n = s.length();
            for(int j = s.length() - 1; j >= 0; j--){
                String word = s.substring(j, n);
                if(set.contains(word)){
                    if(wordBreak(s.substring(0, j))){
                        res = true;
                        break;
                    }
                }
            }
            map.put(s, res);
            return map.get(s);
        }
    }
}
