package RoadTo1K;

public class lt1299replaceElements {

    class Solution {

        public int[] replaceElements(int[] arr) {
            // Stack<Integer> stack = new Stack<>();

            int n = arr.length;
            int[] res = new int[n];
            res[n - 1] = -1;
            int max = arr[n - 1];
            for(int i = arr.length - 2; i >= 0; i--){
                res[i] = max;
                max = Math.max(arr[i], max);
            }
            return res;
        }
    }
}
