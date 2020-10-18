package Bloomberg;

import java.util.HashMap;

public class subArraySum {

    /*
    从0~i的sum是n的话，如果我们要找一个subarray是k，那么如果存在j+1~i是k，那么0~j = sum - k,
    即我们只要看0~i里面有多少个sum - k，存在，那么以sum - k结尾的所有idx~i都能组成k
     */

    class SolutionOn {
        public int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int sum = 0;
            int ans = 0;
            for(int i = 0; i < nums.length; i++){
                sum += nums[i];
                if(map.containsKey(sum - k)){
                    ans += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return ans;
        }
    }

    class SolutionNN {
        public int subarraySum(int[] nums, int k) {
            int[] prefix = new int[nums.length + 1];
            prefix[0] = 0;
            for(int i = 1; i <= nums.length; i++){
                prefix[i] = prefix[i-1] + nums[i - 1];
            }
            int ans = 0;
            for(int i = 0; i < nums.length; i++){
                for(int j = i + 1; j <= nums.length; j++){
                    if(prefix[j] - prefix[i] == k){
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
}
