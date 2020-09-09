package microsoft;

public class removeDuplicates {

    class Solution {
        public int removeDuplicates(int[] nums) {
            int left = 0, right = 0;
            int res = 1;
            while(right < nums.length){
                if(left == right){
                    right++;
                }
                else{
                    while(nums[left] == nums[right]){
                        right++;
                        if(right == nums.length){
                            return res;
                        }
                    }
                    nums[left + 1] = nums[right];
                    left++;
                    right++;
                    res++;
                }
            }
            return res;
        }
    }

}
