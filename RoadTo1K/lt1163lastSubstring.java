package RoadTo1K;

import java.util.HashMap;
import java.util.List;

public class lt1163lastSubstring {

    class Solution {
        //24/24 Memory TLE
        public String lastSubstring(String s) {
            int n = s.length();
            String res = s;
            HashMap<Character, List<Integer>> map = new HashMap<>();
            char prev = s.charAt(0);
            int[] counts = new int[26];
            //n
            for(int i= 0; i < s.length(); i++){
                counts[s.charAt(i) - 'a']++;
            }

            int idx = 0;
            for(int i = 25; i >= 0; i--){
                if(counts[i] == s.length()){
                    return s;
                }
                if(counts[i] != 0){
                    idx = i;
                    break;
                }
            }
            char target = (char)(idx+'a');
            HashMap<Integer, String> submap = new HashMap<>();
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == target)
                    submap.put(i, s.substring(i));
            }
            //8 3
            for(int i = 0 ; i < s.length(); i++){
                if(s.charAt(i) == target){
                    String substr = submap.get(i);
                    if(substr.compareTo(res) > 0){
                        res = substr;
                    }
                }
            }
            return res;
        }
    }
}
