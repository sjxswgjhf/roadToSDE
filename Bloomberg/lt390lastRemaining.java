package Bloomberg;

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
