package RoadTo1K;

public class lt365canMeasureWater {

    class Solution {
        /*
        ax + by = m
        有整数解只存在于 m是x跟y的gcd的整数倍

        需要记得高效的求gcd的方法
        */
        public boolean canMeasureWater(int x, int y, int z) {
            if(x + y < z){
                return false;
            }
            if(x + y == z || x == z || y == z){
                return true;
            }
            return z % gcd(x,y) == 0;
        }

        private int gcd(int x, int y){
            while(y != 0){
                int tmp = y;
                y = x % y;
                x = tmp;
            }
            return x;
        }
    }
}
