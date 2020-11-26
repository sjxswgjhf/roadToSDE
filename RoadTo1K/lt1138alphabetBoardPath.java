package RoadTo1K;

public class lt1138alphabetBoardPath {

    class Solution {
    /*
    0,0 0,1 0,2 0,3 0,4
    1,0 1,1 1,2 1,3 1,4
    ...
    ...
    ...
    5,0
     move up before moving right, and move left before moving down.
    */

        public String alphabetBoardPath(String target) {
            if(target == null){
                return "";
            }
            char[] cs = target.toCharArray();
            StringBuffer sb = new StringBuffer();
            int previ = 0, prevj = 0;
            for(int i = 0; i < cs.length; i++){
                int curi = (cs[i] - 'a') / 5;
                int curj = (cs[i] - 'a') % 5;
                if(curi == previ && curj == prevj){
                    sb.append("!");
                }else{
                    findPath(sb, previ, prevj, curi, curj);
                    sb.append("!");
                    previ = curi;
                    prevj = curj;
                }
            }
            return sb.toString();
        }
        /*
        因为z的远古，我们要走右边的话，先要走上边，我们要走下边的话，先走左边,才能确保走的是正确的路径，因为z那一行的限制
        cur是目的地，prev是先前位置，
        */
        private void findPath(StringBuffer sb, int previ, int prevj, int curi, int curj){
            //向上走
            while(curi < previ){
                sb.append("U");
                curi++;
            }
            //向右
            while(curj > prevj){
                sb.append("R");
                curj--;
            }
            //向左
            while(curj < prevj){
                sb.append("L");
                curj++;
            }
            //向下
            while(curi > previ){
                sb.append("D");
                curi--;
            }
            /*
            这部分的逻辑是当前位置怎么当先前位置，上面的是先前的怎么到当前的，我觉得更符合我的逻辑
            while(curi < previ){
                sb.append("U");
                curi++;
            }

            while(curj > prevj){
                sb.append("R");
                curj--;
            }

            while(curj < prevj){
                sb.append("L");
                curj++;
            }

            while(curi > previ){
                sb.append("D");
                curi--;
            }
            */
        }
    }
}
