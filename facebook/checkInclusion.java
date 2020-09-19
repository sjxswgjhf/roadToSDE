package facebook;

public class checkInclusion {
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
        /*
        sliding windown:
        check anagram
        */
            int m = s1.length(), n = s2.length();
            if(m > n){
                return false;
            }
            int[] s1Count = new int[26];
            int[] s2Count = new int[26];
            for(int i = 0; i < m; i++){
                s1Count[s1.charAt(i)-'a']++;
            }
            for(int i = 0; i < n; i++){
                s2Count[s2.charAt(i)-'a']++;
                if(i >= m){
                    s2Count[s2.charAt(i-m)-'a']--;
                }
                if(checkSame(s1Count, s2Count)){
                    return true;
                }
            }
            return false;
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
