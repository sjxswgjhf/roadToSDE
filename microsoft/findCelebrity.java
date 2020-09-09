package microsoft;

import java.util.HashMap;
import java.util.Stack;


class Relation{
    boolean knows(int a, int b) {
        return false;
    }
}

public class findCelebrity {



    /* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */
    public class SolutionStack extends Relation {
        public int findCelebrity(int n) {
            if(n <= 0){
                return -1;
            }
            if(n == 1){
                return 0;
            }
            Stack<Integer> stack = new Stack<>();
            for(int i = 0; i < n; i++){
                stack.push(i);
            }
            int a = 0, b = 0;
            //only one candidate left
            while(stack.size() > 1){
                a = stack.pop();
                b = stack.pop();
                //a know b, then b could be candidate, a not
                if(knows(a, b)){
                    stack.push(b);
                }else{
                    //a could be candidate still
                    stack.push(a);
                }
            }

            int celebrity = stack.pop();
            //check candidate is valid or not, he/she should know nothing, but the other all know him/her
            for(int i = 0; i < n; i++){
                if(i != celebrity && (knows(celebrity, i) || !knows(i, celebrity))){
                    return -1;
                }
            }
            return celebrity;
        }
    }

    public class Solution extends Relation {

        //int[2], int[0] = # know other int[1] = other know him
        HashMap<Integer, int[]> hashmap = new HashMap<>();

        public int findCelebrity(int n) {
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i != j){
                        if(knows(i,j)){
                            int[] as = hashmap.getOrDefault(i, new int[2]);
                            int[] bs = hashmap.getOrDefault(j, new int[2]);
                            as[0]++;
                            bs[1]++;
                            hashmap.put(i, as);
                            hashmap.put(j, bs);
                        }
                    }
                }
            }
            for(int i = 0; i < n; i++){
                int[] vs = hashmap.get(i);
                if(vs != null){
                    if(vs[0] == 0 && vs[1] == n-1){
                        return i;
                    }
                }
            }
            return -1;
        }
    }
}
