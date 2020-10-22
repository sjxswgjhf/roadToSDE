package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt442findDuplicates {

    class Solution {

    /*
    0 1 2 3 4 5 6 7
    4 3 2 7 8 2 3 1
    -4 3 2-7 8? 2? -3 -1
    这题难点是首先想到有dup的num，那么我们把每个num对应的idx的值变成负值，这样出现了一次的num对应的idx的值是负的，两次的就是正的。
    接下来的难点就是怎么避开一些没有的值，比如例子里面idx 5 6都没修改过，还是正的，怎么跟两次之后的区分开
    我们可以利用第一步的思想，还是利用array里面的数当前idx，如果当前数对应的idx是正的，说明dup了，加入到res，但是我们要避免重复加入，
    那么我们可以把这个对应idx的数改成负值，这样第二次遇到的时候成了负值，我们就可以避免重复加入了
    */

        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> res = new ArrayList<>();
            int n = nums.length;
            for(int i = 0; i < n; i++){
                int idx = Math.abs(nums[i]) - 1;
                nums[idx] *= -1;
            }
            for(int i = 0; i < n; i++){
                int idx = Math.abs(nums[i]) -1;
                if(nums[idx] > 0){
                    res.add(Math.abs(nums[i]));
                    nums[idx] *= -1;
                }
            }
            return res;
        }
    }
}
