package goldmansachs;

public class countSubStrings {

    //lt647
    class SolutionExpand {
        public int countSubstrings(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            int n = s.length();
            int res = 0;
            for(int i = 0 ; i < n; i++){
                res += expand(s, i, i);
                res += expand(s, i, i + 1);
            }
            return res;
        }

        private int expand(String s, int l, int r){
            int count = 0;
            while(l>=0 && r < s.length()){
                if(s.charAt(l) != s.charAt(r)){
                    break;
                }
                l--;
                r++;
                count++;
            }
            return count;
        }
    }
    //lt 647
    /*
    从长度1开始看i跟j是不是一样，是的话看i+1到j-1是不是palin，是的话就是true，或者j-i<=2,为什么不是2，因为长度为3的时候，左右一样的话也是palin
     */
    class SolutionDP {
        public int countSubstrings(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            int n = s.length();
            boolean[][] dp = new boolean[n][n];
            int res = 0;
            for(int l = 1; l <= n; l++){
                for(int i = 0; i <= n - l; i++){
                    int j = i + l - 1;
                    if(s.charAt(i) == s.charAt(j)){
                        if(j - i < 2){
                            dp[i][j] = true;
                        }else{
                            dp[i][j] = dp[i+1][j-1];
                        }
                    }
                    if(dp[i][j]){
                        res++;
                    }
                }
            }
            return res;
        }
    }
}
