package microsoft;

public class longestPalindrome {



    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = new String();
        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                //single character
                if(i == j){
                    dp[i][j] = true;
                }
                //adjacent char
                else if(i - j == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    }
                }
                //check char i and j are same and i+1,j-1 are also palin
                else if(s.charAt(i) == s.charAt(j) && dp[i-1][j+1]){
                    dp[i][j] = true;
                }
                //update the longest
                if(dp[i][j] && i - j + 1 > res.length()){
                    res = s.substring(j, i + 1);
                }
            }
        }
        return res;
    }

    class Solution {
        public String longestPalindrome(String s) {
            if(s == null || s.length() == 0){
                return "";
            }
            String res = new String();
            for(int i = 0; i < s.length(); i++){
                String odd = findPalin(i, i, s);
                String even = findPalin(i, i + 1, s);
                String tmp = odd.length() > even.length() ? odd : even;
                if(tmp.length() > res.length()){
                    res = tmp;
                }
            }
            return res;
        }

        private String findPalin(int l, int r, String s){
            while(l >= 0 && r <= s.length() - 1){
                if(s.charAt(l) == s.charAt(r)){
                    l--;
                    r++;
                }else{
                    break;
                }
            }
            return s.substring(l + 1, r);
        }
    }
}
