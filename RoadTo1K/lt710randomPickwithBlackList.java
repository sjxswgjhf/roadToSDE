package RoadTo1K;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class lt710randomPickwithBlackList {

    class Solution {
        /*
        N = 1e10
        由于N太大，不能列出一个list来操作
        有N个数，但是有黑名单，那么也就是只有M个有效数

        0 1 2 7 4 5 6 //b: 3 8 9
        首先我们可以确定M的范围，M里面有一些是black的，我们需要跟M范围外的white去替换掉，
        那么我们就可以用map的思想来做，如果我们M里面的black对应M外面的white，那么我们随机的时候我们遇到black了，我们就返回
        map对应的white就可以

        那么我们就建立一个map去做映射。跟M外的white替换
        我们就用给一个tmp value从M开始，遍历blacklist，如果black大于等于M，我们不管，
        对于每个小于M的black，我们需要找到一个大于M的white
        */
        HashMap<Integer, Integer> map;
        int M;
        Random rand;
        public Solution(int N, int[] blacklist) {

            HashSet<Integer> set = new HashSet<>();
            map = new HashMap<>();
            for(int b : blacklist){
                set.add(b);
            }
            this.M = N - blacklist.length;
            int y = M;
            rand = new Random();
            for(int black : blacklist){
                //大于M不管
                if(black >= M){
                    continue;
                }
                //如果black在M里面，我们开始找一个大于M的white去替换black，
                while(set.contains(y)){
                    y++;
                }
                //遇到black就是y
                map.put(black, y);
                y++;
            }

        }
        /*
        怎么把random到了kick out
        */
        public int pick() {
            int res = rand.nextInt(M);
            if(map.containsKey(res)){
                return map.get(res);
            }
            return res;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */
}
