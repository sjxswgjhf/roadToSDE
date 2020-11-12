package dailyProblem;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class lt1349maxStudents {

    class Solution {

        int r, c;
        int[][] memo;
        List<Integer> masks;

        public int maxStudents(char[][] seats) {
            r = seats.length;
            c = seats[0].length;
            memo = new int[r][1<<c];
            for (int i = 0; i < r; i++) {
                Arrays.fill(memo[i], -1);
            }
            return getMax(seats, 0, 0);
        }

        private int getMax(char[][] seats, int curRow, int prevRowMask) {
            if (curRow == r) {
                return 0;
            }
            if (memo[curRow][prevRowMask] != -1){
                return memo[curRow][prevRowMask];
            }
            masks = new LinkedList<>(); // reset the masks list for backtrack
            backtrack(seats[curRow], 0, prevRowMask, 0); // backtrack results store in masks list
            int res = 0;
            for (int m : masks) {
                res = Math.max(res, Integer.bitCount(m) + getMax(seats, curRow + 1, m));
            }
            memo[curRow][prevRowMask] = res;
            return res;
        }

        // this returns all combination of legal seat assignment for a given row based on prevous row's mask
        private void backtrack(char[] seats, int cur, int prevRowMask, int curRowMask) {
            if (cur == c) {
                masks.add(curRowMask);
                return;
            }
            // cur seat is not taken
            backtrack(seats, cur + 1, prevRowMask, curRowMask);

            // cur seat is taken, check if left, upper left and upper right positions are empty
            if (seats[cur] != '#'
                    && (cur == 0 || (((curRowMask & (1 << (cur-1))) == 0) && (prevRowMask & (1 << (cur-1))) == 0))
                    && (cur == c - 1 || ((prevRowMask & (1 << (cur+1))) == 0))) {
                curRowMask |= (1 << (cur));
                backtrack(seats, cur + 1, prevRowMask, curRowMask);
                curRowMask ^= (1 << (cur));
            }
        }
    }

//    class Solution {
//        public int maxStudents(char[][] seats) {
//            int m = seats.length;
//            int n = seats[0].length;
//            int[][] dp = new int[m + 1][1 << n];
//            for(int i = 0; i < m; i++){
//                for(int l = 0; l < (1 << n); l++){
//                    for(int c = 0; c < (1 << n); c++){
//                        boolean flag = true;
//                        for(int j = 0; j < n && flag; j++){
//                            if(((c & (1 << j)) == 0)){
//                                continue;
//                            }
//                            if(seats[i][j] == '#'){
//                                flag = false;
//                            }
//                            boolean lt = j == 0 ? false : (c &(1 << (j - 1))) == 0 ;
//                            boolean rt = j == n - 1 ? false : (c & (1 << (j + 1))) == 0;
//                            boolean ul = (j == 0 || i == 0) ? false : (l & (1 << (j - 1))) == 0;
//                            boolean ur = (j == n - 1 || i == 0) ? false : (l & (1 << (j + 1))) == 0;
//                            if(lt || rt || ul || ur){
//                                flag = false;
//                            }
//                        }
//                        if(flag){
//                            dp[i + 1][c] = Math.max(dp[i + 1][c], dp[i][l] + (count_setbtis(c)));
//                        }
//                    }
//                }
//            }
//            int res = 0;
//            for(int i = 0; i < (1<< n); i++){
//                res = Math.max(res, dp[m][i]);
//            }
//            return res;
//        }
//
//        private int count_setbtis(int n){
//            int cnt = 0;
//            while(n > 0){
//                cnt += (n & 1);
//                n = n >> 1;
//            }
//            return cnt;
//        }
//    }
}
