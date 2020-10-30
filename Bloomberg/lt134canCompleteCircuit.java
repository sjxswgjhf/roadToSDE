package Bloomberg;

public class lt134canCompleteCircuit {

    class Solution {

    /*
    1   2   3   4   5
    3   4   5   1   2
    -2  -2 -2   3   3
    tank = -2 -2 -2 3 6
    request = -2 + -2 + -2
    startIdx = 0 1 2 3
If car starts at A and can not reach B. Any station between A and B
can not reach B.(B is the first station that A can not reach.)
If the total number of gas is bigger than the total number of cost. There must be a solution.
    */

        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            int request = 0;
            int tank = 0;
            int startIdx = 0;
            for(int i = 0; i < n; i++){
                tank += gas[i] - cost[i];
                if(tank < 0){
                    request += tank;
                    tank = 0;
                    startIdx++;
                }
            }
            if(request + tank < 0){
                return -1;
            }else{
                return startIdx;
            }
        }
    }



    class SolutionSlow {
        /*
        1 2 3 4 5
        3 4 5 1 2
        Naive的 approach
        */
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int n = gas.length;
            for(int i = 0; i < n; i++){

                int tank = 0;
                int costs = 0;
                boolean reach = true;
                for(int j = i; j < i + n; j++){
                    tank += gas[j % n];
                    costs += cost[j % n];
                    if(tank < costs){
                        reach = false;
                        break;
                    }
                }
                if(reach){
                    return i;
                }
            }
            return -1;
        }
    }
}
