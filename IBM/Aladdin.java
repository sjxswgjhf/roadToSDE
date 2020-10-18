package IBM;

public class Aladdin {

    public int Aladdin(int[] magic, int[] cost){
        int n = magic.length;
        int total_tank = 0;
        int cur_tank = 0;
        int starting_idx = 0;
        for(int i =0; i < n; i++){
            total_tank += magic[i] - cost[i];
            cur_tank += magic[i] - cost[i];
            if(cur_tank < 0){
                starting_idx = i + 1;
                cur_tank = 0;
            }
        }
        return total_tank >= 0 ? starting_idx : -1;
    }
}
