package BloombergOnsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class lt332findItinerary {
    class Solution {
        /*

        [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]

        MUR->LHR
        JFK->MUC
        SFO->SJC
        LHR->SFO


        [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]

        JFK->SFO
        JFK->ATL
        SFO->ATL
        ATL->JFK
        ATL->SFO

        JFK->SFO->ATL->JFK->ATL->SFO
        JFK->ATL->JFK->SFO->ATL->SFO

        JFK: ATL, SFO
        SFO: ATL
        ALT: JSK, SFO


        走第二个例子发现，每次选下一站的时候只选lexical最小的，不用care别的。根据题意也说了肯定有个有效的行程
        那么我们就是需要个数据能排序所有对应的目的地，然后然后可以逐渐往后的。
        那么优先队列成了首先, 先建立graph，map来实现，key是出发地，val是pq的一串目的地

        [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]

        JFK -> KUL, NRT
        NRT -> JFK

        虽然答案看上去好像是先放JFK再放children，但是这样子给出的行程顺序会导致不是valid，因为我们loop child，但是child之间彼此不通啊。直接加进去就会有问题
        所以我们应该把graph当成tree来看，root是jfk，那么当遇到第一个leaf的时候我们加入了list，kul加入，我们去到第二个child，这第二个child里面肯定能有个child是root，不然就是invalid了。

        上面的例子都能转换成tree，会发现两个child共享一个root的话，那么他们的child里面肯定至少有一方会有这个root
        jfk
        / \
      kul  nrt
            /
            jfk
        这个tree我们做postorder的话，是kul, jfk, nrt, jfk，我们reverse之后那么就是答案了 jfk nrt jfk kul

        nlogn
        */
        HashMap<String, PriorityQueue<String>> map;
        public List<String> findItinerary(List<List<String>> tickets) {
            List<String> res = new ArrayList<>();
            map = new HashMap<>();
            for(List<String> ticket : tickets){
                String from = ticket.get(0);
                String to = ticket.get(1);
                PriorityQueue<String> pq = map.getOrDefault(from, new PriorityQueue<>());   //排序需要eloge的时间
                pq.add(to);
                map.put(from, pq);
            }
            dfs("JFK", res);
            return res;
        }

        //这个只访问了一遍，O(e)
        private void dfs(String cur, List<String> res){

            PriorityQueue<String> pq = map.getOrDefault(cur, new PriorityQueue<>());
            while(!pq.isEmpty()){
                dfs(pq.poll(), res);
            }
            res.add(0,cur);
        }
    }
}
