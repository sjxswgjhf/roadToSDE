package binarysearch;

import java.util.HashMap;

public class bs356buildTreePreAndIn {

    class Solution {

        HashMap<Integer, Integer> map;
        int preIdx;
        public Tree solve(int[] preorder, int[] inorder) {
            map = new HashMap<>();
            for(int i = 0 ; i < inorder.length; i++){
                map.put(inorder[i], i);
            }
            preIdx = 0;
            return helper(preorder, 0, preorder.length - 1);
        }

        private Tree helper(int[] preorder, int l, int r){
            if(l > r){

                return null;
            }
            Tree node = new Tree(preorder[preIdx]);
            int idx = map.get(preorder[preIdx]);
            preIdx++;
            node.left = helper(preorder, l, idx - 1);
            node.right = helper(preorder, idx + 1, r);
            return node;
        }
    }

}
