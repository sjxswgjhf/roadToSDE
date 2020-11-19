package RoadTo1K;

public class lt680validPalindrome {

    class Solution {
        public boolean validPalindrome(String s) {
            if(s == null || s.length() <= 1){
                return true;
            }
            int l = 0;
            int r = s.length() - 1;
            while(l < r){
                if(s.charAt(l) != s.charAt(r)){
                    String str1 = s.substring(l + 1, r+ 1);
                    String str2 = s.substring(l, r);
                    if(isPalin(str1) || isPalin(str2)){
                        return true;
                    }else{
                        return false;
                    }
                }
                else{
                    l++;
                    r--;
                }
            }
            return true;
        }

        private boolean isPalin(String s){
            if(s == null || s.length() <= 1){
                return true;
            }
            int l = 0;
            int r = s.length()-1;
            while(l < r){
                if(s.charAt(l) != s.charAt(r)){
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }

    class SolutionBAD {
        boolean deleted = false;
        public boolean validPalindrome(String s) {
            if(s == null || s.length() <= 1){
                return true;
            }
            int l = 0;
            int r = s.length() - 1;
            while(l < r){
                if(s.charAt(l) == s.charAt(r)){
                    l++;
                    r--;
                }
                else if(deleted == false){
                    //delete left
                    deleted = true;
                    boolean res1 = validPalindrome(s.substring(l + 1, r + 1));
                    boolean res2 = validPalindrome(s.substring(l, r));
                    return (res1 || res2);
                }else{
                    return false;
                }
            }
            return true;
        }
    }
}
