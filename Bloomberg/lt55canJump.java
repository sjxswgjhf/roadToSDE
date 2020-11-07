package Bloomberg;

public class lt55canJump {


    class Solution {
        /*
        [3,2,1,0,4]
         0 1 2 3 4
        reach = 4 3 2
        */
        public boolean canJump(int[] nums) {
            if(nums.length == 1){
                return true;
            }
            int reach = nums[0];
            for(int i = 1 ; i < nums.length; i++){
                if(reach == 0){
                    return false;
                }
                if(reach >0 && i == nums.length - 1){
                    return true;
                }
                reach--;
                if(nums[i] > reach){
                    reach = nums[i];
                }
            }
            return reach > 0 ? true : false;
        }
    }

    class SolutionSlow {

    /*
    [2,3,1,1,4]
    */

        public boolean canJump(int[] nums) {
            boolean[] reach = new boolean[nums.length];
            reach[0] = true;
            for(int i = 0; i < nums.length; i++){
                if(reach[i] == false){
                    return false;
                }
                int jump = nums[i];
                for(int j = i + 1; j <= jump + i && j < nums.length; j++){
                    reach[j] = true;
                    if(reach[nums.length - 1] == true){
                        return true;
                    }
                }
            }
            return reach[nums.length - 1];
        }
    }
}
