package dailyProblem;

import java.util.Stack;

public class lt1130mctFromLeafValues {

    /*
    先构建小的数，我们有一个数进来，如果当前数比顶部小就放到顶部，如果当前数比顶部的大， 我们需要把顶部的所有的比他小的数都构建掉，
    那么构建的花费怎么算，我们先把顶部pop出来，我们把pop的数*min(当前的数，新的顶部的数)，取一个小的，然后累积构建花费，再把当前数放入
    stack，最后的stack是个单调递增的stack，我们需要提前放入一块最大的挡板，maxvalue，最后处理了所有数字，我们还要把stack清空，
    构建花费是stack.pop()*stack.peek() while stack.size > 2,注意避开最后的挡板
     */
    public int mctFromLeafValues(int[] A) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : A) {
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }

    class Solution {
        /*
        6 2 4
        12
        20 4
        24

        36

        6 2 4

        6  8
            14
         20

        怎么构建才能最小呢，越大的数越晚构建，那么最后就越小，这样以后我们的cost肯定是小的，greedy思想
        这也就表示了我们的单调递增stack的方法可行

        */
        public int mctFromLeafValues(int[] arr) {
            int n = arr.length;
            int[][] memo = new int[n][n];
            return cost(arr, memo, 0, n - 1);
        }

        private int cost(int[] array, int[][] memo, int s, int e){
            if(memo[s][e] != 0){
                return memo[s][e];
            }
            if(s >= e){
                return 0;
            }

            int res = Integer.MAX_VALUE;
            //划分左右子树，注意k不能等于e，因为右子树不能为空，
            for(int k = s; k < e; k++){
                int leftMax = 0, rightMax = 0;
                for(int j = s; j <= k; j++){
                    leftMax = Math.max(leftMax, array[j]);
                }
                for(int j = k + 1; j <= e; j++){
                    rightMax = Math.max(rightMax, array[j]);
                }
                res = Math.min(res, leftMax * rightMax + cost(array, memo, s, k) + cost(array, memo, k + 1 , e));
            }
            memo[s][e] = res;
            return memo[s][e];
        }
    }
}
