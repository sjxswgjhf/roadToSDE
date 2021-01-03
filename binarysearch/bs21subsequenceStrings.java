package binarysearch;

public class bs21subsequenceStrings {

    class Solution {
        public boolean solve(String s1, String s2) {
            if(s1 == null || s1.length() == 0){
                return true;
            }
            int idx = 0;
            for(int i = 0; i < s2.length(); i++){
                if(idx < s1.length() && s1.charAt(idx) == s2.charAt(i)){

                    idx++;
                }
            }
            return idx == s1.length();
        }
    }
}
