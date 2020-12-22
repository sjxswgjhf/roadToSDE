package BloombergOnsite;

public class lt387firstUniqChar {

    class Solution {
        public int firstUniqChar(String s) {
            if(s == null || s.length() == 0){
                return -1;
            }
            int[] counts = new int[26];
            for(char c : s.toCharArray()){
                counts[c-'a']++;
            }
            int res = -1;
            for(int i = 0; i < s.length(); i++){
                if(counts[s.charAt(i) - 'a'] == 1){
                    res = i;
                    break;
                }
            }
            return res;
        }
    }
}
