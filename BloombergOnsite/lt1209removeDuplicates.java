package BloombergOnsite;

public class lt1209removeDuplicates {

    class Solution {
        public String removeDuplicates(String s, int k) {
            if(s == null || s.length() == 0){
                return "";
            }
            int l = 0;
            int r = 0;
            int n = s.length();
            while(r < n){
                int amount = 0;
                while(r < n && s.charAt(l) == s.charAt(r)){
                    amount++;
                    r++;
                    if(amount == k){
                        s = s.substring(0, l) + s.substring(r);
                        return removeDuplicates(s, k);
                    }
                }
                l = r;
            }
            return s;
        }
    }
}
