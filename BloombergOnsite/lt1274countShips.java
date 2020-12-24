package BloombergOnsite;

public class lt1274countShips {

    /**
     * // This is Sea's API interface.
     * // You should not implement it, or speculate about its implementation
     */
 /*

拆成四份，然后分别递归求解，注意边界不能overlap
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
            if(topRight[0] == bottomLeft[0] && topRight[1] == bottomLeft[1]){
                return 1;
            }
            int midX = (topRight[0] + bottomLeft[0]) / 2;
            int midY = (topRight[1] + bottomLeft[1]) / 2;
            int leftBot = countShips(sea, new int[]{midX, midY}, bottomLeft);
            int leftTop = countShips(sea, new int[]{midX, topRight[1]}, new int[]{bottomLeft[0], midY + 1});
            int rightBot = countShips(sea, new int[]{topRight[0], midY}, new int[]{midX + 1, bottomLeft[1]});
            int rightTop = countShips(sea, topRight, new int[]{midX + 1, midY + 1});
            return leftBot + leftTop + rightBot + rightTop;
        }
    }
}
