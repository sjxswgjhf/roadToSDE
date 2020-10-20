package Bloomberg;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class lt991brokenCalc {

    /*
    if(x>=y)
    cost(x,y) = x-y
    if(x< y)
    cost (x,y) = 1 + cost(x,y+1) if y is odd
    cost (x,y) = 1 + cost(x,y/2) if y is even
    当x小于y的时候，我们能达到y的情况有两种，一种是到y+1了之后我们-1，
    另一种是我们到了y/2了，我们再double就好
     */
    class Solution {
        public int brokenCalc(int X, int Y) {
            if(X >= Y){
                return X-Y;
            }
            if(Y % 2 == 1){
                return 1 + brokenCalc(X, Y + 1);
            }else{
                return 1 + brokenCalc(X, Y / 2);
            }
        }
    }


    class SolutionIterative {
        public int brokenCalc(int X, int Y) {
            if(X > Y){
                return X-Y;
            }
            int steps = 0;
            while(Y > X){
                if(Y % 2 == 0){
                    Y /= 2;
                }else{
                    Y = Y + 1;
                }
                steps++;
            }
            return steps + X - Y;
        }
    }


    class SolutionTLE {
        public int brokenCalc(int X, int Y) {
            HashSet<Integer> seen = new HashSet<>();
            Queue<Integer> queue = new LinkedList<>();
            queue.add(X);
            int steps = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    int cur = queue.poll();
                    seen.add(cur);
                    if(cur == Y){
                        return steps;
                    }
                    int doub = cur * 2;
                    if(!seen.contains(doub) && doub < (int)(2 * 1e9)){
                        queue.add(doub);
                    }
                    int minus = cur - 1;
                    if(!seen.contains(minus) && minus > 0){
                        queue.add(minus);
                    }
                }
                steps++;
            }
            return steps;
        }
    }
}
