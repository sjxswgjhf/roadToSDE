package binarysearch;

public class bs104removeingParentheses {

    class Solution {
        public int solve(String s) {
            int l = 0;
            int r = 0;
            for(int i = 0 ; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '('){
                    l++;
                }
                else if(c == ')' && l == 0){
                    r++;
                }else{
                    l--;
                }
            }
            return l + r;
        }
    }
}
