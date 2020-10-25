package dailyProblem;

import java.util.Arrays;

public class lt805splitArraySameAverage {

    class Solution {
        /*
        We need to split A into B and C, the length of B can be [1, A.length / 2], we consider them one by one:
    B should have the same mean value as A, so sumB / lenOfB = sumA / lenOfA, which is equavalent to sumB = sumA * lenOfB / lenOfA. All elements here are integers, so sumB must be an integer, this gives our first criteria (sumA * lenOfB) % A.length == 0.
    Then further in function check(int[] A, int leftSum, int leftNum, int startIndex), we recursicely check if we can find lenOfB elements in A who sum up to sumB
        */
        public boolean splitArraySameAverage(int[] A) {
            if(A.length == 1){
                return false;
            }
            int sum = 0;
            Arrays.sort(A);
            for(int a : A){
                sum += a;
            }
            int n = A.length;
            for(int k = 1; k <= n / 2; k++){
                if((sum * k) % n == 0){
                    if(check(A, (sum * k) / n, k, 0)){
                        return true;
                    }
                }
            }
            return false;
        }

        private boolean check(int[] A, int sum, int k, int idx){
            if(k == 0){
                return sum == 0;
            }
            if((A[idx] > sum / k)){
                return false;
            }
            for(int i = idx; i < A.length - k + 1; i++){
                if(i > idx && A[i] == A[i-1]){
                    continue;
                }
                if(check(A, sum - A[i], k - 1, i + 1)){
                    return true;
                }
            }
            return false;
        }
    }


}
