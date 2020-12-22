package dailyProblem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class lt3lengthOflongestSubstring {

    class SolutionMap {
        public int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int res = 0;
            int l = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(map.containsKey(c)){
                    l = Math.max(l, map.get(c) + 1);
                }
                map.put(c, i);
                res = Math.max(res, i - l + 1);
            }
            return res;
        }
    }

    class SolutionSet {
        public int lengthOfLongestSubstring(String s) {
            HashSet<Character> set = new HashSet<>();
            int res = 0;
            int l = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(set.contains(c)){
                    while(l <= i){
                        char old = s.charAt(l);
                        set.remove(old);
                        l++;
                        if(old == c){
                            break;
                        }
                    }
                }
                set.add(c);
                res = Math.max(res, i - l + 1);
            }
            return res;
        }
    }

    class SolutionQueue {
        public int lengthOfLongestSubstring(String s) {
            HashSet<Character> set = new HashSet<>();
            Queue<Character> queue = new LinkedList<>();
            int res = 0;
            int l = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(set.contains(c)){
                    while(!queue.isEmpty()){
                        char old = queue.poll();
                        set.remove(old);
                        l++;
                        if(old == c){
                            break;
                        }
                    }
                }
                queue.add(c);
                set.add(c);
                res = Math.max(res, i - l + 1);
            }
            return res;
        }
    }
}
