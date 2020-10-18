package Bloomberg;

public class moveZeros {

    class Solution {
        public void moveZeroes(int[] nums) {
            int l = 0, r = 0;
            while(r < nums.length){
                if(nums[r] != 0){
                    int tmp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = tmp;
                    l++;
                }
                r++;
            }
        }
    }

}
