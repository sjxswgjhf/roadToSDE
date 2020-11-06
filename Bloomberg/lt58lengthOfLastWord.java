package Bloomberg;

public class lt58lengthOfLastWord {
    class Solution {
        public int lengthOfLastWord(String s) {
            int r = s.length() - 1;
            while(r >= 0 && s.charAt(r) == ' '){
                r--;
            }
            int end = r;
            while(r >= 0 && s.charAt(r) != ' '){
                r--;
            }
            return end - r;
        }
    }
}
