package Bloomberg;

public class searchInRotatedArray {

    /*
    通过mid跟start比较来确定哪段是increasing的，然后再通过跟target的判断来确定target的具体范围
     */
    class Solution {
        public int search(int[] nums, int target) {
            int n = nums.length - 1;
            int l = 0, r = n;
            while(l <= r){
                int mid = l + (r-l) / 2;
                if(nums[mid] == target){
                    return mid;
                }else{
                    if(nums[mid] >= nums[l]){
                        if(nums[mid] > target && target >= nums[l]){
                            r = mid - 1;
                        }else{
                            l = mid + 1;
                        }
                    }else{
                        if(nums[mid] < target && target <= nums[r]){
                            l = mid + 1;
                        }else{
                            r = mid - 1;
                        }
                    }
                }
            }
            return -1;
        }
    }
}
