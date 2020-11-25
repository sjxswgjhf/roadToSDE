package RoadTo1K;

import java.util.Random;

public class problemProducer {

    public static void main(String[] args) {
        int numOfLt = 1659;
        Random rand = new Random();
//        int[] pros = new int[numOfLt + 1];
        System.out.print(" ");
        for(int i = 0; i < 5; i++){
            int proNum = rand.nextInt(numOfLt) + 1;
            System.out.print(proNum);
            if(i != 4){
                System.out.print(", ");
            }
//            pros[proNum]++;
        }
        System.out.println("<br>");
//        int max = 0;
//        for(int i = 0; i < numOfLt + 1; i++){
//            System.out.print(pros[i] + " ");
//            max = Math.max(pros[i], max);
//            if(i % 20 == 0){
//                System.out.println();
//            }
//        }
//        System.out.println();
//        System.out.println(max);
    }

    public static class lt947removeStones {

        class Solution {
        /*
        union find

        */
            class UnionFind{
                int[] ranks;
                int[] parents;
                public UnionFind(int n){
                    ranks = new int[n];
                    parents = new int[n];
                    for(int i = 0; i < n; i++){
                        ranks[i] = 1;
                        parents[i] = i;
                    }
                }

                public boolean union(int x, int y){
                    int px = findParent(x);
                    int py = findParent(y);
                    if(px == py){
                        return false;
                    }
                    if(ranks[px] < ranks[py]){
                        parents[px] = py;
                        ranks[py] += ranks[px];
                    }else{
                        parents[py] = px;
                        ranks[px] += ranks[py];
                    }
                    return true;
                }

                public int findParent(int x){
                    if(parents[x] != x){
                        parents[x] = findParent(parents[x]);
                    }
                    return parents[x];
                }
            }

            public int removeStones(int[][] stones) {
                int n = stones.length;
                UnionFind uf = new UnionFind(n);
                int count = 0;
                for(int i = 0 ; i < n; i++){
                    for(int j = i + 1; j < n; j++){
                        if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]){
                            if(uf.union(i, j)){
                                count++;
                            }
                        }
                    }
                }
                return count;
            }
        }
    }
}
