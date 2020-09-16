package facebook;

public class removeDuplicates {

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int i = 0;
            int res = 1;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    nums[i] = nums[j];
                    res++;
                }
            }
            return res;
        }
    }

    class Solution2 {
        //这题不需要替换，所以这个解法不推荐
        public int removeDuplicates(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            if(nums.length == 1){
                return 1;
            }
            int slow = 0, fast = 0;
            int res = 1;
            while(fast < nums.length){
                while(fast < nums.length && nums[slow] == nums[fast]){
                    fast++;
                }
                if(fast == nums.length){
                    break;
                }
                int tmp = nums[slow + 1];
                nums[slow + 1] = nums[fast];
                nums[fast] = tmp;
                slow++;
                fast++;
                res++;
            }
            return res;
        }
    }
}
