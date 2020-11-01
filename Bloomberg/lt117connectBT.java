package Bloomberg;

import java.util.LinkedList;
import java.util.Queue;

public class lt117connectBT {

    class Solution {

        //当前层的最左边
        Node leftMost;
        //前一个node
        Node prev;

        public Node connect(Node root) {
            if(root == null){
                return root;
            }
            leftMost = root;
            //开始当前层的链接
            while(leftMost != null){
                //初始化 cur = 最左边。prev为null
                Node cur = leftMost;
                prev = null;
                //为下一层设置为null
                leftMost = null;
                while(cur != null){
                    processChild(cur.left);
                    processChild(cur.right);
                    cur = cur.next;
                }
            }
            return root;
        }

        private void processChild(Node root){
            if(root == null){
                return;
            }
            else{
                if(leftMost == null){
                    leftMost = root;
                }
                if(prev == null){
                    prev = root;
                }else{
                    prev.next = root;
                    prev = prev.next;
                }
            }
        }
    }


/*
 BFS，当前层把下一层加到queue, n space
*/
    class SolutionBFS {
        public Node connect(Node root) {
            if(root == null){
                return null;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0 ; i< size; i++){
                    Node cur = queue.poll();
                    if(cur.left != null){
                        queue.add(cur.left);
                    }
                    if(cur.right != null){
                        queue.add(cur.right);
                    }
                    cur.next = i == size - 1 ? null : queue.peek();
                }
            }
            return root;
        }
    }
}
