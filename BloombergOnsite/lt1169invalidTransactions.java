package BloombergOnsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lt1169invalidTransactions {

    class Solution {

        class Node{
            String name;
            int time;
            int amount;
            String location;
            public Node(String n, int t, int a, String l){
                name = n;
                time = t;
                amount = a;
                location = l;
            }
        }

        public List<String> invalidTransactions(String[] transactions) {
            HashMap<String, List<Node>> map = new HashMap<>();
            for(String transaction : transactions){
                String[] info = transaction.split(",");
                Node node = new Node(info[0], Integer.valueOf(info[1]), Integer.valueOf(info[2]), info[3]);
                List<Node> list = map.getOrDefault(node.name, new ArrayList<>());
                list.add(node);
                map.put(node.name, list);
            }
            List<String> res = new ArrayList<>();
            for(String name : map.keySet()){
                List<Node> list = map.get(name);
                for(int i = 0 ; i < list.size(); i++){
                    Node node = list.get(i);
                    if(node.amount >= 1000){
                        String str = buildStr(node);
                        res.add(str);
                    }else{
                        for(int j = 0; j < list.size(); j++){
                            if(i != j){
                                Node tmp = list.get(j);
                                if(!tmp.location.equals(node.location) && Math.abs(tmp.time - node.time) <= 60){
                                    String str = buildStr(node);
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

        private String buildStr(Node node){
            String str = node.name+","+node.time+","+node.amount+","+node.location;
            return str;
        }
    }
}
