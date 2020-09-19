package facebook;

import java.util.ArrayList;
import java.util.List;

public class subsets {


    class Solution2 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            //先加个空进去，然后根据这个空去构建所有接下来的subset，先加1，得到[][1],再加2，[][1][2][1,2],再加3,[][1][2][3][1,2][2,3][1,2,3]
            //1+2+3+[] = 7
            for(int num : nums){
                int size = res.size();
                for(int i = 0; i < size; i++){
                    List<Integer> list = new ArrayList<>(res.get(i));
                    list.add(num);
                    res.add(list);
                }
            }
            return res;
        }
    }

    class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            for(int i = 0; i <= nums.length; i++){
                helper(nums, 0, i, res, new ArrayList<>());
            }
            return res;
        }

        private void helper(int[] nums, int start, int len, List<List<Integer>> res, List<Integer> list){
            if(len == list.size()){
                res.add(new ArrayList<>(list));
                return;
            }
            for(int i = start; i < nums.length; i++){
                list.add(nums[i]);
                helper(nums, i + 1, len, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
