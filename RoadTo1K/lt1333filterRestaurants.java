package RoadTo1K;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class lt1333filterRestaurants {

    class Solution {
        /*
        restaurants[i] = [idi, ratingi, veganFriendlyi, pricei, distancei]

        */
        class Restaurant{
            int id;
            int rating;
            int veganFriendly;
            int price;
            int distance;
            public Restaurant(int id, int rating, int veganFriendly, int price, int distance){
                this.id = id;
                this.rating = rating;
                this.veganFriendly = veganFriendly;
                this.price = price;
                this.distance = distance;
            }
        }

        public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
            List<Integer> res = new ArrayList<>();
            PriorityQueue<Restaurant> pq1 = new PriorityQueue<>((a,b)-> a.rating != b.rating ? b.rating - a.rating : (a.id != b.id ? b.id-a.id : ((a.price != b.price) ? a.distance - b.distance : a.price - b.price)));
            PriorityQueue<Restaurant> pq = new PriorityQueue(new Comparator<Restaurant>(){
                @Override
                public int compare(Restaurant r1, Restaurant r2){
                    if(r1.rating != r2.rating){
                        return r2.rating - r1.rating;
                    }else{
                        return r2.id - r1.id;
//                        if(r1.price != r2.price){
//                            return r1.price - r2.price;
//                        }else{
//                            return r1.distance - r2.distance;
//                        }
                    }
                }
            });
            for(int[] rest : restaurants){
                Restaurant r = new Restaurant(rest[0], rest[1], rest[2], rest[3], rest[4]);
                if(r.veganFriendly == veganFriendly){
                    if(r.price <= maxPrice && r.distance <= maxDistance){
                        pq.add(r);
                    }
                }
            }
            while(!pq.isEmpty()){
                res.add(pq.poll().id);
            }
            return res;
        }
    }
}
