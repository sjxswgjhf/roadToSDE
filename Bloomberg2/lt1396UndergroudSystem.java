package Bloomberg2;

import  java.util.*;

public class lt1396UndergroudSystem {

    class UndergroundSystem {

        class Customer{
            int id;
            int time;
            String sstation;
            public Customer(int id, int time, String sstation){
                this.time = time;
                this.sstation = sstation;
                this.id = id;
            }
        }
        //key: endStation   value: key: startstation, time
        HashMap<String, HashMap<String, List<Integer>>> timeTable;
        HashMap<Integer, Customer> customers;
        public UndergroundSystem() {
            timeTable = new HashMap<>();
            customers = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            Customer customer = new Customer(id, t, stationName);
            customers.put(id, customer);
        }

        public void checkOut(int id, String stationName, int t) {
            Customer customer = customers.get(id);
            HashMap<String, List<Integer>> map = timeTable.getOrDefault(stationName, new HashMap<>());
            List<Integer> list = map.getOrDefault(customer.sstation, new ArrayList<>());
            list.add(t - customer.time);
            map.put(customer.sstation, list);
            timeTable.put(stationName, map);
            customers.remove(id);
        }

        public double getAverageTime(String startStation, String endStation) {
            List<Integer> list = timeTable.get(endStation).get(startStation);
            int sum = 0;
            for(int num : list){
                sum += num;
            }
            return sum * 1.0 / list.size();
        }
    }
}
