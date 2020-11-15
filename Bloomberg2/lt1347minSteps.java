package Bloomberg2;

import java.util.HashMap;

public class lt1347minSteps {

    class Solution {
        public int minSteps(String s, String t) {
            int[] count = new int[26];
            for(int i = 0; i < s.length(); i++){
                count[s.charAt(i) - 'a']++;
                count[t.charAt(i) - 'a']--;
            }
            int res = 0;
            for(int i : count){
                res += Math.abs(i);
            }
            return res/ 2;
        }
    }

    class SolutionSlow {
        public int minSteps(String s, String t) {
            HashMap<Character, Integer> map = new HashMap<>();
            for(char c : s.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            int res = 0;
            for(char c : t.toCharArray()){
                if(map.containsKey(c)){
                    map.put(c, map.get(c) - 1);
                }else{
                    res++;
                }
            }
            for(int val : map.values()){
                res += Math.abs(val);
            }
            return res/ 2;
        }
    }
}
