package Bloomberg;

import java.util.Arrays;

public class lt611triangleNumber {


    class SolutionBF {
        /*
        triangles: 两边之和大于第三边
        2 2 3 4
        2: the other two sum >= 3 and dif < 2
        avoid dup, 2 2 3 and 2 3 2  are same
        */
        public int triangleNumber(int[] nums) {
            int res = 0;
            Arrays.sort(nums);
            for(int i = 0; i < nums.length; i++){
                int side1 = nums[i];
                for(int j = i + 1; j < nums.length; j++){
                    for(int k = j + 1; k < nums.length; k++){
                        int side2 = nums[j];
                        int side3 = nums[k];
                        if(side2 + side3 > side1 && side3 - side2 < side1){
                            res++;
                        }else{
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }
}
