package weeklyContest;

public class lt1648maxProfit {


    /*
    Math题
     */









    class SolutionTLE {
        public int maxProfit(int[] inventory, int orders) {
            int mod = (int)(1e9) + 7;
            int dp = 0;
            for(int i = 1; i <= orders; i++){
                int maxIdx = 0;
                for(int j = 0; j < inventory.length; j++){
                    if(inventory[j] > inventory[maxIdx]){
                        maxIdx = j;
                    }
                }
                dp = (dp + inventory[maxIdx]) % mod;
                inventory[maxIdx]--;
            }
            return dp;
        }
    }
}
