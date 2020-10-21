package Bloomberg;

import java.util.*;

public class lt784letterCasePermutation {

    /*
    这个方法巧妙，先把原来的放进去，然后遍历S，如果遇到了char的话，那么把queue里面的都pop出来，改变当前queue里面的所有str的当前char的
    大小写然后加入回去，这样每次遇到char的时候，虽然所有的都被清空了，但是我们不仅加入了pop出来的。还加入了改变了大小写的。到最后的所有
    的情况都解决了
     */
    class SolutionBFS {
        public List<String> letterCasePermutation(String S) {
            if (S == null) {
                return new LinkedList<>();
            }
            Queue<String> queue = new LinkedList<>();
            queue.offer(S);

            for (int i = 0; i < S.length(); i++) {
                if (Character.isDigit(S.charAt(i))) continue;
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    String cur = queue.poll();
                    char[] chs = cur.toCharArray();

                    chs[i] = Character.toUpperCase(chs[i]);
                    queue.offer(String.valueOf(chs));

                    chs[i] = Character.toLowerCase(chs[i]);
                    queue.offer(String.valueOf(chs));
                }
            }

            return new LinkedList<>(queue);
        }
    }

    class SolutionBFSSlow {
        public List<String> letterCasePermutation(String s) {
            List<String> res = new ArrayList<>();
            Queue<String> queue = new LinkedList<>();
            HashSet<String> seen = new HashSet<>();
            queue.add(s);
            int n = s.length();
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    String cur = queue.poll();
                    if(seen.contains(cur)){
                        continue;
                    }
                    res.add(cur);
                    seen.add(cur);
                    char[] cs = cur.toCharArray();
                    for(int j = 0 ;j < s.length(); j++){
                        if(Character.isDigit(cs[j])){
                            continue;
                        }
                        cs[j] = Character.toUpperCase(cs[j]);
                        queue.add(new String(cs));
                        cs[j] = Character.toLowerCase(cs[j]);
                        queue.add(new String(cs));
                    }
                }
            }
            return res;
        }
    }


}
