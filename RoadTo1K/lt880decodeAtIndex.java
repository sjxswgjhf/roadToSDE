package RoadTo1K;

public class lt880decodeAtIndex {

    public String decodeAtIndex(String S, int K) {

        long curLength = 0;
        char c = 0;

        for (int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            if (Character.isDigit(c)) {
                curLength *= c - '0';
            }
            else {
                curLength++;
            }
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            c = S.charAt(i);
            if (Character.isDigit(c)) {
                curLength /= c - '0';
                K %= curLength;
            }
            else {
                if (K == 0 || K == curLength) {
                    return "" + c;
                }
                curLength--;
            }
        }

        throw null;
    }

    class SolutionHFG {

        /*
        可以用递归来做,如果当前的字符长度不够构成k的话，k--，
        如果遇到了digit，那么我们就是把
        */
        public String decodeAtIndex(String s, int k) {
            long count = 0;  //记录当前有多少个
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(Character.isLetter(c)){
                    count++;
                    if(count == k){
                        return String.valueOf(c);
                    }
                }else{
                    long times = c -'0';
                    //repeat了这么times-1次，加上原来的就是times次
                    //double之后不够，我们继续往后找
                    if(count * times < k){
                        count = count * times;
                    }
                    //扩展之后大于k了，然后我们发现k正好是可以被count整除的，那么说明我们就是取最后一个char就行，
                    else if(k % count == 0){
                        return decodeAtIndex(s.substring(0, i), (int)count);
                    }else{
                        //如果不能被count整除那么说明我们需要的是第x个char
                        return decodeAtIndex(s.substring(0, i), (int)(k % count));
                    }
                }
            }
            return "";
        }
    }

    /*
    one character at a time

    the character read is a lette => letter is written onto the tape

    the character read is a digit => entire current tape is repeatedly written d-1 more times in total

    leet2code3 K = 10

    2 <= S.length <= 100 1 <= K <= 10^9 => 不能print出来了找了

    leetleet => k
    */
    class SolutionMemoryTLE {
        public String decodeAtIndex(String s, int K) {

            //this is tap
            StringBuffer sb = new StringBuffer();

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(Character.isLetter(c)){
                    sb.append(c);
                    K--;
                    if(K == 0){
                        return String.valueOf(c);
                    }
                }
                if(Character.isDigit(c)){
                    int freq = (c - '0') - 1;
                    int len = sb.length();
                    String tmp = sb.toString();
                    for(int j = 0; j < freq; j++){
                        if(K <= len){
                            return String.valueOf(sb.charAt(K - 1));
                        }else{
                            sb.append(tmp);
                            K -= len;
                        }
                    }
                }
            }
            return "";
        }
    }

}
