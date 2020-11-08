package Bloomberg;

public class lt26removeDuplicates {

    class Solution {
        public int removeDuplicates(int[] nums) {
            int i = 0;
            int res = 1;
            for(int j = 1; j < nums.length; j++){
                if(nums[j] != nums[i]){
                    i++;
                    nums[i] = nums[j];
                    res++;
                }
            }
            return res;
        }
    }
}
