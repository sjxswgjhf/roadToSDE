package RoadTo1K;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lt894allPossibleFBT {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        /*
        这题跟lt95很像
        首先节点数量肯定是奇数,
        然后5的话里面有3的情况的解

        //1. if N = 3 , the number of nodes combination are as follows
        //      left    root    right
        //       1       1        1
        //--------------N = 3, res = 1----------

        //2. if N = 5 , the number of nodes combination are as follows
        //      left    root    right
        //       1       1        3 (recursion)
        //       3       1        1
        //  --------------N = 5, res = 1 + 1 = 2----------

        //3. if N = 7 , the number of nodes combination are as follows
        //      left    root    right
        //       1       1        5 (recursion)
        //       3       1        3
        //       5       1        1
        //  --------------N = 7, res = 2 + 1 + 2 = 5----------

        //4. in order to make full binary tree, the node number must increase by 2
        */
        HashMap<Integer, List<TreeNode>> memo = new HashMap();
        public List<TreeNode> allPossibleFBT(int N) {
            if(memo.containsKey(N)){
                return memo.get(N);
            }
            List<TreeNode> res = new ArrayList<>();
            if(N % 2 == 0){
                return res;
            }
            if(N == 1){
                res.add(new TreeNode(0));
                return res;
            }
            //left subtree
            for(int i = 1; i < N; i += 2){  //有效值永远是1，3，5，7，9
                int j = N - i - 1;  //这里N-i是去掉了leftsub的情况，-1是因为root也要考虑进去，所以最后是N-i-1也满足了一直是odd的条件
                for(TreeNode left : allPossibleFBT(i)){     //use recursion 构建左子树的所有情况
                    for(TreeNode right : allPossibleFBT(j)){
                        //构建所有情况
                        TreeNode root = new TreeNode(0);
                        root.left = left;
                        root.right = right;
                        res.add(root);
                    }
                }
            }
            memo.put(N, res);
            return res;
        }
    }
}
