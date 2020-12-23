package dailyProblem;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class lt159lengthOfLongestSubstringTwoDistinct {
    class Solution {
        public int lengthOfLongestSubstringTwoDistinct(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int l = 0;
            int max = 0;
//            Queue<Character> queue = new LinkedList<>();
            for(int r = 0; r < s.length(); r++){
                char c = s.charAt(r);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);
//                    queue.add(c);
                    max = Math.max(max, r - l + 1);
                }else{
                    if(map.size() < 2){
                        map.put(c, 1);
//                        queue.add(c);
                        max = Math.max(max, r - l + 1);
                    }else{
                        while(map.size() == 2){
//                            char old = queue.poll();
                            char old = s.charAt(l);
                            map.put(old, map.get(old) - 1);
                            if(map.get(old) == 0){
                                map.remove(old);
                            }
                            l++;
                        }
                        map.put(c, 1);
                    }
                }
            }
            return max;
        }
    }
}
