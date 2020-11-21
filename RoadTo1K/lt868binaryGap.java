package RoadTo1K;

public class lt868binaryGap {

    class Solution {
        /*
        这题考察bit的知识，
        先找第一个1的位置，从最右端开始，用prev去记录位置，取巧的先设成-1表示没遇到过，
        如果当prev>=0的话就表示遇到过了
        然后运用位运算知识，我们先向右移动i位，再跟1做and，我们就能只保留第i位的信息，如果是1就表示第i位是1，如果是0，表示第i位是0，我们忽略
        因为是整数型我们只用管32位，并且当shift之后的数已经小于等于0了，我们也就停止了
        */
        public int binaryGap(int n) {
            int prev = -1, res = 0;
            int shift = 0;
            for(int i = 0; i < 32; i++){
                if((n >> i) <= 0){
                    break;
                }else{
                    if(((n >>i) & 1) == 1){
                        if(prev >= 0){
                            res = Math.max(res, i - prev);
                        }
                        prev = i;
                    }
                }
            }
            return res;
        }
    }
}
