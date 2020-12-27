package BloombergOnsite;

public class lt162findPeakElement {

    class Solution {
        /*
        peak比左右都要大
        */
        public int findPeakElement(int[] nums) {
            int l = 0, r = nums.length - 1;
            while(l < r){
                int mid = l + (r - l)/2;
                //mid可能是解，但是可能是更前面12321的2的情况
                if(nums[mid] > nums[mid + 1]){
                    r = mid;
                }
                else{
                    //mid小于后面那个数的话，必然不是解了
                    l = mid + 1;
                }
            }
            return l;
        }
    }
}
