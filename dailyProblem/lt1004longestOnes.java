package dailyProblem;

public class lt1004longestOnes {

    /*
    当心cur = 0，然后r又移到了0的时候，这个时候不能更新
     */
    class Solution {
        public int longestOnes(int[] A, int K) {
            int l = 0, r = 0;
            int max = 0;
            int cur = K;
            while(r < A.length){
                while(r < A.length && cur >= 0){
                    if(cur > 0 || (cur == 0 && A[r] != 0))
                        max = Math.max(max, r - l + 1);
                    if(A[r] == 0){
                        cur--;
                    }
                    r++;
                }
                while(l <= r && cur < 0){
                    if(A[l] == 0){
                        cur++;
                    }
                    l++;
                }
            }
            return max;
        }
    }
}
