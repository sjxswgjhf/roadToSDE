package RoadTo1K;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lt958isCompleteTree {

    class Solution {
    /*
    用complete binary tree的性质，如果从上往下编号的话
    左子树是parent的idx*2，右子树是*2+1
     1
   2   3
  4 5 6 7
   我们利用这个特性，如果最后的一个node的idx是等于整个的size的那么就是complete binary tree，如果最后一个node不等于size，那么说明不是complete binary tree

     1
   2   3
  4 5 6
  size = 6, idx = 6 => true

     1
   2   3
  4 5 x 7
  size = 6, idx = 7 => false

    */

        class Node{
            int idx;
            TreeNode root;
            public Node(int i, TreeNode n){
                this.idx = i;
                this.root = n;
            }
        }

        public boolean isCompleteTree(TreeNode root) {
            if(root == null){
                return true;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(1, root));
            int total = 0;
            List<Node> list = new ArrayList<>();
            while(!queue.isEmpty()){
                int size = queue.size();
                total += size;
                for(int i = 0; i < size; i++){
                    Node node = queue.poll();
                    list.add(node);
                    if(node.root.left != null){
                        queue.add(new Node(node.idx * 2, node.root.left));
                    }
                    if(node.root.right != null){
                        queue.add(new Node(node.idx * 2 + 1, node.root.right));
                    }
                }
            }
            return list.get(list.size() - 1).idx == total;
        }

    }
}
