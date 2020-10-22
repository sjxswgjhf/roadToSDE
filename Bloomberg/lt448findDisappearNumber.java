package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt448findDisappearNumber {

    /*
    第一遍把所有遇到的num的对应的idx变成负值，当我们第二次去loop的时候，有的地方没变成负值的话就是没存在那个num
     */
    class Solution1Space {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            for(int i = 0; i < nums.length; i++){
                int idx = Math.abs(nums[i]) - 1;
                if(nums[idx] > 0){
                    nums[idx] = -nums[idx];
                }
            }
            List<Integer> res = new ArrayList<>();
            for(int i = 0; i < nums.length; i++){
                if(nums[i] > 0){
                    res.add(i + 1);
                }
            }

            return res;
        }
    }

    class SolutionNSpace {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            int[] count = new int[nums.length + 1];
            for(int num : nums){
                count[num]++;
            }
            List<Integer> list = new ArrayList<>();
            for(int i = 1 ; i <= nums.length; i++){
                if(count[i] == 0){
                    list.add(i);
                }
            }
            return list;
        }
    }
}
