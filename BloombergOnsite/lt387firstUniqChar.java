package BloombergOnsite;

public class lt387firstUniqChar {

    class Solution2ND {
        public int firstUniqChar(String s) {
            int[] count = new int[26];
            for(int i = 0; i < s.length(); i++){
                count[s.charAt(i) - 'a']++;
            }
            for(int i = 0; i< s.length(); i++){
                if(count[s.charAt(i) - 'a'] == 1){
                    return i;
                }
            }
            return -1;
        }
    }

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
