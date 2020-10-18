package Bloomberg;

public class connectBST {

    class Solution {
        public Node connect(Node root) {
            if(root == null){
                return null;
            }
            //left为空，说明right也没有，是个leaf，直接return
            if(root.left == null){
                return root;
            }
            //left不为空，先把left跟right相连接
            root.left.next = root.right;
            //如果当前level是第二层，虽然我们已经连接了各自children的left跟right，我们还要链接中间那个next
            //那么首先当前root的下一格不为空，我们需要链接
            //当前root的右边的下边就是root下面的左边
            if(root.next != null){
                root.right.next = root.next.left;
            }
            connect(root.left);
            connect(root.right);
            return root;
        }
    }
}
