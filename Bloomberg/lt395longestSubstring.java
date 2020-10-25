package Bloomberg;

public class lt395longestSubstring {

    class Solution {
    /*
    aaabb k = 3



    */

        public int longestSubstring(String s, int k) {
            int res = 0;
            if(s == null || s.length() == 0){
                return 0;
            }
            int[] count = new int[26];
            for(int i = 0; i < s.length(); i++){
                count[s.charAt(i) - 'a']++;
            }
            boolean isValid = true;
            for(int i = 0; i < 26; i++){
                if(count[i] != 0 && count[i] < k){
                    isValid = false;
                    break;
                }
            }
            if(isValid){
                return s.length();
            }
            int l = 0, r = 0;
            while(r < s.length()){
                if(count[s.charAt(r) - 'a'] < k){
                    res = Math.max(res, longestSubstring(s.substring(l, r), k));
                    l = r + 1; // ignore invalid char
                }
                r++;
            }
            res = Math.max(res, longestSubstring(s.substring(l), k));
            return res;
        }
    }
}
