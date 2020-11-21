package RoadTo1K;

public class lt908smallestRangeI {
    /*
    Dif 取决于最大最小值，
    变化K之后有多接近
     */
    class Solution {
        public int smallestRangeI(int[] A, int K) {
            int min = A[0];
            int max = A[0];
            for(int a : A){
                min = Math.min(a, min);
                max = Math.max(a, max);
            }
            if(max - min <= 2*K){
                return 0;
            }else{
                return max-min-2*K;
            }
        }
    }
}
