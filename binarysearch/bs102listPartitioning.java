package binarysearch;

public class bs102listPartitioning {


    class SolutionBest {
        public String[] solve(String[] strs) {
            int n = strs.length;
            int idx = 0;
            int end = n - 1;
            for(int i = 0; i <= end;){
                if(strs[i].equals("red")){
                    String tmp = strs[idx];
                    strs[idx] = strs[i];
                    strs[i] = tmp;
                    idx++;
                    i++;
                }
                else if(strs[i].equals("blue")){
                    String tmp = strs[end];
                    strs[end] = strs[i];
                    strs[i] = tmp;
                    end--;
                }else{
                    i++;
                }
            }
            return strs;
        }
    }

    /*
    可以从red跟green来操作
     */
    class Solution2 {
        public String[] solve(String[] strs) {
            int n = strs.length;
            int idx = 0;
            for(int i = 0; i < n; i++){
                if(strs[i].equals("red")){
                    String tmp = strs[idx];
                    strs[idx] = strs[i];
                    strs[i] = tmp;
                    idx++;
                }
            }
            for(int i = 0; i < n; i++){
                if(strs[i].equals("green")){
                    String tmp = strs[idx];
                    strs[idx] = strs[i];
                    strs[i] = tmp;
                    idx++;
                }
            }
            return strs;
        }
    }

    class Solution {
        public String[] solve(String[] strs) {
            String[] res = new String[strs.length];
            int idx = 0;
            for(int i = 0; i < strs.length; i++){
                if(strs[i].equals("red")){
                    res[idx] = "red";
                    idx++;
                }
            }
            for(int i = 0; i < strs.length; i++){
                if(strs[i].equals("green")){
                    res[idx] = "green";
                    idx++;
                }
            }
            for(int i = 0; i < strs.length; i++){
                if(strs[i].equals("blue")){
                    res[idx] = "blue";
                    idx++;
                }
            }
            return res;
        }
    }
}
