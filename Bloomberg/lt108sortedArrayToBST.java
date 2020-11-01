package Bloomberg;

public class lt108sortedArrayToBST {

    class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }

        private TreeNode helper(int[] nums, int s, int e){
            if(s > e){
                return null;
            }
            if(s == e){
                return new TreeNode(nums[s]);
            }
            int mid = (s + e) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, s, mid - 1);
            root.right = helper(nums, mid + 1, e);
            return root;
        }
    }
}
