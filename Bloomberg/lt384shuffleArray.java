package Bloomberg;

import java.util.Arrays;
import java.util.Random;

public class lt384shuffleArray {

    class Solution {
        Random rand = new Random();
        int[] nums;
        public Solution(int[] nums) {
            this.nums = nums;
        }

        /** Resets the array to its original configuration and return it. */
        public int[] reset() {
            return nums;
        }

        private void swap(int i, int j, int[] array){
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }

        //return a val from l ~ r;
        private int randRange(int l, int r){
            return rand.nextInt(r - l) + l;
        }

        /** Returns a random shuffling of the array. */
        public int[] shuffle() {
            int[] array = Arrays.copyOf(nums, nums.length);
            for(int i = 0 ; i < array.length; i++){
                swap(i, randRange(i, nums.length), array);
            }
            return array;
        }
    }
/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
}
