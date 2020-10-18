package IBM;

import java.util.HashMap;

public class shopperDelight {

    public int shopper(int K, int[] jeans, int[] shoes, int[] skirts, int[] tops){
        int[][] dp = new int[4][K+1];
        int res = 0;
        HashMap<Integer, int[]> map = new HashMap<>();
        map.put(1, shoes);
        map.put(2, skirts);
        map.put(3, tops);
        for(int i = 0; i < dp.length; i++){
            if(i == 0){
                for(int j = 0; j < jeans.length; j++){
                    dp[i][jeans[j]] = 1;
                }
            }else{
                for(int j = 0; j < dp[0].length; j++){
                    for(int k = 0; k < map.get(i).length; k++){
                        if(dp[i-1][j] > 0 && j + map.get(i)[k] <= K){
                            dp[i][j+map.get(i)[k]] += dp[i-1][j];
                        }
                    }
                }
            }
        }
        for(int i = 0; i < dp[0].length; i++){
            res += dp[3][i];
        }
        return res;
    }
}
