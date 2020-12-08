package dailyProblem;

import java.util.Stack;

public class lt71simplifyPath {

    /*
    这题更简便的做法是直接把string按/分成各个substring，然后直接判断substring的情况,会更简单明了
     */

    class Solution {
        public String simplifyPath(String path) {
            int r = 0;
            int n = path.length();
            Stack<String> stack = new Stack<>();
            while(r < n){
                String tmp = "";
                if(path.charAt(r) == '/'){
                    while(r < n && path.charAt(r) == '/'){
                        r++;
                    }
                }
                else if(path.charAt(r) == '.'){
                    while(r < n && path.charAt(r) != '/'){
                        tmp += String.valueOf(path.charAt(r));
                        r++;
                    }
                    if(tmp.equals(".")){
                        continue;
                    }
                    else if(tmp.equals("..")){
                        if(stack.isEmpty()){
                            continue;
                        }else{
                            stack.pop();
                        }
                    }else{
                        stack.push(tmp);
                    }
                }
                else{
                    while(r < n && path.charAt(r) != '.' && path.charAt(r) != '/'){
                        tmp += String.valueOf(path.charAt(r));
                        r++;
                    }
                    stack.push(tmp);
                }
            }

            String res = "";
            if(stack.isEmpty()){
                return "/";
            }
            while(!stack.isEmpty()){
                res = "/" + stack.pop() + res;
            }
            return res;
        }
    }
}
