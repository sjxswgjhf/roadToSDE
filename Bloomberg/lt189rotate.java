package Bloomberg;

public class lt189rotate {

    class Solution {

        /*
        n = 7, k = 3
        1 2 3 4 5 6 7 => 5 6 7 1 2 3 4

        5 6 7 1 2 3 4 => 7 6 5 1 2 3 4 => 7 6 5 4 3 2 1 => 1 2 3 4 5 6 7

        7 6 5 4 3 2 1
        5 6 7 4 3 2 1
        5 6 7 1 2 3 4

        */
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k = k % n;
            reverse(nums, 0, n - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, n - 1);
        }

        private void reverse(int[] nums, int s, int e){
            while(s < e){
                int tmp = nums[s];
                nums[s] = nums[e];
                nums[e] = tmp;
                s++;
                e--;
            }
        }
    }
}
