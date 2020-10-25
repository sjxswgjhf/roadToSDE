package weeklyContest;

public class lt1629wk212 {

    /*
    就很烦这种一大段的题，老是看错情况，这题要求每个char的最大duration保留，我一开始做的还以为是累积duration，后来又以为是更新duration，
    题目没有讲很清楚，例子也不太好。还是要注意。花了20分钟。。其实只要2分钟
    */

    class Solution {
        public char slowestKey(int[] release, String kp) {

            int[] durations = new int[26];
            for(int i = 0 ; i < release.length; i++){
                char c = kp.charAt(i);
                if(i == 0){
                    durations[c - 'a'] = release[0];
                }else{
                    durations[c - 'a'] = Math.max(durations[c-'a'], release[i] - release[i - 1]);
                }
            }
            int maxDuration = 0;
            char res = 'a';
            for(int i = 0; i < 26; i++){
                char c = (char)(i + 'a');
                if(durations[c - 'a'] > maxDuration){
                    res = c;
                    maxDuration = durations[c - 'a'];
                }
                else if(durations[c - 'a'] == maxDuration){
                    if(c > res){
                        res = c;
                    }
                }
            }

            return res;
        }
    }
}