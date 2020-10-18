package Bloomberg;

import java.util.LinkedList;
import java.util.Queue;

public class connectBT {

    class Solution {
        public Node connect(Node root) {
            if(root == null){
                return null;
            }
            if(root.left == null && root.right == null){
                root.next = null;
                return root;
            }
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                //这里一定要用tmp value，因为queue是在变化的，要用tmp去判断，不能用queue
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    Node node = queue.poll();
                    if(i == size - 1){
                        node.next = null;
                    }
                    else{
                        node.next = queue.peek();
                    }
                    if(node.left != null){
                        queue.add(node.left);
                    }
                    if(node.right != null){
                        queue.add(node.right);
                    }
                }
            }
            return root;
        }
    }
}
