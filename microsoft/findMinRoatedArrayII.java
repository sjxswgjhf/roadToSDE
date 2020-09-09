package microsoft;

public class findMinRoatedArrayII {

    class SolutionBS {
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

    //duplicate allow
    class SolutionON {
        public int findMin(int[] nums) {
            for(int i = 1; i < nums.length; i++){
                if(nums[i] < nums[i-1]){
                    return nums[i];
                }
            }
            return nums[0];
        }
    }
}
