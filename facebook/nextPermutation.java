package facebook;

public class nextPermutation {
    //这题真的是巧秒，首先如果一个数不能找到下一个permutation的话，那么肯定是从大到小排列，也就是说如果一个数不是从大到小排列的话，就能找到permutation
    //那么我们就要找到从后往前第一个decreasing的地方，然后跟后面just larger这个数的数互换，然后把从这个数之后的全部倒一遍，我们就能找到结果
    class Solution {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while(i >= 0 && nums[i] >= nums[i + 1]){
                i--;
            }
            if(i >= 0){
                int j = nums.length - 1;
                while( j >= 0 && nums[i] >= nums[j]){
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);

        }

        private void reverse(int[] nums, int start){
            for(int i = start, j = nums.length - 1; i < j; i++, j--){
                swap(nums, i, j);
            }
        }

        private void swap(int[] nums, int i, int j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
