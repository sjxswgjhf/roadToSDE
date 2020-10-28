package Bloomberg;

public class lt287findDuplicate {


    class Solution {
        /*
        HashSet: O(n) O(n)

        two pointer to find cycle:

        1 3 4 2 2
        s:1 3 2 4
        f:3 4 4 4
        这题最优解是快慢指针找入口，一般是hashset，naive是双重循环
        */
        public int findDuplicate(int[] nums) {
            int n = nums.length - 1;
            int slow = nums[0];
            int fast = nums[nums[0]];
            while(slow != fast){
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            fast = 0;
            while(slow != fast){
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
    }
}
