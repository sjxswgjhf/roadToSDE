package BloombergOnsite;

import java.util.HashMap;

public class lt543diameterOfBinaryTree {


    class Solution {
        public int lengthOfLongestSubstringKDistinct(String s, int k) {
            HashMap<Character, Integer> map = new HashMap<>();
            int l = 0;
            int max = 0;

            for(int r = 0; r < s.length(); r++){
                char c = s.charAt(r);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if(map.size() <= k){
                    max = Math.max(max, r - l + 1);
                }
                while(l <= r && map.size() > k){
                    char old = s.charAt(l);
                    map.put(old, map.get(old) - 1);
                    if(map.get(old) == 0){
                        map.remove(old);
                    }
                    l++;
                }
            }
            return max;
        }
    }

    class SolutionQueue {
        int res = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            if(root == null){
                return 0;
            }
            dfs(root);
            return res;
        }

        private int dfs(TreeNode root){
            if(root == null){
                return 0;
            }
            if(root.left == null && root.right == null){
                return 1;
            }
            int left = dfs(root.left);
            int right = dfs(root.right);
            res = Math.max(res, left + right);
            return Math.max(left, right) + 1;
        }
    }
}
