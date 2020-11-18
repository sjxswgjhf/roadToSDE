package RoadTo1K;

public class lt125isPalindrome {

    class Solution {
        //只考虑数字跟字母
        public boolean isPalindrome(String s) {
            if(s == null || s.length() == 0){
                return true;
            }
            int len = s.length();
            int l = 0, r = len - 1;
            while(l < r){
                while(l < r && !Character.isLetterOrDigit(s.charAt(l))){
                    l++;
                }
                while(l < r && !Character.isLetterOrDigit(s.charAt(r))){
                    r--;
                }
                if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))){
                    return false;
                }else{
                    l++;
                    r--;
                }
            }
            return true;
        }
    }
}
