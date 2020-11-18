package RoadTo1K;

import java.util.ArrayList;
import java.util.List;

public class lt592fractionAddition {

    class Solution {

        class Node{
            long n;
            long d;
            int s;
            public Node(long n, long d, int s){
                this.n = n;
                this.d = d;
                this.s = s;
            }
        }

        public String fractionAddition(String exp) {
            int l = 0;
            int r = 0;
            int len = exp.length();
            int sign = 1;
            List<Node> list = new ArrayList<>();
            while(r < len){
                //check first char is sign or not
                if(l == r && !Character.isDigit(exp.charAt(r))){
                    sign = exp.charAt(r) == '-' ? -1 : 1;
                    r++;
                }
                long top = 0;
                //top
                while(r < len && exp.charAt(r) != '/'){
                    top = top * 10 + (exp.charAt(r) - '0');
                    r++;
                }
                //skip /
                r++;
                //bot
                long bot = 0;
                while(r < len && Character.isDigit(exp.charAt(r))){
                    bot = bot * 10 + (exp.charAt(r) - '0');
                    r++;
                }
                Node node = new Node(top, bot, sign);
                list.add(node);
                l = r;
                sign = 1;

            }
            long commonD = findCommon(list);
            for(Node node : list){
                long factor = commonD / node.d;
                node.n = node.n * factor;
            }
            long top = 0;
            for(Node node : list){
                top += node.n * node.s;
            }
            int sig = top == 0 ? 1 : (int)(top / Math.abs(top));
            int reduce = reduce(Math.abs(top), commonD);
            StringBuffer sb = new StringBuffer();
            if(sig < 0){
                sb.append("-");
            }
            int nt = Math.abs((int)(top / reduce));
            int nb = nt == 0 ? 1 : (int)(commonD / reduce);
            sb.append(nt);
            sb.append("/");
            sb.append(nb);
            return sb.toString();
        }

        private int reduce(long top, long bot){
            long min = Math.min(top, bot);
            for(long i = min; i >= 2; i--){
                if(top % i == 0 && bot % i == 0){
                    return (int)i;
                }
            }
            return 1;
        }

//        static int gcd(int a, int b)
//        {
//            if (b == 0)
//                return a;
//            return gcd(b, a % b);
//        }

        private long findCommon(List<Node> list){
            long res = 1;
            for(Node node : list){
                res *= node.d;
            }
            return res;
        }
    }
}
