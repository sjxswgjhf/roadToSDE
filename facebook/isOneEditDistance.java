package facebook;

public class isOneEditDistance {

    //就是一定要one diff，完全一样也是false,好蠢
    class Solution {
        public boolean isOneEditDistance(String s, String t) {
            if(s.length() > t.length()){
                return isOneEditDistance(t, s);
            }
            int m = s.length(), n = t.length();
            if(n - m > 1){
                return false;
            }
            for(int i = 0; i < m; i++){
                if(s.charAt(i) != t.charAt(i)){
                    if(m == n){
                        return s.substring(i + 1).equals(t.substring(i + 1));
                    }else{
                        return s.substring(i).equals(t.substring(i + 1));
                    }
                }
            }
            return (m + 1 == n);
        }

    }
}
