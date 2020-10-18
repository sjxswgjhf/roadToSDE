package IBM;

import java.util.Arrays;

public class Triplets {

    public long triplets(int[] nums, int target){
        long res = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            int l = 0;
            int r = nums.length - 1;
            while(l < r){
                if(nums[l] + nums[r] + nums[i] <= target){
                    res += (r - l);
                    l++;
                }else{
                    r--;
                }
            }
        }
        return res;
    }
}
