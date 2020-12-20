package BloombergOnsite;

import java.util.Arrays;
import java.util.HashMap;

public class lt128longestConsecutive {

    class Solution {
        /*
        用hashmap来找左右element存不存在，并更新最大值
        [100,4,200,1,3,2]
        map: {100, 1},{4, 4},{200,1}, {1, 4}, {3, 2}
        100: l = 0, r= 0, t= 1,
        4: l = 0, r = 0, t = 1,
        200: l= 0, r= 0 , t = 1,
        1: l = 0, r= 0; t = 1
        3: l = 0, r = 1, t = 2
        2: l = 1, r = 2, t = 4
        res = 4
        */
        public int longestConsecutive(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            int max = 1;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int num : nums){
                if(!map.containsKey(num)){
                    int left = map.getOrDefault(num - 1, 0);
                    int right = map.getOrDefault(num + 1, 0);
                    int sum = left + right + 1;
                    max = Math.max(max, sum);
                    if(left != 0){
                        //这里要更新boundary,不是邻值
                        map.put(num - left, sum);
                    }
                    if(right != 0){
                        map.put(num + right, sum);
                    }
                    map.put(num, sum);
                }
            }
            return max;
        }
    }
    /*
       class SolutionWrong {

           Sort,不行，因为1,0,2,1这种情况

        public int longestConsecutive(int[] nums) {
            if(nums.length == 0){
                return 0;
            }
            if(nums.length == 1){
                return 1;
            }
            Arrays.sort(nums);
            int len = 1;
            int r = 1;
            int l = 0;
            while(r < nums.length){
                while(r < nums.length && nums[r - 1] + 1 == nums[r]){
                    len = Math.max(len, r - l + 1);
                    r++;
                }
                l = r;
                r++;
            }
            return len;
        }
    }
     */
}
