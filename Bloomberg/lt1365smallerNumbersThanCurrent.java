package Bloomberg;

public class lt1365smallerNumbersThanCurrent {

    class Solution {
        public int[] smallerNumbersThanCurrent(int[] nums) {
            int[] count = new int[101];
            for(int num : nums){
                count[num]++;
            }
            int[] tmp = new int[101];
            for(int i = 1 ; i < 101; i++){
                tmp[i] = tmp[i - 1] + count[i - 1];
            }
            int[] ans = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                ans[i] = tmp[nums[i]];
            }
            return ans;
        }
    }

}
