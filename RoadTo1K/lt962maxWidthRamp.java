package RoadTo1K;

import java.util.Arrays;
import java.util.Stack;

public class lt962maxWidthRamp {

    /*
    6 0 8 2 1 5
    Stack 单调递减:
    Stack: 6 0
    之后从后往前:
    如果当前值比stack里面的大，那个更新max，也pop stack，因为我们已经保证了我们中间的所有数跟这个top的idx都是小于当前的width，
    没有意义，直接删掉stack的top，直到当前idx找到一个stack top的元素是大于它的，它不能往前找了,已经找到最大的width了
     */

    class Solution {
        public int maxWidthRamp(int[] A) {
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            for(int i = 0; i < A.length; i++){
                if(stack.isEmpty()){
                    stack.push(i);
                }
                else{
                    if(A[stack.peek()] > A[i]){
                        stack.push(i);
                    }
                }
            }
            for(int i = A.length - 1; i > max; i--){
                while(!stack.isEmpty() && A[stack.peek()] <= A[i]){
                    max = Math.max(max, i - stack.pop());
                }
            }
            return max;
        }
    }

    class SolutionNlogN {
        class Solution {
            /*
            用B array记录所有a对应的idx，然后根据A里面的val的值，来sort B的idx，
            A: [6,0,8,2,1,5]
                0 1 2 3 4 5
            B: 0 1 2 3 4 5 => 1 4 3 5 0 2

            然后遍历B array，用一个tmp去记录当前min的idx的位置,因为B是排序完的，所以当前idx的ramp是前面所有idx中最小的那个
            如果前面的idx有比当前idx小的，说明前面这个idx对应的值比idx小，而且还在idx前面，可以更新ramp，不然就不行
            a ramp of width i - min(indexes_previously_written)
            */
            public int maxWidthRamp(int[] A) {
                int n = A.length;
                Integer[] B = new Integer[n];
                for(int i = 0; i < n; i++){
                    B[i] = i;
                }

                Arrays.sort(B, (i, j) -> ((Integer) A[i]).compareTo(A[j]));
                int ans = 0;
                int prevMinIdx = n;
                for(int idx : B){
                    ans = Math.max(ans, idx - prevMinIdx);
                    prevMinIdx = Math.min(prevMinIdx, idx);
                }
                return ans;
            }
        }
    }
}
