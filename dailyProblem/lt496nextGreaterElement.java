package dailyProblem;

import java.util.HashMap;
import java.util.Stack;

public class lt496nextGreaterElement {
    class Solution {
        /*
        [1,3,4,2]
        Stack 只存num2的idx，map存对应的next greater number
        O(m+n)
        如果nums2 loop结束了，表示stack里面的数，没有next greater，那么就是对应-1

        */
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            HashMap<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            for(int i = 0 ; i < nums2.length; i++){
                if(stack.isEmpty() || nums2[stack.peek()] > nums2[i]){
                    stack.push(i);
                }
                else{
                    while(!stack.isEmpty() && nums2[stack.peek()] <= nums2[i]){
                        //map里存着数字跟对应的比他大的数
                        map.put(nums2[stack.pop()], nums2[i]);
                    }
                    stack.push(i);
                }
            }
            while(!stack.isEmpty()){
                map.put(nums2[stack.pop()], -1);
            }

            int[] res = new int[nums1.length];
            for(int i = 0; i < nums1.length; i++){
                res[i] = map.get(nums1[i]);
            }
            return res;
        }
    }
}
