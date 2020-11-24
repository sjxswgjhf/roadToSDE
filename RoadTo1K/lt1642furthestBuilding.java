package RoadTo1K;

import java.util.PriorityQueue;

public class lt1642furthestBuilding {

    class SolutionLee {
        /*
        [4,2,7,6,9,14,12]   b = 5   l = 1

        4 2 7 6 9

        [4,12,2,7,3,18,20,3,19] 10 2

        idea 尽可能把ladder给大的height用，bricket给小的用
        也就是说我们先用所有的ladder，如果后面的height小于最小的前面的高度，我们就用brick，
        不然就把最小的高度pop出来用brick，这个高度用梯子，知道石头也用完
        */
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int steps = 0;
            for(int i = 1; i < heights.length; i++){
                int d = heights[i] - heights[i - 1];
                if(d <= 0){
                    steps++;
                    continue;
                }
                pq.add(d);
                if(pq.size() > ladders){
                    bricks -= pq.poll();
                }
                if(bricks < 0){
                    return steps;
                }
                steps++;
            }
            return steps;
        }
    }

    class Solution {
        /*
        [4,2,7,6,9,14,12]   b = 5   l = 1

        4 2 7 6 9

        [4,12,2,7,3,18,20,3,19] 10 2

        idea 尽可能把ladder给大的height用，bricket给小的用
        也就是说我们先用所有的ladder，如果后面的height小于最小的前面的高度，我们就用brick，
        不然就把最小的高度pop出来用brick，这个高度用梯子，知道石头也用完
        */
        public int furthestBuilding(int[] heights, int bricks, int ladders) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int steps = 0;
            for(int i = 1; i < heights.length; i++){
                if(heights[i] <= heights[i - 1]){
                    steps++;
                    continue;
                }
                int d = heights[i] - heights[i-1];
                if(pq.size() < ladders){
                    steps++;
                    pq.add(d);
                }
                else{
                    if(!pq.isEmpty() && d <= pq.peek()){
                        if(bricks < d){
                            return steps;
                        }else{
                            bricks -= d;
                            steps++;
                        }
                    }else{
                        if(pq.isEmpty()){
                            if(bricks >= d){
                                bricks -= d;
                                steps++;
                            }else{
                                return steps;
                            }
                        }else{
                            int need = pq.poll();
                            if(bricks < need){
                                return steps;
                            }else{
                                bricks -= need;
                                steps++;
                            }
                            pq.add(d);
                        }
                    }
                }
            }
            return steps;
        }
    }
}
