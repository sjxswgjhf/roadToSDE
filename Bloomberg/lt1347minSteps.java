package Bloomberg;

public class lt1347minSteps {
    class Solution {
        public int minSteps(String s, String t) {
            int res = 0;
            int[] counts = new int[26];
            for(int i = 0; i < s.length(); i++){
                counts[s.charAt(i)-'a']++;
                counts[t.charAt(i)-'a']--;
            }
            for(int i = 0 ; i < 26; i++){
                res += Math.abs(counts[i]);
            }
            return res / 2;
        }
    }
}
