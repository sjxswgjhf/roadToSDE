package Bloomberg;

public class lt34searchRange {

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            if(nums == null || nums.length == 0){
                return new int[]{-1, - 1};
            }
            int[] res = new int[]{-1, -1};
            int left = binarySearch(nums, target);
            //找的是target的大的数，所以idx要-1，也保证了不存在target的时候left=right，right-1了之后比left小会返回-1-1
            int right = binarySearch(nums, target + 1) - 1;
            if(left <= right){
                return new int[]{left, right};
            }
            return new int[]{-1, - 1};
        }

        /*
        如果有target，那么pos肯定是最左边的target，如果没有target，那么pos肯定是那一位大于target的num的idx
        */
        private int binarySearch(int[] nums, int target){
            int l = 0;
            int r = nums.length - 1;
            int pos = nums.length;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(nums[mid] >= target){
                    pos = mid;
                    r = mid - 1;
                }else{
                    l = mid + 1;
                }
            }
            return pos;
        }
    }

}
