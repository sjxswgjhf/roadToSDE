package dailyProblem;

import java.util.Arrays;

public class lt473makesquare {

    class SolutionDFS {
        /*
        要make square也就是要有四组数的和一样，那么所有数的sum必须被4整除。然后还能拆分成4份
        也就是说我们每份的target就是sum/4
        我们做dfs，需要一个sum去累积当前的值，然后 我们需要一个count去记录已经找到几份了，然后一组used去记录所有使用的数
        当我们target = sum的时候我们就去找下一组数，重置sum，累积count，最后count = target就是对的
        没优化的话就是TLE了
        然后是优化
        1. 我们需要记录idx的位置，当前count的循环，如果我们已经访问过的数字不需要再访问了，如果不继续一直从头开始的话会产生大量重复
        计算，所以我们需要一个idx去记录当前到哪了，下次应该是从下一位开始做循环。 TLE -> 9ms
        2. 来sort一下，因为有重复的数字，当我们从一个数字开始，如果前一个数字跟它相同并没有使用，那么我们
        就跳过，避免重复计算。TLE -> 172ms
        把1跟2优化合起来： TLE -> 1ms
         */
        public boolean makesquare(int[] nums) {
            if(nums == null || nums.length <= 3){
                return false;
            }
            int sum = 0;
            for(int num : nums){
                sum += num;
            }
            if(sum % 4 != 0){
                return false;
            }
            Arrays.sort(nums);
            boolean[] used = new boolean[nums.length];
            return helper(nums, sum / 4, 0, 0, 1, used);
        }

        private boolean helper(int[] nums, int target, int sum, int pos, int count, boolean[] used){
            if(count == 4){
                return true;
            }
            if(sum > target){
                return false;
            }
            if(target == sum){
                return helper(nums, target, 0, 0, count + 1, used);
            }
            for(int i = pos; i < nums.length; i++){
                if(used[i]){
                    continue;
                }
                if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                    continue;
                }
                used[i] = true;
                if(helper(nums, target, sum + nums[i], i + 1, count, used)){
                    return true;
                }
                used[i] = false;
            }
            return false;
        }

    }
}
