package facebook;

public class validPalindrome {

    class Solution {
        public boolean validPalindrome(String s) {
            int n = s.length();
            int l = 0, r = s.length() - 1;
            while(l < r){
                if(s.charAt(l) != s.charAt(r)){
                    //not include l
                    String str1 = s.substring(l + 1, r + 1);
                    //not include r
                    String str2 = s.substring(l, r);
                    if(isPalin(str1) || isPalin(str2)){
                        return true;
                    }else{
                        return false;
                    }
                }
                l++;
                r--;
            }
            return true;
        }

        private boolean isPalin(String s){
            int l = 0, r = s.length() - 1;
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

    class SolutionTLE {
        public boolean validPalindrome(String s) {
            int n = s.length();
            if(isPalin(s)){
                return true;
            }
            for(int i = 0; i < n; i++){
                String substr = s.substring(0, i) + s.substring(i + 1);
                if(isPalin(substr)){
                    return true;
                }
            }

            return false;
        }

        private boolean isPalin(String s){
            int l = 0, r = s.length() - 1;
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
}
