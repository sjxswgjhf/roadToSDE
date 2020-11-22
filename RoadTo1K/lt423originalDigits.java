package RoadTo1K;

import java.util.Arrays;

public class lt423originalDigits {

    class Solution {

        /*
        words = "zero","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
                 1 z    1 w             1 u             1 x              1 g
        words = "one", "", "three", "", "five", "", "seven", "", "nine"
                 2 o          2 h
        words = "five", "seven", "nine"
                  3 i
        words = "seven", "nine"
                  4 v      4 i

         通过特殊char来确定digit，根据顺序去找数字，减少相对应的freq，注意重复的情况，所以helper里面要while loop把一个数字的所有
         情况都找出来
        */
        public String originalDigits(String s) {
            int[] counts = new int[26];
            for(char c : s.toCharArray()){
                counts[c - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            setWord(sb, counts, "zero", 0);
            setWord(sb, counts, "two", 2);
            setWord(sb, counts, "four", 4);
            setWord(sb, counts, "six", 6);
            setWord(sb, counts, "eight", 8);
            setWord(sb, counts, "one", 1);
            setWord(sb, counts, "three", 3);
            setWord(sb, counts, "five", 5);
            setWord(sb, counts, "seven", 7);
            setWord(sb, counts, "nine", 9);
            char[] cs = sb.toString().toCharArray();
            Arrays.sort(cs);
            return new String(cs);
        }

        private void setWord(StringBuffer sb, int[] counts, String word, int val){
            int[] wordcount = new int[26];
            for(char c : word.toCharArray()){
                wordcount[c-'a']++;
            }
            boolean enough = true;
            while(enough){
                for(int i = 0; i < 26; i++){
                    if(counts[i] < wordcount[i]){
                        enough = false;
                        break;
                    }
                }
                if(enough){
                    for(int i = 0; i < 26; i++){
                        counts[i] -= wordcount[i];
                    }
                    sb.append(val);
                }
            }
        }
    }
}
