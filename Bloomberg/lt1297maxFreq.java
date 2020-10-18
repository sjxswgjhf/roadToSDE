package Bloomberg;

import java.util.HashMap;
import java.util.HashSet;

public class lt1297maxFreq {

    /*
    为啥只要看minSize就行，因为substring的occurrence最高的话，这个minSize的substring肯定会包含在里面
     */
    class Solution {
        public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
            int res = 0;
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i <= s.length() - minSize; i++){
                String substr = s.substring(i, i + minSize);
                if(check(substr, maxLetters)){
                    map.put(substr, map.getOrDefault(substr, 0) + 1);
                    res = Math.max(res, map.get(substr));
                }
            }
            return res;
        }

        private boolean check(String s, int max){
            HashSet<Character> set = new HashSet<>();
            for(char c : s.toCharArray()){
                set.add(c);
                if(set.size() > max){
                    return false;
                }
            }
            return true;
        }
    }

    class SolutionBF{
        class Solution {
            public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
                int res = 0;
                HashMap<String, Integer> map = new HashMap<>();

                for(int j = minSize; j <= maxSize; j++){
                    for(int i = 0; i <= s.length() - j; i++){
                        String substr = s.substring(i, i + j);
                        if(check(substr, maxLetters)){
                            map.put(substr, map.getOrDefault(substr, 0) + 1);
                            res = Math.max(res, map.get(substr));
                        }
                    }
                }

                return res;
            }

            private boolean check(String s, int max){
                HashSet<Character> set = new HashSet<>();
                for(char c : s.toCharArray()){
                    set.add(c);
                    if(set.size() > max){
                        return false;
                    }
                }
                return true;
            }
        }
    }
}
