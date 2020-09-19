package facebook;

import java.util.ArrayList;
import java.util.List;

public class findAnagrams {

    class Solution {

        /*
        sliding window
        */
        public List<Integer> findAnagrams(String s, String p) {
            int n = s.length(), m = p.length();
            if(n < m){
                return new ArrayList<>();
            }
            int[] scount = new int[26];
            int[] pcount = new int[26];
            for(int i = 0; i < m; i++){
                pcount[p.charAt(i)-'a']++;
            }
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < n; i++){
                scount[s.charAt(i)-'a']++;
                if(i >= m){
                    scount[s.charAt(i-m)-'a']--;
                }
                if(checkSame(scount, pcount)){
                    res.add(i - m + 1);
                }
            }
            return res;
        }

        private boolean checkSame(int[] scount, int[] pcount){
            for(int i = 0; i < 26; i++){
                if(scount[i] != pcount[i]){
                    return false;
                }
            }
            return true;
        }
    }
}
