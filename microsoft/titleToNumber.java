package microsoft;

public class titleToNumber {

    class Solution {
        public int titleToNumber(String s) {
            int ans = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                ans = ans * 26 + (c - 'A' + 1);
            }
            return ans;
        }
    }

}
