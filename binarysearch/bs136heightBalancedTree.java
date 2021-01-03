package binarysearch;

import java.util.HashMap;

public class bs136heightBalancedTree {

    /*
    直接用global val记录isBalance or not，因为有一个node不是了所有多不是了
     */
    class Solution {
        boolean isBalance = true;
        public boolean solve(Tree root) {
            if(root == null){
                return true;
            }
            int left = findHeight(root.left);
            int right = findHeight(root.right);
            // System.out.println(left + " " + right);
            if(Math.abs(left -right) <= 1){
                return isBalance;
            }
            return false;
        }

        private int findHeight(Tree root){
            if(root == null){
                return 0;
            }
            int left = findHeight(root.left);
            int right = findHeight(root.right);
            if(Math.abs(left - right) > 1){
                isBalance = false;
            }
            return Math.max(left, right) + 1;
        }
    }

    /*
    用map存了所有child的height的diff再去loop， n + n = 2n的time complexity
     */
    class SolutionN {
        HashMap<Tree, Integer> map;
        public boolean solve(Tree root) {
            if(root == null){
                return true;
            }
            map = new HashMap<>();
            int left = findHeight(root.left);
            int right = findHeight(root.right);
            // System.out.println(left + " " + right);
            if(Math.abs(left -right) <= 1){
                // if(solve(root.left) && solve(root.right)){
                //     return true;
                // }
                // else{
                //     return false;
                // }
                for(Tree key : map.keySet()){
                    if(map.get(key) > 1){
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        private int findHeight(Tree root){
            if(root == null){
                return 0;
            }
            int left = findHeight(root.left);
            int right = findHeight(root.right);
            map.put(root, Math.abs(left - right));
            return Math.max(left, right) + 1;
        }
    }

    class SolutionNN {
        public boolean solve(Tree root) {
            if(root == null){
                return true;
            }
            int left = findHeight(root.left);
            int right = findHeight(root.right);
            // System.out.println(left + " " + right);
            if(Math.abs(left -right) <= 1){
                if(solve(root.left) && solve(root.right)){
                    return true;
                }
                else{
                    return false;
                }
            }
            return false;
        }

        private int findHeight(Tree root){
            if(root == null){
                return 0;
            }
            int left = findHeight(root.left);
            int right = findHeight(root.right);
            return Math.max(left, right) + 1;
        }
    }
}
