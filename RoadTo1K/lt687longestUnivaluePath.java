package RoadTo1K;

public class lt687longestUnivaluePath {
    class Solution {
        /*
        先recursion左跟右，如果node是null或者leaf都是返回0,因为没有path存在，
        但是上一层的root需要查看左右返回的path的长度，如果跟left或right跟root的值一样的话，就需要把path跟当前root的合并上，
        然后root带着左右的path length去跟max比较，然后返回给上一层的时候，只能返回一边的path，选较长的那个,
        这道题跟path sum有点类似
        */
        int max = 0;
        public int longestUnivaluePath(TreeNode root) {
            if(root == null){
                return 0;
            }
            findlongestPath(root);
            return max;
        }

        private int findlongestPath(TreeNode root){
            if(root == null){
                return 0;
            }
            if(root.left == null && root.right == null){
                return 0;
            }
            int l = root.left == null ? 0 : findlongestPath(root.left);
            int r = root.right == null ? 0 : findlongestPath(root.right);
            int wl = root.left != null && root.val == root.left.val ? l + 1 : 0;
            int wr = root.right != null && root.val == root.right.val ? r + 1 : 0;
            max = Math.max(max, wl + wr);
            return Math.max(wr, wl);
        }
    }
}
