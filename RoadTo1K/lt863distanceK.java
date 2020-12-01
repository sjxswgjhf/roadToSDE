package RoadTo1K;

import java.util.*;

public class lt863distanceK {

    class Solution {
        /*
        建立无向图，然后BFS
        */
        HashMap<TreeNode, List<TreeNode>> map;
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            map = new HashMap<>();
            buildgraph(root, null);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(target);
            HashSet<TreeNode> visited = new HashSet<>();
            int distance = 0;
            List<Integer> res = new ArrayList<>();
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    TreeNode node = queue.poll();
                    if(distance == K){
                        res.add(node.val);
                    }
                    visited.add(node);
                    List<TreeNode> children = map.getOrDefault(node, new ArrayList<>());
                    for(TreeNode child : children){
                        if(!visited.contains(child)){
                            queue.add(child);
                        }
                    }
                }
                distance++;
            }
            return res;
        }

        private void buildgraph(TreeNode root, TreeNode parent){
            if(root == null){
                return;
            }
            if(parent != null){
                List<TreeNode> plist = map.getOrDefault(parent, new ArrayList<>());
                plist.add(root);
                map.put(parent, plist);
                List<TreeNode> clist = map.getOrDefault(root, new ArrayList<>());
                clist.add(parent);
                map.put(root, clist);
            }
            buildgraph(root.left, root);
            buildgraph(root.right, root);
        }
    }
}
