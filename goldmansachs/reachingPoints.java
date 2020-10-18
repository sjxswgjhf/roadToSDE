package goldmansachs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class reachingPoints {

    class Solution {
        /*
        lt780
        首先tx跟ty肯定是不想等的，因为我们累加的时候，每次都有差值，所以最后也是会有差值
        然后当sx或者sy已经到达tx或者ty的时候，如果看另一边能不能达到呢，我们看另一边跟初始的差值是不是能被另一个数整除
        最后递归，当tx比ty大的时候，我们就减tx(更快的是取%)，当ty比tx大的时候，我们就减ty
         */
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {
            if(sx > tx || sy > ty)
                return false;
            if(sx == tx){
                return (ty-sy) % sx == 0;
            }
            if(sy == ty){
                return (tx-sx) % sy == 0;
            }
            if(tx > ty){
//                return reachingPoints(sx, sy, tx - ty,  ty);
                return reachingPoints(sx, sy, tx % ty,  ty);
            }
            else if(tx < ty){
//                return reachingPoints(sx, sy, tx, ty - tx);
                return reachingPoints(sx, sy, tx, ty % tx);
            }else{
                return false;
            }
        }
    }


    class SolutionMTLE {
        /*
        BFS:每步的选择是x，y的步数
        */
        class Node{
            int x;
            int y;
            public Node(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
        public boolean reachingPoints(int sx, int sy, int tx, int ty) {

            Queue<Node> queue = new LinkedList<>();
             HashSet<Node> visited = new HashSet<>();
            Node node = new Node(sx, sy);
            queue.add(node);
            while(!queue.isEmpty()){
                for(int i = 0; i < queue.size(); i++){
                    Node cur = queue.poll();
                    if(cur.x == tx && cur.y == ty){
                        return true;
                    }
                    if(visited.contains(cur)){
                        continue;
                    }else{
                        visited.add(cur);
                        int next = cur.x + cur.y;
                        Node next1 = new Node(next, cur.y);
                        Node next2 = new Node(cur.x, next);
                        if(next <= tx){
                            queue.add(next1);
                        }
                        if(next <= ty){
                            queue.add(next2);
                        }
                    }
                }
            }
            return false;
        }
    }
}
