package RoadTo1K;

import java.util.Arrays;

public class lt628maximumProduct {

    class SolutionScan {
        /*
        排序之后看前两个是不是小于0，是的话就是前两个跟最后一个或者最后三个，不是的话就是最后三个
        */
        public int maximumProduct(int[] nums) {
            if(nums.length == 3){
                return nums[0] * nums[1]*nums[2];
            }
            int n = nums.length;
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            for(int num : nums){

                if(num <= min1){
                    min2 = min1;
                    min1 = num;
                }
                else if(num <= min2){
                    min2 = num;
                }

                if(num >= max1){
                    max3 = max2;
                    max2 = max1;
                    max1 = num;
                }
                else if(num >= max2){
                    max3 = max2;
                    max2 = num;
                }
                else if(num >= max3){
                    max3 = num;
                }
            }
            if(min1 < 0 && min2 < 0){
                return Math.max(min1 * min2 * max1, max1 * max2 * max3);
            }
            return max1 * max2 * max3;

        }
    }

    class SolutionSort {
        /*
        排序之后看前两个是不是小于0，是的话就是前两个跟最后一个或者最后三个，不是的话就是最后三个
        */
        public int maximumProduct(int[] nums) {
            if(nums.length == 3){
                return nums[0] * nums[1]*nums[2];
            }
            int n = nums.length;
            Arrays.sort(nums);
            if(nums[0] < 0 && nums[1] < 0){
                return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n-2] * nums[n-1]*nums[n-3]);
            }
            else{
                return nums[n-2] * nums[n-1]*nums[n-3];
            }
        }
    }
}
