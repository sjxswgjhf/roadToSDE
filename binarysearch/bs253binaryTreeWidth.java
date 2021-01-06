package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class bs253binaryTreeWidth {

    class Solution {
        /*
        ask for the max width among all levels
        思考下full binary tree的每层宽度就是最左跟最右的差距，然后我们也知道
        binary tree可以用来标记，left是parent idx *2， right是parent*2+1
        利用这个性质，我们就可以根据level来做了，每层一开始的时候把最左边的idx放进去，
        同层的计算宽度就是idx - leftMost + 1了
         */
        int max = 0;
        public int solve(Tree root) {
            if(root == null){
                return 0;
            }
            List<Integer> list = new ArrayList<>();
            dfs(root, 1, 0, list);
            return max;
        }

        private void dfs(Tree root, int id, int level, List<Integer> list){
            if(root == null){
                return;
            }
            if(list.size() == level){
                list.add(id);
            }
            max = Math.max(max, id - list.get(level) + 1);
            dfs(root.left, id * 2, level + 1, list);
            dfs(root.right, id * 2 + 1, level + 1, list);
        }
    }
}
