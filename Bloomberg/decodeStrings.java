package Bloomberg;

import java.util.Stack;

public class decodeStrings {
    /*
    Stack Object类来放Integer跟String，遇到digit就累积，遇到[就把count放进stack，重置count，遇到char就放进去，遇到]的话，
    先把stack上面到integer为止的string都pop出来，然后再根据count来倍数增加，再放回stack

     */
    class SolutionOneStack{
        public String decodeString(String s) {
            Stack<Object> stack = new Stack<>();
            int num = 0;
            for(char c : s.toCharArray()){
                if(Character.isDigit(c)){
                    num = num * 10 + (c-'0');
                }
                else if(c == '['){
                    stack.push(Integer.valueOf(num));
                    num = 0;
                }
                else if(c == ']'){
                    String newStr = helper(stack);
                    Integer count = (Integer)stack.pop();
                    for(int i = 0; i < count; i++){
                        stack.push(newStr);
                    }
                }else{
                    stack.push(String.valueOf(c));
                }
            }

            return helper(stack);
        }

        private String helper(Stack<Object> stack){
            Stack<String> tmp = new Stack<>();
            StringBuffer sb = new StringBuffer();
            while(!stack.isEmpty() && stack.peek() instanceof String){
                sb.insert(0, stack.pop());
            }
            return sb.toString();
        }
    }
    class SolutionTwoStack{
        public String decodeString(String s) {
            Stack<Integer> counts = new Stack<>();
            Stack<String> strs = new Stack<>();
            int idx = 0;
            String cur = "";
            while(idx < s.length()){
                char c = s.charAt(idx);
                if(Character.isDigit(c)){
                    int count = 0;
                    while(Character.isDigit(c)){
                        count = count * 10 + (c-'0');
                        idx++;
                        c = s.charAt(idx);
                    }
                    counts.push(count);
                }
                else if(c == '['){
                    strs.push(cur);
                    cur = "";
                    idx++;
                }
                else if(c == ']'){
                    StringBuffer tmp = new StringBuffer();
                    //先把之前的结果append到tmp里面，然后再把
                    tmp.append(strs.pop());
                    int count = counts.pop();
                    for(int i = 0 ; i < count; i++){
                        tmp.append(cur);
                    }
                    cur = tmp.toString();
                    idx++;
                }
                else{
                    cur += c;
                    idx++;
                }
            }
            return cur;
        }
    }

}
