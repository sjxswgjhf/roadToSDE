package BloombergOnsite;

public class lt1706finadBalls {

    class Solution {
        //本题的位置只跟col有关
        public int[] findBall(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[] balls = new int[n];
            for (int i = 0; i < n; i++) {
                int pos = i;
                //开始一层层试着往下走
                for (int j = 0; j < m; j++) {
                    //下一个位置是当前位置+当前行的slope
                    int nextPos = pos + grid[j][pos];
                /*
                什么时候会stuck呢，我们知道对于当前这行来说，我们当前位置，跟下一个要走的位置的slope一样的话，才能走过去，
                例如例子里面的row(0,0)跟row(0,1),但是如果下一个位置的当前row的斜率是跟我们反着的，我们就不能过去了,
                即row(0,2) 跟row(0,3)，从0,2我们往第三个col走，但是当前的第三个col把我们堵住了
                */
                    if (nextPos >= n || nextPos < 0
                            || grid[j][nextPos] != grid[j][pos]) {
                        pos = -1;
                        break;
                    } else {
                        pos += grid[j][pos];
                    }
                }
                balls[i] = pos;
            }
            return balls;
        }
    }
}
