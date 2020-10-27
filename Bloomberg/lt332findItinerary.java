package Bloomberg;

import java.util.*;

public class lt332findItinerary {

    class Solution {
    /*
    at least one valid itinerary, lexical
    [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]

    JFK -> MUC
    MUC -> LHR
    LHR -> SFO
    SFO -> SJC

    [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    JFK -> ATL, SFO
    ATL -> JFK, SFO
    SFO -> ATL

    JFK -> ALT -> JFK -> SFO -> ATL

    走第二个例子发现，每次选下一站的时候只选lexical最小的，不用care别的。根据题意也说了肯定有个有效的行程
    那么我们就是需要个数据能排序所有对应的目的地，然后然后可以逐渐往后的。
    那么优先队列成了首先, 先建立graph，map来实现，key是出发地，val是pq的一串目的地

    [["JFK","KUL"],["JFK","NRT"],["NRT","JFK"]]

    JFK -> KUL, NRT
    NRT -> JFK

    虽然答案看上去好像是先放JFK再放children，但是这样子给出的行程顺序会导致不是valid，因为我们loop child，但是child之间彼此不通啊。直接加进去就会有问题
    所以我们应该把graph当成tree来看，root是jfk，那么当遇到第一个leaf的时候我们加入了list，kul加入，我们去到第二个child，这第二个child里面肯定能有个child是root，不然就是invalid了。
    上面的例子都能转换成tree，会发现两个child共享一个root的话，那么他们的child里面肯定至少有一方会有这个root
    我们通过postorder的加入方法，最后需要reverse，但是我们加入到第一位置的话，就不用reverse了
    */

        public List<String> findItinerary(List<List<String>> tickets) {
            HashMap<String, PriorityQueue<String>> map = new HashMap<>();
            for(List<String> ticket : tickets){
                String from = ticket.get(0);
                String to = ticket.get(1);
                PriorityQueue<String> pq = map.getOrDefault(from, new PriorityQueue<>());
                pq.add(to);
                map.put(from, pq);
            }
            List<String> res = new LinkedList<>();
            String start = "JFK";
            dfs(start, map, res);
            return res;
        }

        /*
        postorder traversal: 最后放根节点
        */
        private void dfs(String cur, HashMap<String, PriorityQueue<String>> map, List<String> res){
            if(map.containsKey(cur)){
                PriorityQueue<String> pq = map.get(cur);
                while(!pq.isEmpty()){
                    String str = pq.poll();
                    dfs(str, map, res);
                }
            }

            res.add(0, cur);
        }

    }

    public static void main(String[] args) {
        List<List<String>> input = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        list1.add("JFK");
        list1.add("KUL");
        List<String> list2 = new ArrayList<>();
        list2.add("JFK");
        list2.add("NRT");
        List<String> list3 = new ArrayList<>();
        list3.add("NRT");
        list3.add("JFK");
    }
}
