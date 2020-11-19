package RoadTo1K;

public class lt1026maxAncestorDiff {

    class Solution {
        /*
        在recursion的时候，我知道ancestor的最大值或者最小值的话，我就能找到最大dif
        */
        int max = Integer.MIN_VALUE;
        public int maxAncestorDiff(TreeNode root) {
            if(root == null){
                return 0;
            }
            helper(root.left, root.val, root.val);
            helper(root.right, root.val, root.val);
            return max;
        }

        private void helper(TreeNode root, int maxPVal, int minPVal){
            if(root == null){
                return;
            }
            int dif1 = Math.abs(root.val - maxPVal);
            int dif2 = Math.abs(root.val - minPVal);
            max = Math.max(max, Math.max(dif1, dif2));
            helper(root.left, Math.max(maxPVal, root.val), Math.min(root.val, minPVal));
            helper(root.right, Math.max(maxPVal, root.val), Math.min(root.val, minPVal));
        }

    }
}
