package Bloomberg;

public class lt31nextPermutation {

    class Solution {

        /*
        从后往前找第一个decreasing的点，之后从后往前找到第一个比decreasing点大的那个数(后到前是increasing的，遇到的第一个就是)，然后跟desidx swap再把后面的翻转
        1234654321
        1235123446
        */
        public void nextPermutation(int[] nums) {
            int decIdx = nums.length - 2;
            while(decIdx >= 0){
                if(nums[decIdx] < nums[decIdx + 1]){
                    break;
                }else{
                    decIdx--;
                }
            }
            if(decIdx == -1){
                swap(nums, 0, nums.length - 1);
            }else{
                int j = nums.length - 1;
                while(j >= decIdx && nums[decIdx]  >= nums[j]){
                    j--;
                }
                int tmp = nums[decIdx];
                nums[decIdx] = nums[j];
                nums[j] = tmp;
                swap(nums, decIdx + 1, nums.length - 1);
            }
        }

        private void swap(int[] nums, int s, int e){
            while(s < e){
                int tmp = nums[s];
                nums[s] = nums[e];
                nums[e] = tmp;
                s++;
                e--;
            }
        }
    }
}
