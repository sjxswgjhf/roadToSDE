package weeklyContest;

public class lt1632wk213 {

    class Solution {
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            int idx = 0;
            while(idx < heights.length){
                if(idx < heights.length && heights[idx] >= heights[idx + 1]){
                    idx++;
                }
            }
            if(idx == heights.length){
                return idx;
            }
            int dif = 0;
            while(idx < heights.length){
                if(idx == heights.length - 1){
                    return idx;
                }
                dif = heights[idx + 1] - heights[idx];
                if(dif > bricks){
                    if(ladders == 0){
                        return idx;
                    }else{
                        idx++;
                        ladders--;
                    }
                }else{
                    bricks -= dif;
                    idx++;
                }
            }
            return idx;
        }
    }
}
