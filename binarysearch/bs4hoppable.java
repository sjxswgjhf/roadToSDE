package binarysearch;

public class bs4hoppable {


    class SolutionBetter {
        public boolean solve(int[] nums) {
            int n = nums.length;
            int reachable = 0;
            for(int i = 0; i < n; i++){
                if(reachable < i){
                    break;
                }else{
                    reachable = Math.max(reachable, i + nums[i]);
                    if(reachable >= n-1){
                        break;
                    }
                }
            }
            return reachable >= n - 1;
        }
    }

    class Solution {
        public boolean solve(int[] nums) {
            int n = nums.length;
            boolean[] reachable = new boolean[n];
            reachable[0] = true;
            for(int i = 0; i < n; i++){
                if(reachable[i] == false){
                    break;
                }
                int hops = nums[i];
                for(int j = i + 1; j < n && j <= i + hops; j++){
                    reachable[j] = true;
                }
            }
            return reachable[n-1];
        }
    }
}
