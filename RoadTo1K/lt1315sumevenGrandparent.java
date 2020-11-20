package RoadTo1K;

public class lt1315sumevenGrandparent {

    /*
    这题解题思路很简单，如果当前的node是even的直接去看他有没有grandchild，有的话累积sum，
    返回遍历左右subtree，把所有even node的grandchild的的值加上就结束
    不会有重复累积，因为我们在当前level永远看的是下面的level

     */
    class Solution {
        int sum = 0;
        public int sumEvenGrandparent(TreeNode root) {
            if(root == null){
                return 0;
            }
            if(root.val % 2 == 0){
                findGrandChild(root.left);
                findGrandChild(root.right);
            }
            sumEvenGrandparent(root.left);
            sumEvenGrandparent(root.right);
            return sum;
        }

        private void findGrandChild(TreeNode root){
            if(root == null){
                return;
            }
            //left Grandchild
            if(root.left != null){
                sum += root.left.val;
            }
            //right GrandChild
            if(root.right != null){
                sum += root.right.val;
            }
        }
    }
}
