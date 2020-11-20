package RoadTo1K;

public class lt915partitionDisjoint {
    class Solution {
        /*
        1 2 5 0 3 9 8 6 7

        leftMax: 1 2 5 5 5 9 9 9 9 9
        rightMin: 0 0 0 0 3 6 6 6 7
        找个左右的分割点，保证左边的Max小于等于右边的MIN
        when leftMax is less than rightmin then left is good

        [5,0,3,8,6]
        5 5 5 8 8
        0 0 3 6 6
        */
        public int partitionDisjoint(int[] A) {
            int n = A.length;
            int[] leftMax = new int[A.length];
            for(int i = 0; i < n; i++){
                if(i == 0){
                    leftMax[i] = A[i];
                }else{
                    leftMax[i] = Math.max(A[i], leftMax[i - 1]);
                }
            }
            int[] rightMin = new int[A.length];
            for(int i = n - 1; i >= 0; i--){
                if(i == n - 1){
                    rightMin[i] = A[i];
                }else{
                    rightMin[i] = Math.min(A[i], rightMin[i + 1]);
                }
            }

            for(int i = 1; i < n; i++){
                if(leftMax[i - 1] <= rightMin[i]){
                    return i;
                }
            }
            return -1;
        }
    }
}
