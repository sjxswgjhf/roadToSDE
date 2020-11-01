package weeklyContest;

public class lt1630wk213 {

    class Solution {
        public boolean canFormArray(int[] arr, int[][] pieces) {
            boolean[] used = new boolean[pieces.length];
            for(int i = 0; i < arr.length; i++){
                int cur = arr[i];
                boolean find = false;
                outer: for(int j = 0; j < pieces.length; j++){
                    if(used[j]){
                        continue;
                    }else{
                        int[] piece = pieces[j];
                        for(int k = 0; k < piece.length; k++){
                            if(piece[k] == cur){
                                used[j] = true;
                                find = true;
                                break outer;
                            }
                        }
                    }
                }
                if(find == false){
                    return false;
                }
            }
            return true;
        }
    }
}
