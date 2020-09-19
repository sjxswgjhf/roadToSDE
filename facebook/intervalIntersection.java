package facebook;

import java.util.ArrayList;
import java.util.List;

public class intervalIntersection {

    class Solution {
        public int[][] intervalIntersection(int[][] A, int[][] B) {
            int l = 0, r = 0;
            List<int[] > list = new ArrayList<>();
            while(l < A.length && r < B.length){
                int Astart = A[l][0];
                int Aend = A[l][1];
                int Bstart = B[r][0];
                int Bend = B[r][1];
                //A no join with B
                if(Aend < Bstart){
                    l++;
                }
                else if(Astart > Bend){
                    r++;
                }
                else{
                    int tmp = Math.max(Astart, Bstart);
                    if(Aend < Bend){
                        list.add(new int[]{tmp, Aend});
                        l++;
                    }else{
                        list.add(new int[]{tmp, Bend});
                        r++;
                    }
                }
            }
            int[][] res = new int[list.size()][2];
            for(int i = 0; i < list.size(); i++){
                res[i][0] = list.get(i)[0];
                res[i][1] = list.get(i)[1];
            }
            return res;
        }
    }

}
