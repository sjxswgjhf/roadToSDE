package RoadTo1K;

import java.util.PriorityQueue;

public class lt1199minBuildTime {


    class Solution {
        /*
        [1,2,3] split = 1

        难点，什么时候派人去干活，剩下的继续split，
        贪心原则是用一个(分裂)出现更早的工人, 去完成代价更大的任务, 这样永远比反过来所需时间要少.
        每个任务都是一个leaf node，每个内部节点inner node的cost是split，


        [1 3 4 7 10], 5

        1 + 3 => 3 + 5 = 8

        [4 7 8 10]

        4 + 7 => 7 +5 = 12
        [8, 10, 12]

        8 + 10 => 10 + 5 = 15

        [12, 15]

        12 + 15 => 15 + 5 = 20


        */
        public int minBuildTime(int[] blocks, int split) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int b : blocks){
                pq.add(b);
            }
        /*
         1 3 4 7 10
         每轮我们都是split+干活，这样花费的较大的时间加入到总的cost里面，

          5
        /  \
       5      5
      / \    / \
     5   10 4   7
    / \
   1   3
        */
            while(pq.size() > 1){
                pq.poll();
                pq.add(pq.poll() + split);
            }
            return pq.poll();
        }
    }
}
