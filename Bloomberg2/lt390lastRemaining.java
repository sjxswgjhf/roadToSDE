package Bloomberg2;

public class lt390lastRemaining {

        class Solution {

            /*
            1 2 3
            head = 1
            step = 1
            1 + 1 = 2

            1 2 3 4
            2 4     no add
            2
            head = 1
            step = 1
            1 + 1 = 2

            1 2 3 4 5
            2 4 no add
            2
           head = 1
            step = 1
            1 + 1 = 2

            1 2 3 4 5 6     head = head + step = 1 +  1 = 2
            2 4 6     odd   head = 4 - 2 = 2 ?  head + step*2 or head+=rounds??
            4

            1 2 3 4 5 6 7
            2 4 6   odd
            4

            1 2 3 4 5 6 7 8         head = 2
            2 4 6 8     right even
            2 6     left head = 2 + 4 = 6?  or head * 3?  4 <- step * 2 = 4
            6

            1 2 3 4 5 6 7 8 9 10
            2 4 6 8 10 right odd    head = 4        2
            4 8    left     head = step*2 + head = 4 + 4 = 8
            8

            左边的时候，会增长head，
            右边的时候，如果长度是是even，会发现head没有变化，odd的时候会增长head

            1 2 3 4 5 6 7 8
            2 4 6 8
            2 6
            6

            head初始为1，增长为1，左边第一次是1+1 = 2， increase = 1 * 2 = 2
            右边如果是even的话，head还是2， increase = 2 * 2 = 4
            左边划掉， head要变成6，跟之前差了4， head = head + increase，prevhead = 2 =》 increase = 4

            */
            public int lastRemaining(int n) {
                int steps = 1;
                int head = 1;
                boolean left = true;
                while(n > 1){
                    if(left || n % 2 == 1){
                        head += steps;
                    }
                    left = !left;
                    steps *= 2;
                    n = n / 2;
                }
                return head;
            }
        }
    }
