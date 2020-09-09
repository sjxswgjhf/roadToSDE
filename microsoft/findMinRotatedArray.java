package microsoft;

public class findMinRotatedArray {

    //通用解
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
                // when num[mid] and num[hi] are same
                end--;
            }
        }
        return nums[start];
    }

    class SolutionBS {

        //因为没有dup，所以bs有三种情况，首先就是当前的比前一个小，那么直接就是ans
        //第二个如果中间的比首尾都大，那么ans就应该再右边
        //剩下的情况ans都在左边， 中间的比首大尾小，即12345， 中间的比首小尾小561234
        public int findMin(int[] nums) {
            if(nums.length == 1){
                return nums[0];
            }
            int start = 0, end = nums.length - 1;
            while(start < end){
                int mid = (start + end) / 2;
                if(mid > 0 && nums[mid] < nums[mid-1]){
                    return nums[mid];
                }
                if(nums[start] <= nums[mid] &&nums[mid] > nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            return nums[start];
        }
    }

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
