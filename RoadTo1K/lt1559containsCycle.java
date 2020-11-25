package RoadTo1K;

public class lt1559containsCycle {

    class Solution {
        /*
        DFS:
        这个方法是避免了这一次访问的cell不是上一轮那个cell，如果下一个cell不是上一轮的cell，又访问过了，那么这个就证明了cycle存在了
        并且这样的一个cycle肯定是长度大于等于4的，这样做的好处是不像TLE，我们找到一个出发点，如果路径中有cycle了，就可以返回true了
        而不是一定要返回出发点，
        */
        public boolean containsCycle(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(!visited[i][j]){
                        if(dfs(grid, i, j, m, n, visited, -1, -1, grid[i][j])){
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        int[][] dirs = {{0,1}, {-1,0}, {0,-1}, {1,0}};
        private boolean dfs(char[][] grid, int r, int c, int m, int n, boolean[][] visited, int prevr, int prevc, char startc){
            visited[r][c] = true;

            for(int i = 0; i < 4; i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    if(!(nr == prevr && nc == prevc)){
                        if(grid[nr][nc] == startc){
                            if(visited[nr][nc]){
                                return true;
                            }else{
                                if(dfs(grid, nr, nc, m, n, visited, r, c, startc)){
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
            // visited[r][c] = false;
            return false;
        }
    }

    class SolutionTLE {
        /*
        DFS:
        怎么reduce
        如果一个点跟别的点连同，那么这个点如果没有cycle，所有连通的点也不会有cycle
        为什么TLE，这里里面，我们把visited改成了false，造成了大量的重复计算，虽然保证了下面这个例子是正确的，但是其实我们在访问第一个a
        的时候，已经能找到cycle了，但是因为我们的算法是要求回到起始点的，所以第一个a的时候不是true，要到(1,0)这里才是true,所以后面
        大量的case变成了TLE
        cad
        aaa
        aad
        acd
        abc
        */
        public boolean containsCycle(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            boolean[][] visited = new boolean[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(!visited[i][j]){
                        if(dfs(grid, i, j, m, n, visited, i, j, 0)){
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        int[][] dirs = {{0,1}, {-1,0}, {0,-1}, {1,0}};
        private boolean dfs(char[][] grid, int r, int c, int m, int n, boolean[][] visited, int startr, int startc, int len){
            visited[r][c] = true;
            len++;
            for(int i = 0; i < 4; i++){
                int nr = r + dirs[i][0];
                int nc = c + dirs[i][1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == grid[r][c]){
                    if(visited[nr][nc]){
                        if(len >= 4 && nr == startr && nc == startc){
                            return true;
                        }
                    }else{
                        if(dfs(grid, nr, nc, m, n, visited, startr, startc, len)){
                            return true;
                        }
                    }
                }
            }
            len--;
            visited[r][c] = false;
            return false;
        }
    }
}
