package binarysearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class bs325BTToLL {


    //直接bfs就可以做到
    class Solution {
        public LLNode solve(Tree root) {
            if(root == null){
                return null;
            }
            Queue<Tree> queue = new LinkedList<>();
            queue.add(root);
            LLNode dummy = new LLNode(0);
            LLNode cur = dummy;
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    Tree node = queue.poll();
                    cur.next = new LLNode(node.val);
                    cur = cur.next;
                    if(node.left != null){
                        queue.add(node.left);
                    }
                    if(node.right != null){
                        queue.add(node.right);
                    }
                }
            }
            return dummy.next;
        }
    }

    //虽然也是N time N space，但是是2N的time，不是N的time
    class SolutionBad {
        public LLNode solve(Tree root) {
            if(root == null){
                return null;
            }
            List<List<Integer>> list = new ArrayList<>();
            helper(root, list, 0);
            LLNode dummy = new LLNode(0);
            LLNode cur = dummy;
            for(List<Integer> l : list){
                for(int num : l){
                    cur.next = new LLNode(num);
                    cur = cur.next;
                }
            }
            return dummy.next;
        }

        private void helper(Tree root, List<List<Integer>> list, int level){
            if(root == null){
                return;
            }
            if(list.size() == level){
                list.add(new ArrayList<>());
            }
            list.get(level).add(root.val);
            helper(root.left, list, level + 1);
            helper(root.right, list, level + 1);
        }
    }
}
