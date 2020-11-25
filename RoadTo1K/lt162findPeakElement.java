package RoadTo1K;

public class lt162findPeakElement {

    class Solution {
        /*
        find the decreasing point
        */
        public int findPeakElement(int[] nums) {
            int l = 0;
            int r = nums.length - 1;

            while(l < r){
                int mid = l + (r - l) / 2;
                //这里不用担心越界问题，因为mid总是大于等于l的，mid+1总是存在
                if(nums[mid] > nums[mid + 1]){
                    r = mid;
                }else{
                    l = mid + 1;
                }

            }
            return l;
        }
    }
}
