package RoadTo1K;

import java.util.Stack;

public class lt1673mostCompetitive {

    class Solution {
        /*
        这题是要找一个size为k的最小增长序列，那么我们用monotonic stack来做，因为有个size为k的限制，
        我们不能无限制的pop掉所有比当前num大的val，我们要保证当前stack的size+剩下的nums能构成k才行.
        最后我们要注意stack是不是太多了，因为我们可能遇到一个很长的增长序列，所以我们要pop掉尾巴，
        这个pop不能在循环中做，因为会影响monotonic的性质
        */
        public int[] mostCompetitive(int[] nums, int k) {
            int n = nums.length;
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < n; i++){
                if(stack.isEmpty()){
                    stack.push(nums[i]);
                }
                else{
                    //stack不为空，并且top要大于num的时候，要注意剩下的能不能构成k了，行的话就pop，不行的话就留下
                    while(!stack.isEmpty() && nums[i] < stack.peek() && (stack.size() + (n - (i+1)))>=k){
                        stack.pop();
                    }
                    stack.push(nums[i]);
                }
            }
            //检查stack的size是不是大于k, 如果遇到一个数组是12345678那么stack也会有这么多，但是我们只要123，那么只要pop后面的就行
            while(stack.size() > k){
                stack.pop();
            }
            int[] res = new int[k];
            for(int i = k -1; i >= 0; i--){
                res[i] = stack.pop();
            }
            return res;
        }
    }
}
