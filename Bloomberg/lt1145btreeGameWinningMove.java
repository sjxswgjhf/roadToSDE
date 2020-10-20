package Bloomberg;

public class lt1145btreeGameWinningMove {

    class Solution {
        /*
        1st p = red
        2nd p = blue

        idea: 简单来说，我就要选一个node，选完之后这个node所能color的数量要大于红色color的数量。
        那么简单的思想就是我肯定要选一个node是在red附近的，起码要堵住red的路线
        1. red的parent，检查red能涵盖的，n-red的就是我能涵盖的
        2. red没有parent或者parent不能满足我的要求，那我只能去左右找
        2.1 查看左右的subnode，哪个subnode多选哪个
        */
        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            TreeNode p1 = findNode(root, x);
            int p1Count = countNode(p1);
            int p1LeftCount = countNode(p1.left);
            int p1RightCount = countNode(p1.right);
            int parentCount = n - p1Count;
            if(parentCount > p1Count){
                return true;
            }
            else if(p1LeftCount > 1 + parentCount + p1RightCount){
                return true;
            }
            else if(p1RightCount > 1 + parentCount + p1LeftCount){
                return true;
            }
            return false;

        }

        public TreeNode findNode(TreeNode root, int x){
            if(root == null){
                return null;
            }
            if(root.val == x){
                return root;
            }
            TreeNode res = findNode(root.left, x);
            if(res == null){
                return findNode(root.right, x);
            }
            return res;
        }

        public int countNode(TreeNode root){
            if(root == null){
                return 0;
            }
            if(root.left == null && root.right == null){
                return 1;
            }
            return countNode(root.left) + countNode(root.right) + 1;
        }
    }
}
