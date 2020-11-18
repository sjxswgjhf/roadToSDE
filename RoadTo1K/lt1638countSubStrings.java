package RoadTo1K;

public class lt1638countSubStrings {

    class Solution {
        /*
        以i，j不同的时候为核心，我们向外扩展，如果左右的char相同就继续，不同就停止，最后组合数是长度相乘

        x [x x i x x] x
        [y y j y y] y
        组合数 (2+1)*(2+1) = 9

        for i ...
            for j ...
                if i != j
                    extend
        这样的话是n^3的做法，extend还要是O(n)，那么我们如果提前知道了当前i，jpair的左右相同长度，我们就可以用o(1)来做了，这个就是动态规划
        dp[i][j] = i == j ? dp[i-1][j-1]+1:0
        */
        public int countSubstrings(String s, String t) {
            int m = s.length();
            int n = t.length();
            s = "#" + s + "#";
            t = "#" + t + "#";
            int[][] left = new int[m + 2][n + 2];
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(s.charAt(i) == t.charAt(j)){
                        left[i][j] = left[i-1][j-1] + 1;
                    }else{
                        left[i][j] = 0;
                    }
                }
            }
            int[][] right = new int[m + 2][n + 2];
            for(int i = m; i >= 1; i--){
                for(int j = n; j >= 1; j--){
                    if(s.charAt(i) == t.charAt(j)){
                        right[i][j] = right[i + 1][j + 1] + 1;
                    }else{
                        right[i][j] = 0;
                    }
                }
            }
            int count = 0;
            for(int i = 1; i <= m; i++){
                for(int j = 1; j <= n; j++){
                    if(s.charAt(i) != t.charAt(j)){
                        count += (left[i - 1][j - 1] + 1) * (right[i + 1][j + 1] + 1);
                    }
                }
            }
            return count;
        }
    }


    class SolutionBF {
        /*
        计数，s跟t中的所有substring，差为1的
        Brute Froce，我们直接从长度1开始判断，当前是不是
        */
        public int countSubstrings(String s, String t) {
            int m = s.length();
            int n = t.length();
            int count = 0;
            // l * m * n * l
            for(int l = 1; l <= Math.min(m, n); l++){
                for(int i = 0; i < m - l + 1; i++){
                    String strs = s.substring(i, i + l);
                    for(int j = 0; j < n - l + 1; j++){
                        String strt = t.substring(j, j + l);
                        if(checkDif(strs, strt)){
                            count++;
                        }
                    }
                }
            }
            return count;
        }

        private boolean checkDif(String s1, String s2){
            int dif = 0;
            for(int i = 0; i < s1.length(); i++){
                if(s1.charAt(i) != s2.charAt(i)){
                    dif++;
                    if(dif >= 2){
                        return false;
                    }
                }
            }
            return dif == 1;
        }
    }
}
