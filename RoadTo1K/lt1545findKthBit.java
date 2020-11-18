package RoadTo1K;

public class lt1545findKthBit {

    class Solution {
        /*
        S1 = "0"
        Si = Si-1 + "1" + reverse(invert(Si-1)) for i > 1

        S1 = 0  1
        S2 = 0 + 1 + 1 = 0 1 1 3  中间位永远是1
        S3 = 011 + 1 + 001 = 0111001 7
        S4 = 0111001 1 0110001
        1 -> 3 -> 7 -> 15
        len = 1 << n - 1

        mid-1 对应 mid+1 但是flip了

        如果 k 在 左半边，我们不干啥，如果再右半边，我们从后往前找，找到之后flip就对了
        即 k > mid的时候，我们去看左边Si-1的第len - k + 1位
        不然就是看Si-1的第k位
        */
        public char findKthBit(int n, int k) {
            if(n == 1){
                return '0';
            }
            int len = (1 << n) - 1;
            if(k == len / 2 + 1){
                return '1';
            }
            else if(k > len / 2 + 1){
                return findKthBit(n - 1, len - k + 1) == '0' ? '1' : '0';
            }else{
                return findKthBit(n - 1, k);
            }
        }
    }

    class SolutionBF {
        /*
        BF 就是一点点变化知道n，然后再看第k个，估计TLE,但是n最大是20，这题所以能过去
        */
        public char findKthBit(int n, int k) {
            String s = "0";
            String prev = "0";
            String res = new String();
            for(int i = 0; i < n; i++){
                res = prev + "1" + reverse(invert(prev));
                prev = res;
            }
            return res.charAt(k - 1);
        }

        private String reverse(char[] cs){
            for(int i = 0, j = cs.length - 1; i < j; i++, j--){
                char tmp = cs[i];
                cs[i] = cs[j];
                cs[j] = tmp;
            }
            return new String(cs);
        }

        private char[] invert(String str){
            char[] cs = str.toCharArray();
            for(int i = 0; i < cs.length; i++){
                cs[i] = cs[i] == '0' ? '1' : '0';
            }
            return cs;
        }
    }
}
