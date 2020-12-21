package BloombergOnsite;

public class lt153findMin {

    class Solution {
        /*

        首先找min in rotate就是找那个increasing 到 decreasing的点，
        不存在就说明没有rotate，返回left most，
        首先我们找到中间，然后判断中间的是不是大于后面一位，是的话就找到了，
        不是的话，
        我们看左边是不是小于mid，
        是的话，说明left~mid是递增的，那么我们要找的肯定在mid后面，移动l
        不是的话，那么说明 left~mid rotate了，我们要找的就在这里面，移动r,
        然后r要注意的是，mid要包含进来，因为mid可能是那个点，因为它是小于left的，
        BS:
        5 6 7 8 1 2 3 4
        8 > 1
        1 is solition

        mid < mid + 1
        如果mid > start说明这段是increasing的
        nums[mid] > nums[mid + 1]
        */
        public int findMin(int[] nums) {
            int n = nums.length;
            int l = 0, r = n - 1;
            while(l < r){
                //edge case: 0 1, mid = 0, mid + 1 = 1, 不会越界
                int mid = l + (r - l) / 2;
                if(nums[mid] > nums[mid + 1]){
                    return nums[mid + 1];
                }
                else if(nums[mid] > nums[l]){
                    l = mid + 1;
                }
                else{
                    r = mid;
                }
            }
            return nums[0];
        }
    }
}
