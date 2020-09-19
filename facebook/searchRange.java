package facebook;

public class searchRange {




    class SolutionON {
        public int[] searchRange(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while(l <= r && nums[l] != target){
                l++;
            }
            while(r >= l && nums[r] != target){
                r--;
            }
            if(l > r){
                return new int[]{-1, -1};
            }
            return new int[]{l, r};
        }
    }
}
