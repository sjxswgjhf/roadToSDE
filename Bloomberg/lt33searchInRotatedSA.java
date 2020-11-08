package Bloomberg;

public class lt33searchInRotatedSA {

    class Solution {
        public int search(int[] nums, int target) {
            int l = 0;
            int r = nums.length - 1;
            while(l <= r){
                int mid = l + (r - l) / 2;
                if(nums[mid] == target){
                    return mid;
                }else{
                    //mid~r is sorted
                    if(nums[mid] < nums[l]){
                        if(target > nums[mid] && target <= nums[r]){
                            l = mid + 1;
                        }else{
                            r = mid - 1;
                        }
                    }
                    //l~mid is sorted
                    else{
                        if(target >= nums[l] && target < nums[mid]){
                            r = mid - 1;
                        }else{
                            l = mid + 1;
                        }
                    }
                }
            }
            return -1;
        }
    }
}
