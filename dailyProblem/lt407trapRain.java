package dailyProblem;

import java.util.PriorityQueue;

public class lt407trapRain {

    class Solution {

        class Node{
            int row;
            int col;
            int height;
            public Node(int row, int col, int height){
                this.row = row;
                this.col = col;
                this.height = height;
            }
        }

        /*
        这题是反向思考，是用高的决定低的,即cell四周都比cell高的话，
        用heap的话，高度最接近的会先poll出来然后solve，之后其他的会被忽略掉了
        而处理过后积水了，这个是新的height放入pq里面,因为可以用于给其他cell当border了
        */
        public int trapRainWater(int[][] heightMap) {
            int m = heightMap.length;
            int n = heightMap[0].length;
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->a.height - b.height);
            boolean[][] visited = new boolean[m][n];
            for(int i = 0; i < n; i++){
                visited[0][i] = true;
                visited[m-1][i] = true;
                pq.add(new Node(0, i, heightMap[0][i]));
                pq.add(new Node(m-1, i, heightMap[m-1][i]));
            }

            for(int i = 0; i < m; i++){
                visited[i][0] = true;
                visited[i][n-1] = true;
                pq.add(new Node(i, 0, heightMap[i][0]));
                pq.add(new Node(i, n-1, heightMap[i][n-1]));
            }
            int[][] dirs = {{0,1}, {-1,0},{0,-1},{1,0}};
            int res = 0;
            while(!pq.isEmpty()){
                Node node = pq.poll();
                for(int i = 0; i < 4; i++){
                    int row = node.row + dirs[i][0];
                    int col = node.col + dirs[i][1];
                    if(row >= 0 && row < m && col >= 0 && col < n && !visited[row][col]){
                        visited[row][col] = true;
                        res += Math.max(0, node.height - heightMap[row][col]);
                        pq.add(new Node(row, col, Math.max(node.height, heightMap[row][col])));
                    }
                }
            }
            return res;
        }
    }
}
