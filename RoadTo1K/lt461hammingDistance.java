package RoadTo1K;

public class lt461hammingDistance {

    class Solution {
        public int hammingDistance(int x, int y) {
            int mask = 1;
            int count = 0;
            for(int i = 0; i < 32; i++){
                //xor 0,0 = 0 1,1 = 0,  0,1=1,  1,0=1
                if(((x & mask) ^ (y & mask)) != 0){
                    count++;
                }
                mask = mask << 1;
            }

            return count;
        }
    }
}
