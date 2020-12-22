package BloombergOnsite;

import java.util.Arrays;
import java.util.Random;

public class lt384shuffleArray {

    class Solution {

        int[] nums;
        Random rand;
        public Solution(int[] nums) {
            this.nums = nums;
            rand = new Random();
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }
        //return a val from l ~ r;
        private int randRange(int l, int r){
            return rand.nextInt(r - l) + l;
        }

        /*
        Knuth shuffle
        Fisher–Yates shuffle
        pi = n-1/n * n-2/n-1 *... * 1/n-i+1 = 1/n


         */
        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] tmp = Arrays.copyOf(nums, nums.length);
            for(int i = 0; i < nums.length; i++){
                //保证每个idx要swap一次，然后都要在范围内
                int idx = rand.nextInt(this.nums.length);
                //int idx = randRange(i, nums.length);
                swap(i, idx, tmp);
            }
            return tmp;
        }

        private void swap(int i, int j, int[] arr){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

}
