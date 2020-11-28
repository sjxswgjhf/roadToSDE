package dailyProblem;

import java.util.Stack;

public class lt901StockSpanner {

    class StockSpanner {
        /*
          0    1   2   3   4   5  6
        [100, 80, 60, 70, 60, 75, 85]
        [1,   1,   1,  2, 1,   4, 6]

        motonic increasing stack,因为如果当前的price比昨天的低，那么对于后面的来说，之前的都没有意义了,答案需要累积stack里面pop出来的值，
        因为那个值包含了之前所有比他小的数量
        */
        class Node{
            int price;
            int span;
            public Node(int p, int s){
                this.price = p;
                this.span = s;
            }
        }

        Stack<Node> stack;
        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            int res = 1;
            while(!stack.isEmpty() && stack.peek().price <= price){
                res += stack.pop().span;
            }
            Node node = new Node(price, res);
            stack.push(node);
            return res;
        }
    }

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
}
