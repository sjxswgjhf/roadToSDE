package Bloomberg2;

import java.util.Arrays;

public class lt611triangleNumber {

    class SolutionN2 {
        /*
        2 2 3 4  = 3
        排序之后按最长的边开始枚举，另外两条边的和大于这条边的话，移动较长边，如果不满足条件，就移动较短边
        */
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            int n = nums.length;
            for(int c = n - 1; c >= 2; c--){
                int a = 0;
                int b = c - 1;
                while(a < b){
                    if(nums[a] + nums[b] > nums[c]){
                        res += b - a;
                        b--;
                    }else{
                        a++;
                    }
                }
            }
            return res;
        }
    }
    class SolutionN3 {
        /*
        2 2 3 4  = 3

        sort to avoid dup
        */
        public int triangleNumber(int[] nums) {
            Arrays.sort(nums);
            int res = 0;
            int n = nums.length;
            for(int i = 0; i < n - 2; i++){
                int side1 = nums[i];
                for(int j = i + 1; j < n - 1; j++){
                    for(int k = j + 1; k < n; k++){
                        int side2 = nums[j];
                        int side3 = nums[k];
                        if(side2 + side3 > side1 && side3 - side2 < side1){
                            res++;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
            return res;
        }
    }
}
