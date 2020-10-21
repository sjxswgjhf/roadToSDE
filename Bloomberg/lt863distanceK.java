package Bloomberg;

import java.util.*;

public class lt863distanceK {


    class SolutionGraphBFS {
        /*
        build graph: 建立无向图，然后BFS找所有距离为k的node，注意避免重复
        这题还可以用另一种方法, 从root去dfs看target在左还是右，然后按target去往下找，再看root到target的距离，如果距离大于k，那么
        就同一边从root往下找n-k的距离的node，如果k>n那么去另一边找k-n-1的node, 没写出来抄了huahua的
        */
        HashMap<TreeNode, List<TreeNode>> map;
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            map = new HashMap<>();
            buildGraph(root, null);
            HashSet<TreeNode> visited = new HashSet<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(target);
            int steps = 0;
            List<Integer> res = new ArrayList<>();
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    TreeNode node = queue.poll();
                    if(steps == K){
                        res.add(node.val);
                    }
                    for(TreeNode next : map.getOrDefault(node, new ArrayList<>())){
                        if(!visited.contains(next)){
                            queue.add(next);
                        }
                    }
                    visited.add(node);
                }
                steps++;
            }
            return res;
        }

        private void buildGraph(TreeNode node, TreeNode parent){
            if(node == null){
                return;
            }
            if(parent != null){
                List<TreeNode> plist = map.getOrDefault(parent, new ArrayList<>());
                List<TreeNode> clist = map.getOrDefault(node, new ArrayList<>());
                plist.add(node);
                clist.add(parent);
                map.put(parent, plist);
                map.put(node, clist);
            }
            buildGraph(node.left, node);
            buildGraph(node.right, node);
        }

    }

    class SolutionRecursion {

        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

            List<Integer> res = new ArrayList<>();
            dfs(root, target, res, K);


            return res;
        }

        private int dfs(TreeNode root, TreeNode target, List<Integer> res, int k){
            if(root == null){
                return -1;
            }
            if(root == target){
                collect(target, res, k);
                return 0;
            }
            int l = dfs(root.left, target, res, k);
            int r = dfs(root.right, target, res, k);
            if(l >= 0){
                if(l == k - 1){
                    res.add(root.val);
                }
                collect(root.right, res, k - l - 2);
                return l + 1;
            }
            if(r >= 0){
                if(r == k - 1){
                    res.add(root.val);
                }
                collect(root.left, res, k - r - 2);
                return r + 1;
            }
            return -1;
        }

        private void collect(TreeNode root, List<Integer> res, int k){
            if(root == null || k < 0){
                return;
            }
            if(k == 0){
                res.add(root.val);
                return;
            }
            collect(root.left, res, k - 1);
            collect(root.right, res, k - 1);
        }
    }
}
