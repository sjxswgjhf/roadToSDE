package Bloomberg;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class lt1396UndergroundSystem {
    class UndergroundSystem {

    /*
    Hashmap<String, HashMap<String, ArrayList<>())

    key: startstation

    value: endstation with add times
    */


        HashMap<String, HashMap<String, ArrayList>> map;
        HashMap<Integer, Node> customers;

        class Node{
            String station;
            int id;
            int t;
            public Node(String station, int id, int t){
                this.station = station;
                this.id = id;
                this.t = t;
            }
        }

        public UndergroundSystem() {
            customers = new HashMap();
            map = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            Node node = new Node(stationName, id, t);
            customers.put(id, node);
            if(!map.containsKey(stationName)){
                map.put(stationName, new HashMap<>());
            }
        }

        public void checkOut(int id, String stationName, int t) {
            Node node = customers.get(id);
            String from = node.station;
            int start = node.t;
            ArrayList<Integer> list = map.get(from).getOrDefault(stationName, new ArrayList<>());
            list.add(t - start);
            map.get(from).put(stationName, list);
            customers.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            ArrayList<Integer> list = map.get(startStation).get(endStation);
            double res = 0.0;
            for(int num : list){
                res += num;
            }
            return res / list.size();
        }
    }

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
}
