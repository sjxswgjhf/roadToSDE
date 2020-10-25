package weeklyContest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lt1630wk212 {
    /*
    这题就是看一个array能不能变成等差数列，那我们把array 排序了直接计算两两的difference，如果有不同的difference，就是false了
    如果这题改成abs diff一样的话，那么就需要用hashset这种来做了
    */

    class Solution {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            List<Boolean> res = new ArrayList<>();
            for(int i = 0; i < l.length; i++){
                int s = l[i];
                int e = r[i];

                int[] tmp = Arrays.copyOfRange(nums, s ,e + 1);
                Arrays.sort(tmp);
                int d = tmp[1] - tmp[0];
                boolean isValid = true;
                for (int j = 2; j < e - s + 1; j++){
                    if (tmp[j] - tmp[j-1] != d){
                        isValid = false;
                        res.add(false);
                        break;
                    }
                }
                if(isValid){
                    res.add(true);
                }
            }
            return res;
        }
    }
}
