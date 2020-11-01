package Bloomberg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lt90SubsetsII {

    /*
    backtracking:
    先排序了之后，backtracking，从0开始加，先把[]加进去，然后loop，从idx=开始，避免重复需要看当前的idx是不是跟前面的idx一样，是的话就
    跳过，这里是因为我们只要同一个num的开头或者加入到之前的lists里面，不需要下一个同样的去加了，会产生重复，122的话，第一个2跟前面的[],[1]
    形成了新的。后面的第二个2就不需要再跟[],[1]配对了，当backtracking到下一层的时候，第二个2会跟[],[1],[1,2],[2]去组合成新的
     */
    class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> list = new ArrayList<>();
            helper(nums, res, list, 0);
            return res;
        }

        private void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int idx){

            res.add(new ArrayList<>(list));
            for(int i = idx; i < nums.length; i++){
                if(i != idx && nums[i] == nums[i - 1]){
                    continue;
                }
                list.add(nums[i]);
                helper(nums, res, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
