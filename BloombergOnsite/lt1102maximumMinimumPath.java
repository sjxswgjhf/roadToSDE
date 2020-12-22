package BloombergOnsite;

public class lt1102maximumMinimumPath {

    class Solution {
        /*
        5 4 5
        1 2 6
        7 4 6

        直接binary search，把可能的答案做dfs，可以就先当做res，然后移动左端点，不可以就移动右端点
        */
        boolean[][] visited;
        public int maximumMinimumPath(int[][] A) {
            int m = A.length;
            int n = A[0].length;
            int l = 0, r = 100000000;
            int res = 0;
            while(l <= r){
                int mid = l + (r - l) / 2;
                visited = new boolean[m][n];
                if(dfs(A, 0, 0, m, n, mid)){
                    res = mid;
                    l = mid + 1;
                }else{
                    r = mid - 1;
                }
            }
            return res;
        }

        int[][] dirs = {{0,1}, {-1,0}, {0,-1},{1,0}};
        private boolean dfs(int[][] A, int i, int j, int m, int n, int limit){
            if(visited[i][j]){
                return false;
            }
            if(A[i][j] < limit){
                return false;
            }
            if(i == m - 1 && j == n - 1){
                return true;
            }
            visited[i][j] = true;
            for(int d = 0; d < 4; d++){
                int nextR = i + dirs[d][0];
                int nextC = j + dirs[d][1];
                if(nextR >= 0 && nextR < m && nextC >= 0 && nextC < n){
                    if(dfs(A, nextR, nextC, m, n, limit)){
                        return true;
                    }
                }
            }
            // visited[i][j] = false;
            return false;
        }

    }
}
