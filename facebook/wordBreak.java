package facebook;

import java.util.*;

public class wordBreak {

    public class Solution {
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordDictSet=new HashSet(wordDict);
            Queue<Integer> queue = new LinkedList<>();
            int[] visited = new int[s.length()];
            queue.add(0);
            while (!queue.isEmpty()) {
                int start = queue.remove();
                if (visited[start] == 0) {
                    for (int end = start + 1; end <= s.length(); end++) {
                        if (wordDictSet.contains(s.substring(start, end))) {
                            queue.add(end);
                            if (end == s.length()) {
                                return true;
                            }
                        }
                    }
                    visited[start] = 1;
                }
            }
            return false;
        }
    }

    class SolutionDP {
        /*
        applepenapple       apple pen
        apple T => penapple ? pen T => apple T True

        catsandog       cats dog sand and cat
        cats T => andog ? and T => og F  x
        cat T = > sandog? sand T => og F x
        */
        public boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            boolean[] dp = new boolean[n + 1];
            dp[0] = true;   //""
            HashSet<String> set = new HashSet<>();
            for(String word : wordDict){
                set.add(word);
            }
            for(int i = 1; i <= n; i++){
                for(int j = 0; j < i; j++){
                    //0~j is a word in dict && check j~i is a word or not
                    if(dp[j] && set.contains(s.substring(j, i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[n];
        }
    }

}
