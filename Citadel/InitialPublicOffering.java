package Citadel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class InitialPublicOffering {

    static class User{
        int id;
        int numOfShares;
        int price;
        int timestamp;

        public User(int id, int numOfShares, int price, int timestamp){
            this.id = id;
            this.numOfShares = numOfShares;
            this.price = price;
            this.timestamp = timestamp;
        }
    }

    public static List<Integer> findBind(int n, int number, int[][] bins, int shares){
        PriorityQueue<User> pq = new PriorityQueue<>((a,b)->(a.price != b.price ? b.price - a.price : a.timestamp - b.timestamp ));
        for(int i = 0; i < n; i++){
            User user = new User(bins[i][0], bins[i][1], bins[i][2], bins[i][3]);
            pq.offer(user);
        }
        List<Integer> res = new ArrayList<>();
        while(!pq.isEmpty() && shares > 0){
            User user = pq.poll();
            shares -= user.numOfShares > shares ? shares : user.numOfShares;
        }
        while(!pq.isEmpty()){
            User user = pq.poll();
            res.add(user.id);
        }
        Collections.sort(res);
        return res;
    }


    public static void main(String[] args) {
        int n = 4;
        int num = 5;
        int[][] bids = {{1,5,5,0},{2,7,8,1},{3,7,5,1}, {4,10,3,3}};
        int shares = 18;
        List<Integer> res = findBind(n, num, bids, shares);
        for(int i : res){
            System.out.print(i+" ");
        }
    }
}
