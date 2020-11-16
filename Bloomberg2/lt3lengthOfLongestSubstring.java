package Bloomberg2;

import java.util.HashMap;

public class lt3lengthOfLongestSubstring {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int l = 0;
            int res = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            //abcaefgbcbb
            for(int r = 0; r < s.length(); r++){
                if(map.containsKey(s.charAt(r))){
                    //用来确保左指针不会往回走, 因为这个重复的r可能是再len左边，我们没有去做那个操作移动左端点的操作
                    //l表示starting point，如果当前char是在l的左边，那么我们的l不需要变化，因为计算长度已经把他去掉了
                    //如果再l右边，那么我们计算长度时候需要的starting point是那个char+1,不能包含他
                    l = Math.max(l, map.get(s.charAt(r)) + 1);
                }
                res = Math.max(res, r - l + 1);
                map.put(s.charAt(r), r);
            }
            return res;
        }
    }

    class Solution2N {
        public int lengthOfLongestSubstring(String s) {
            int l = 0;
            int res = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            for(int r = 0; r < s.length(); r++){
                char c = s.charAt(r);
                if(!map.containsKey(c)){
                    map.put(c, r);
                    res = Math.max(r - l + 1, res);
                }
                else{
                    int idx = map.get(c);
                    while(l <= idx){
                        map.remove(s.charAt(l));
                        l++;
                    }
                    map.put(c, r);
                    res = Math.max(res, r - l + 1);
                }
            }
            return res;
        }
    }
}
