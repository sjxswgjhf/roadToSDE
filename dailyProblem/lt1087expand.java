package dailyProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lt1087expand {


    class Solution {
        public String[] expand(String S) {
            List<String> list = new ArrayList<>();
            dfs(S, 0, new StringBuffer(), list);
            String[] res = new String[list.size()];
            for(int i = 0; i < list.size(); i++){
                res[i] = list.get(i);
            }
            return res;
        }

        private void dfs(String s, int idx, StringBuffer sb, List<String> list){
            if(idx == s.length()){
                list.add(sb.toString());
                return;
            }
            char c = s.charAt(idx);
            int oldlen = sb.length();
            if(c == '{'){
                List<Character> charList = new ArrayList<>();
                int tmpIdx = idx + 1;
                while(tmpIdx < s.length() && s.charAt(tmpIdx) != '}'){
                    if(s.charAt(tmpIdx) != ','){
                        charList.add(s.charAt(tmpIdx));
                    }
                    tmpIdx++;
                }
                //这里sort完， 最后不需要sort了
                Collections.sort(charList);
                for(char d : charList){
                    sb.append(d);
                    dfs(s, tmpIdx + 1, sb, list);
                    sb.setLength(oldlen);
                }
            }
            else if(Character.isLetter(c)){
                sb.append(c);
                dfs(s, idx + 1, sb, list);
            }
        }

    }
}
