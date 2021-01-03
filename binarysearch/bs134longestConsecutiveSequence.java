package binarysearch;

import java.util.HashMap;

public class bs134longestConsecutiveSequence {


    class Solution {
        public int solve(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int max = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                int num = nums[i];
                //避免重复计算，如果重复了会导致错误的结果
                if(!map.containsKey(num)){
                    int leftBound = map.getOrDefault(num - 1, 0);
                    int rightBound = map.getOrDefault(num + 1, 0);
                    int total = 1 + leftBound + rightBound;
                    map.put(num, total);
                    // update the leftMost value
                    if(leftBound != 0){
                        map.put(num - leftBound, total);
                    }
                    // update the rightMost value,注意一定要更新极值！犯错好几次了
                    if(rightBound != 0){
                        map.put(num + rightBound, total);
                    }
                    max = Math.max(max, total);
                }
            }
            return max;
        }
    }
}
