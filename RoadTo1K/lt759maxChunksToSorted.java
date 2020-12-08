package RoadTo1K;

public class lt759maxChunksToSorted {

    class Solution {
        /*
        能独立排序的只有在对应的num这个idx上，并且要保证的是，前面没有大于这个num的数，不然不可以，
        因为这个数要属于大的数的chunk
        也就是只有max的数对应的idx是一样的时候，我们才能把他当做一个chunk
        max == i => chunk++
        */
        public int maxChunksToSorted(int[] arr) {
            int res = 0;
            int max = 0;
            for(int i = 0; i < arr.length; i++){
                max = Math.max(max, arr[i]);
                if(max == i){
                    res++;
                }
            }
            return res;
        }
    }

}
