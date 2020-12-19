package dailyProblem;

import java.util.HashMap;

public class lt1358numberOfSubstrings {

    class Solution {
        /*
        a b c a b c
        silding window + hashmap
        这题怎么计算有几个呢，当你形成了一个有效的substring，那么你这个有效的substring能构成的有效的解，是从 n - r + 1，
        比如abcabc，abc是有效的了，那么后面的都要加进去肯定都是有效的，那么就是n-r+1个了，
    */
        public int numberOfSubstrings(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int l = 0, r = 0;
            int res = 0;
            while(r < s.length()){
                char c = s.charAt(r);
                map.put(c, map.getOrDefault(c, 0) + 1);
                r++;
                while(map.size() >= 3){
                    res += s.length() - r + 1;
                    char tmp = s.charAt(l);
                    map.put(tmp, map.get(tmp) - 1);
                    if(map.get(tmp) == 0){
                        map.remove(tmp);
                    }
                    l++;
                }

            }
            return res;
        }
    }
}
