package Bloomberg;

import java.util.HashSet;
import java.util.List;

public class lt139wordBreak {


    class Solution {
        /*
        dp[i]:如果0~i是true的话，那么i~n在dict里面，那么dp[n]就是true
        即dp[j] = true and set.contains(j~i) dp[i] = true
        */
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            HashSet<String> set = new HashSet<>();
            for(String str : wordDict){
                set.add(str);
            }
            int n = s.length();
            for(int i = 1; i <= n; i++){
                for(int j = 0; j < i; j++){
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
