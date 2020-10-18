package Bloomberg;

import java.util.HashMap;

public class lengthOfLongestSubstring {
    class Solution {
        //sliding window
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int l = 0, r = 0;
            int res = 0;
            //abcabcbb
            while(r < s.length()){
                char c = s.charAt(r);
                if(map.containsKey(c)){
                    //用来确保左指针不会往回走
                    l = Math.max(l, map.get(c));
                }
                //这里为什么要+1,例如长度为1的情况，就一个char，如果只用r-l的话，给的是0，是不对的，所以要+1，
                res = Math.max(res, r - l + 1);
                //当上面的计算+1了，我们存
                map.put(c, r + 1);
                r++;
            }
            return res;
        }

    }
}
