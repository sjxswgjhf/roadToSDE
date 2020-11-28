package RoadTo1K;

public class lt1053prevPermOpt1 {

    class Solution {

    /*
    next permutation: 从后往前找第一个decreasing的点，然后从decreasing的点往后找到第一个比他大的数，互换，然后decreasing点后面的翻转
    prev permutation：从后往前对于每个idx，往后找一个仅比它小的数替换，这样就是减小的最少
    虽然两道题的目的差不多，但是做法完全不一样,往前找一个permutation，只要从后往前，当前idx能从它往后找到一个仅比它小的数，互换之后，
    就是一个prev permutation,
    */

        public int[] prevPermOpt1(int[] A) {
            int n = A.length;
            for(int i = n - 1; i >= 0; i--){
                int idx = findNextSmaller(A, i);
                if(idx == -1){
                    continue;
                }else{
                    int tmp = A[i];
                    A[i] = A[idx];
                    A[idx] = tmp;
                    return A;
                }
            }
            return A;
        }

        private int findNextSmaller(int[] A, int idx){
            int candidate = -1;
            for(int i = idx + 1; i < A.length; i++){
                if(A[idx] > A[i]){
                    if(candidate == -1){
                        candidate = i;
                    }
                    else{
                        if(A[candidate] < A[i]){
                            candidate = i;
                        }
                    }
                }
            }
            return candidate;
        }
    }
}
