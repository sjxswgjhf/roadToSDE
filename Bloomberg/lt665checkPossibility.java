package Bloomberg;

public class lt665checkPossibility {

    /*
    因为只能改一次，当我们遇到一个decreasing的情况，我们有两种选择，一种是改变自己，一种是改变前一位，
    但是这个操作取决于再前一位数，如果再前一位也比自己大，那么我就改变自己，反之，改变前一个
     */
    class Solution {
        public boolean checkPossibility(int[] nums) {
            boolean find = false;
            for(int i = 1; i < nums.length; i++){
                if(nums[i] < nums[i - 1]){
                    if(find){
                        return false;
                    }
                    if(i < 2 || nums[i - 2] <= nums[i]){
                        nums[i - 1] = nums[i];
                        find = true;
                    }
                    if(i >= 2 && nums[i - 2] > nums[i]){
                        nums[i] = nums[i - 1];
                        find = true;
                    }
                }
            }
            return true;
        }
    }
}
