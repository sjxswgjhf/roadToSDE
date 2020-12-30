package BloombergOnsite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lt1396UndergroundSystem {

    class UndergroundSystem2ND{

        class Node{
            int id;
            String startStation;
            int time;
            public Node(int id, String str, int t){
                this.id = id;
                this.startStation = str;
                this.time = t;
            }
        }

        HashMap<Integer, Node> nodeMap;
        HashMap<String, HashMap<String, List<Integer>>> map;
        public UndergroundSystem2ND() {
            map = new HashMap<>();
            nodeMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            Node node = new Node(id, stationName, t);
            nodeMap.put(id, node);
        }

        public void checkOut(int id, String stationName, int t) {
            Node node = nodeMap.get(id);
            HashMap<String, List<Integer>> table = map.getOrDefault(stationName, new HashMap<>());
            List<Integer> list = table.getOrDefault(node.startStation, new ArrayList<>());
            list.add(t - node.time);
            table.put(node.startStation, list);
            map.put(stationName, table);
            nodeMap.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            HashMap<String, List<Integer>> table = map.getOrDefault(endStation, new HashMap<>());
            List<Integer> list = table.getOrDefault(startStation, new ArrayList<>());
            double sum = 0.0;
            for(int num : list){
                sum += num;
            }
            if(list.size() == 0){
                return 0.0;
            }
            return sum * 1.0 / list.size();
        }
    }

    class UndergroundSystem {

        class Node{
            int id;
            String station;
            int time;
            public Node(int id, String station, int time){
                this.id = id;
                this.station = station;
                this.time = time;
            }
        }

        HashMap<String, HashMap<String, List<Integer>>> avgMap;
        HashMap<Integer, Node> map;
        public UndergroundSystem() {
            avgMap = new HashMap<>();
            map = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            Node node = new Node(id, stationName, t);
            map.put(id, node);
        }

        public void checkOut(int id, String stationName, int t) {
            Node node = map.get(id);
            HashMap<String, List<Integer>> m = avgMap.getOrDefault(stationName, new HashMap<>());
            int travelTime = t - node.time;
            List<Integer> list = m.getOrDefault(node.station, new ArrayList<>());
            list.add(travelTime);
            m.put(node.station, list);
            avgMap.put(stationName, m);
        }

        public double getAverageTime(String startStation, String endStation) {
            HashMap<String, List<Integer>> m = avgMap.getOrDefault(endStation, new HashMap<>());
            List<Integer> list = m.getOrDefault(startStation, new ArrayList<>());
            double sum = 0;
            for(int time : list){
                sum += time;
            }
            return sum / list.size();
        }
    }


}
