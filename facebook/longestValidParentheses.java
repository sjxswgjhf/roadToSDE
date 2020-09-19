package facebook;

public class longestValidParentheses {

    /*
    一维数组记录当前有效长度
    三种情况：
    1.()()()
    2.((()))
    3.()(())
    我们loop的时候就看),如果前一个是(那么我们就是case1，可以直接算dp[i]了 = dp[i-2]+2注意i<2的时候的情况
    如果前面不是(那么有可能是case2或3，先看前面那个dp[i-1]之前那个char是不是(,即要看i - dp[i-1]-1的idx 例如case2,在idx=4，dp[4]=2
    看idx = 4-2-1=1，是(,那么就是well formed，dp[i]=dp[i-1]+2
    但是我们要考虑case3，idx5的情况，虽然跟idx2well formed了，2+2 = 4， 但是应该结果是6，我们还要带上dp[1],那么我们就要看 i - dp[i-1]是不是大于2，
    前面还有没有东西先，然后有的话，我们dp[i] = dp[i - dp[i
     */
    class Solution {
        public int longestValidParentheses(String s) {
            if(s == null || s.length() <= 1)
                return 0;
            int n = s.length();
            int max = 0;
            int[] dp = new int[s.length()];
            for(int i = 1; i < s.length(); i++){
                if(s.charAt(i) == ')'){
                    //()()()
                    if(s.charAt(i - 1) == '('){
                        dp[i] = (i >= 2 ? dp[i-2] : 0) + 2;
                    }
                    //((()))
                    else if(i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '('){
                        dp[i] = dp[i - 1] + 2;
                        //()(())难点
                        if(i - dp[i] >= 1){
                            dp[i] += dp[i - dp[i]];
                        }
//                        if(i - dp[i - 1] >= 2){
//                            dp[i] += dp[i - dp[i-1] - 2];
//                        }
                    }
                    max = Math.max(dp[i], max);
                }
            }
            return max;
        }
    }

}
