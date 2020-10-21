package Bloomberg;

import java.util.ArrayList;
import java.util.List;

public class lt658findClosestElement {

    class Solution {
        /*
        two pointer: 从头尾开始往中间走，比较两端跟x的差值，移动大的那端直到距离等于k
        */
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> res = new ArrayList<>();
            int l = 0;
            int r = arr.length - 1;
            while(r - l >= k){
                int ldif = Math.abs(arr[l] - x);
                int rdif = Math.abs(arr[r] - x);
                if(ldif > rdif){
                    l++;
                }else{
                    r--;
                }
            }
            for(int i = l; l <= r; l++){
                res.add(arr[l]);
            }
            return res;
        }
    }
}
