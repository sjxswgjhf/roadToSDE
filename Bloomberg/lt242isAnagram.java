package Bloomberg;

public class lt242isAnagram {

    class Solution {
        public boolean isAnagram(String s, String t) {
            int[] counts = new int[26];
            for(char c : s.toCharArray()){
                counts[c-'a']++;
            }
            for(char c : t.toCharArray()){
                if(counts[c-'a'] == 0){
                    return false;
                }else{
                    counts[c-'a']--;
                }
            }
            for(int i : counts){
                if(i != 0){
                    return false;
                }
            }
            return true;
        }
    }
}
