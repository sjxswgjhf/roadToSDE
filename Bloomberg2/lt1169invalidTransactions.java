package Bloomberg2;

import java.util.*;

public class lt1169invalidTransactions {

    class Solution {

        class Node{
            String name;
            int time;
            int amount;
            String location;
            public Node(String name, int t, int amount, String location){
                this.name = name;
                this.time = t;
                this.amount = amount;
                this.location = location;
            }
        }

        public List<String> invalidTransactions(String[] datas) {
            HashMap<String, List<Node>> map = new HashMap<>();
            for(String data : datas){
                String[] strs = data.split(",");
                Node node = new Node(strs[0], Integer.valueOf(strs[1]), Integer.valueOf(strs[2]), strs[3]);
                List<Node> list = map.getOrDefault(strs[0], new ArrayList<>());
                list.add(node);
                map.put(strs[0], list);
            }
            List<String> res = new ArrayList<>();

            for(String key : map.keySet()){
                List<Node> list = map.get(key);
                for(int i = 0; i < list.size(); i++){
                    Node cur = list.get(i);
                    if(cur.amount > 1000){
                        String str = buildString(cur);
                        res.add(str);
                    }else{
                        //因为数据不是排序的,所以一定要重头开始检查所有的data，
                        for(int j = 0; j < list.size(); j++){
                            if(i == j){
                                continue;
                            }else{
                                Node tmp = list.get(j);
                                if(!cur.location.equals(tmp.location) && Math.abs(cur.time - tmp.time) <= 60){
                                    String str = buildString(cur);
                                    res.add(str);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return res;
        }

        private String buildString(Node node){
            String res = node.name + "," + node.time + "," + node.amount + "," + node.location;
            return res;
        }
    }
}
