package Bloomberg2;

public class lt1274countShips {

/*
Quartered Search
拆分成四分，左下，左上，右下，右上，
recursion，先看当前区块有没有ship，没有的话返回，
有的话，边界条件，topRight跟bottomLeft是重合的一个点，返回1
不然的话就继续拆分成4块，再返回
*/
      class Sea {
          public boolean hasShips(int[] topRight, int[] bottomLeft){
              return true;
          }
      }
    class Solution {
        public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
            if(!sea.hasShips(topRight, bottomLeft)){
                return 0;
            }
            //has ship and stop case, topright = bottomleft, a point
            if(topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]){
                return 1;
            }
            int midX = (topRight[0] + bottomLeft[0]) / 2;
            int midY = (topRight[1] + bottomLeft[1]) / 2;
            int leftBot = countShips(sea, new int[]{midX, midY}, bottomLeft);
            int leftTop = countShips(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY + 1});
            int rightBot = countShips(sea, new int[]{topRight[0], midY},new int[]{midX + 1, bottomLeft[1]});
            int rightTop = countShips(sea, topRight, new int[]{midX + 1, midY + 1});
            return leftBot + leftTop + rightBot + rightTop;
        }
    }
}
