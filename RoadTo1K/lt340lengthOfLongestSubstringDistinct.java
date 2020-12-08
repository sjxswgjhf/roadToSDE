package RoadTo1K;

import java.util.HashMap;

public class lt340lengthOfLongestSubstringDistinct {

/*
比起dp，更像是sliding window

先移动右端点找到第一段为k distinct的window，然后用hashmap记录char跟对应的freq
然后移动左端点，直到有一个char的freq变成0，那么说明我们又可以补充一个char了

*/
    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            HashMap<Character, Integer> map = new HashMap<>();
            int max = 0;
            int l = 0, r = 0;
            while(r < s.length()){
                char c = s.charAt(r);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if(map.size() <= k)
                    max = Math.max(max, r - l + 1);
                while(map.size() > k){
                    char leftChar = s.charAt(l);
                    map.put(leftChar, map.get(leftChar) - 1);
                    if(map.get(leftChar) == 0){
                        map.remove(leftChar);
                    }
                    l++;
                }
                r++;
            }
            return max;
        }
    }
}
