package RoadTo1K;

public class lt31nextPermutation {

    class Solution {

        /*
        从后往前找第一个decreasing的点，然后从decreasing的点往后找到仅比他大的数
        （这里可以从后往前，因为这样是increasing的，遇到的第一个就是，可以剩时间),找到后互换，然后decreasing点后面的翻转
        如果前面的decreasing点找不到，说明整个是321这样的，直接翻转整个
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
                reverse(nums, 0, nums.length - 1);
            }else{
                int j = nums.length - 1;
                while(j >= decIdx && nums[decIdx]  >= nums[j]){
                    j--;
                }
                int tmp = nums[decIdx];
                nums[decIdx] = nums[j];
                nums[j] = tmp;
                reverse(nums, decIdx + 1, nums.length - 1);
            }
        }

        private void reverse(int[] nums, int s, int e){
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
