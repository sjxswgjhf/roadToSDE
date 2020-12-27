package dailyProblem;

import java.util.HashMap;

public class lt992subarrayWithKDistinct {

    class Solution {
        //exact k = at most k - at most k - 1
        public int subarraysWithKDistinct(int[] A, int k) {
            return atMostK(A, k) - atMostK(A, k - 1);
        }

        private int atMostK(int[] A, int k){
            if(k == 0){
                return 0;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            int l = 0;
            for(int r = 0; r < A.length; r++){
                if(map.size() < k){
                    map.put(A[r], map.getOrDefault(A[r], 0) + 1);
                }
                else{
                    if(map.size() == k && map.containsKey(A[r])){
                        map.put(A[r], map.get(A[r]) + 1);
                    }else{
                        while(map.size() == k){
                            int old = A[l];
                            map.put(old, map.get(old) - 1);
                            if(map.get(old) == 0){
                                map.remove(old);
                            }
                            l++;
                        }
                        map.put(A[r], 1);
                    }
                }
                //计算之前的所有覆盖值是在最后计算，前面是维护k的size的map，然后到这再结算,就能覆盖所有case,在里面计算会比较混乱
                count += r - l + 1;
            }
            // System.out.println(count);
            return count;
        }

    }

/*
good subarry = set of subarray is k


0 1 2 3 4
1 2 1 2 3
1 2 2 2 3



数subarray的话，基本都是快慢指针，
1种是固定快指针了之后移动慢指针
另一只是固定了左指针，移动右指针，看最远到哪


1 2 1 2 3

12, 121, 1212,

*/
}
