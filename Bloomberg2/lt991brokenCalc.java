package Bloomberg2;

public class lt991brokenCalc {

    class Solution {
        /*
        反着思考，y怎么到x，我们肯定希望尽可能的/2，减肯定没有/2来的快,当我们得到的y <= x的时候，我们只要+一定步数就到了x，

        y is even, (Y + 2) / 2 > (y / 2) + 1
        y is odd, (Y + 3) / 2 > (y + 1) / 2 + 1

        */
        public int brokenCalc(int X, int Y) {
            int ans = 0;
            while(Y > X){
                ans++;
                //一次做一步操作
                if(Y % 2 == 0){
                    Y = Y / 2;
                }else{
                    Y = Y + 1;
                }
            }
            return ans + X - Y;
        }

    }
}
