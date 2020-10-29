package Bloomberg;

public class lt153findMin {

    class Solution1 {
        /*
        BS:
        5 6 7 8 1 2 3 4
        8 > 1
        1 is solition

        mid < mid + 1
        如果mid > start说明这段是increasing的
        nums[mid] > nums[mid + 1]

        */
        public int findMin(int[] nums) {
            int l = 0, r = nums.length - 1;
            while(l < r){
                int mid = l + (r - l) / 2;
                if(nums[mid] > nums[mid + 1]){
                    return nums[mid + 1];
                }
                else{
                    if(nums[mid] > nums[l]){
                        l = mid + 1;
                    }else{
                        r = mid;
                    }
                }
            }
            return nums[0];
        }
    }

    class Solution {
        public int findMin(int[] nums) {

            int start = 0, end = nums.length - 1;
            int mid = 0;
            while(start < end){
                mid = start + (end - start) / 2;
                if(nums[mid] > nums[end]){
                    start = mid + 1;
                }
                else if(nums[mid] < nums[end]){
                    end = mid;
                }else{
                    end--;
                }
            }
            return nums[start];
        }
    }
}
