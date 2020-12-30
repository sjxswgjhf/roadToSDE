package binarysearch;

public class bs18runlength {
    class Solution {
        public String solve(String s) {
            if(s == null || s.length() == 0){
                return "";
            }
            int l = 0;
            int r = 0;
            StringBuffer res = new StringBuffer();
            while(r < s.length()){
                int count = 0;
                l = r;
                while(r < s.length() && s.charAt(l) == s.charAt(r)){
                    r++;
                    count++;
                }
                res.append(count);
                res.append(s.charAt(l));
            }
            return res.toString();
        }
    }
}
