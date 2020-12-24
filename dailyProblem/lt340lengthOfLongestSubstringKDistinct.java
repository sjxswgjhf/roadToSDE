package dailyProblem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class lt340lengthOfLongestSubstringKDistinct {

    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            HashMap<Character, Integer> map = new HashMap<>();
            int l = 0;
            int max = 0;
            Queue<Character> queue = new LinkedList<>();
            for(int r = 0; r < s.length(); r++){
                char c = s.charAt(r);
                map.put(c, map.getOrDefault(c, 0) + 1);
                queue.add(c);
                if(map.size() <= k){
                    max = Math.max(max, r - l + 1);
                }
                while(!queue.isEmpty() && map.size() > k){
                    char old = queue.poll();
                    map.put(old, map.get(old) - 1);
                    if(map.get(old) == 0){
                        map.remove(old);
                    }
                    l++;
                }
            }
            return max;
        }
    }
}
