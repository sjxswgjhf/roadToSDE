package Bloomberg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class lt1169invalidTransactions {

    class Solution {

        class Transacation{
            String name;
            Integer time;
            Integer amount;
            String location;
            String transaction;

            public Transacation(String transaction){
                this.transaction = transaction;
                String[] info = transaction.split(",");
                this.name = info[0];
                this.time = Integer.valueOf(info[1]);
                this.amount = Integer.valueOf(info[2]);
                this.location = info[3];
            }
        }

        public List<String> invalidTransactions(String[] transactions) {
            HashSet<String> res = new HashSet<>();
            HashMap<String, List<Transacation>> map = new HashMap<>();
            for(String transaction : transactions){
                Transacation node = new Transacation(transaction);
                List<Transacation> list = map.getOrDefault(node.name, new ArrayList<>());
                list.add(node);
                map.put(node.name, list);
            }
            for(String name : map.keySet()){
                List<Transacation> list = map.get(name);
                for(int i = 0 ; i < list.size() ; i++){
                    Transacation cur = list.get(i);
                    if(cur.amount > 1000){
                        res.add(cur.transaction);
                    }else{
                        for(int j = 0; j < list.size(); j++){
                            if(i == j){
                                continue;
                            }
                            Transacation tmp = list.get(j);
                            if(!tmp.location.equals(cur.location) && Math.abs(tmp.time - cur.time) <= 60){
                                res.add(cur.transaction);
                            }
                        }
                    }
                }
            }
            return new ArrayList<>(res);
        }
    }
}
