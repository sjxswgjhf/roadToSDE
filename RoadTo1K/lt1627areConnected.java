package RoadTo1K;

import java.util.ArrayList;
import java.util.List;

public class lt1627areConnected {

    class Solution {
        /*
        典型的union find题，
        */
        class UnionFind{
            int[] ranks;
            int[] parents;
            public UnionFind(int x){
                ranks = new int[x];
                parents = new int[x];
                for(int i = 0; i < x; i++){
                    parents[i] = i;
                    ranks[i] = 1;
                }
            }

            public void union(int x, int y){
                int px = findParent(x);
                int py = findParent(y);
                if(px == py){
                    return;
                }
                if(ranks[px] > ranks[py]){
                    ranks[px] += ranks[py];
                    parents[py] = px;
                }else{
                    ranks[py] += ranks[px];
                    parents[px] = py;
                }
            }

            public int findParent(int x){
                if(parents[x] != x){
                    parents[x] = findParent(parents[x]);
                }
                return parents[x];
            }

        }

        public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
            UnionFind uf = new UnionFind(n + 1);
            for(int k = threshold + 1; k <= n; k++){
                for(int i = 2 * k; i <= n; i+=k){
                    if(uf.findParent(i) != uf.findParent(k)){
                        uf.union(i, k);
                    }
                }
            }
            List<Boolean> res = new ArrayList<>();
            for(int[] query : queries){
                if(uf.findParent(query[0]) == uf.findParent(query[1])){
                    res.add(true);
                }else{
                    res.add(false);
                }
            }
            return res;
        }
    }

/*
如果gcd是k
那么2k，3k，4k都是一起的
for(int k = threshold + 1; k <= n; k++){
    for(int x = 2*k; x <= n; x +=k){
        union(x, k);
    }
}

n/1 + n/2 + n/3 + ... + n/n= n*(1 + 1/2 + ... + 1/n)=n*log(n)
union: O(1) => O(constant)
*/
}
