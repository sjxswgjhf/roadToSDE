package binarysearch;

import java.util.ArrayList;
import java.util.List;

public class bs71levelOrderTraversal {


    class Solution {
        int size = 0;
        public int[] solve(Tree root) {
            if(root == null){
                return new int[0];
            }
            List<List<Integer>> list = new ArrayList<>();
            helper(root, 0, list);
            int[] res = new int[size];
            int idx = 0;
            for(List<Integer> cur : list){
                for(int i : cur){
                    res[idx++] = i;
                }
            }
            return res;
        }

        private void helper(Tree root, int level, List<List<Integer>> list){
            if(root == null) {
                return;
            }
            if(list.size() == level){
                list.add(new ArrayList<>());
            }
            list.get(level).add(root.val);
            size++;
            helper(root.left, level + 1, list);
            helper(root.right, level + 1, list);
        }
    }
}
