package facebook;

public class longestPalindrome {


    class SolutionDP {
        public String longestPalindrome(String s) {
            if(s == null || s.length() == 0){
                return "";
            }
            int n = s.length();
            int max = 1;
            int startIdx = 0;
            boolean[][] isPalin = new boolean[n][n];
            isPalin[0][0] = true;
            for(int i = 0; i < n; i++){
                for(int j = i; j >= 0 ; j--){
                    if(i == j){
                        isPalin[j][i] = true;
                    }else{
                        if(s.charAt(i) == s.charAt(j)){
                            if(i - j == 1){
                                isPalin[j][i] = true;
                            }
                            else if(isPalin[j+1][i-1]){
                                isPalin[j][i] = true;
                            }
                            if(i - j + 1 > max && isPalin[j][i]){
                                max = i - j + 1;
                                startIdx = j;
                            }
                        }
                    }
                }
            }
            return s.substring(startIdx, startIdx + max);
        }
    }
}
