package facebook;

import java.util.ArrayList;
import java.util.List;

public class treeToDoublyList {


// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};


    class SolutionRecursion{
        Node prev = null;
        public Node treeToDoublyList(Node root){
            //corner case
            if(root == null){
                return null;
            }
            Node dummy = new Node(0, null, null);
            prev = dummy;
            helper(root);
            //这里需要handle首尾，真正的head是dummy right的1，尾巴是prev=5(关键, recursion结束的时候，prev就是变成5了）
            prev.right = dummy.right;
            dummy.right.left = prev;
            return dummy.right;
        }

        private void helper(Node cur){
            if(cur == null){
                return;
            }
            //left-middle-right, inorder
            //recursion特性， 先走到最左，这时候prev是dummy，cur是1，然后互联，把prev设成1，返回到2，然后2跟1回来蛇改prev，再去3...直到循环结束
            helper(cur.left);
            prev.right = cur;
            cur.left = prev;
            prev = cur;
            helper(cur.right);
        }
    }

    class SolutionBad {

        public Node treeToDoublyList(Node root) {
            List<Node> inorder = new ArrayList<>();
            helper(root, inorder);

            if(inorder.size() == 0){
                return null;
            }
            if(inorder.size() == 1){
                Node node = inorder.get(0);
                node.left = node;
                node.right = node;
                return node;
            }
            Node head, tail;
            Node node = inorder.get(0);
            node.left = inorder.get(inorder.size() - 1);
            node.right = inorder.get(1);
            head = node;
            for(int i = 1; i < inorder.size(); i++){
                node = inorder.get(i);
                if(i < inorder.size() - 1){
                    node.right = inorder.get(i + 1);
                }else{
                    node.right = head;
                }
                node.left = inorder.get(i - 1);
            }
            return head;
        }

        private void helper(Node root, List<Node> inorder){
            if(root == null){
                return;
            }
            helper(root.left, inorder);
            inorder.add(root);
            helper(root.right, inorder);
        }
    }
}
