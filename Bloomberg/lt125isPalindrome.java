package Bloomberg;

public class lt125isPalindrome {

    class Solution {
        public boolean isPalindrome(String s) {
            if(s == null || s.length() == 0){
                return true;
            }
            int l = 0;
            int r = s.length() - 1;
            char[] cs = s.toCharArray();
            while(l < r){
                while(l < r && !Character.isLetterOrDigit(cs[l])){
                    l++;
                }
                while(l < r && !Character.isLetterOrDigit(cs[r])){
                    r--;
                }
                if(l < r && Character.toLowerCase(cs[l]) != Character.toUpperCase(cs[r])){
                    return false;
                }
                else{
                    l++;
                    r--;
                }
            }
            return true;
        }
    }
}
