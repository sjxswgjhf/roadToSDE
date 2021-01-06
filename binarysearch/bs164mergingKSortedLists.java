package binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class bs164mergingKSortedLists {

    class Solution {
        class Node{
            int idx;
            int len;
            int[] nums;
            public Node(int idx, int[] nums){
                this.idx = idx;
                this.nums = nums;
                this.len = nums.length;
            }
        }
        public int[] solve(int[][] lists) {
            List<Integer> res = new ArrayList<>();
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b)->(a.nums[a.idx] - b.nums[b.idx]));
            for(int[] nums : lists){
                if(nums.length > 0)
                    pq.add(new Node(0, nums));
            }
            while(!pq.isEmpty()){
                Node node = pq.poll();
                res.add(node.nums[node.idx]);
                node.idx++;
                if(node.idx < node.len){
                    pq.add(node);
                }
            }
            int[] ans = new int[res.size()];
            int idx = 0;
            for(int num : res){
                ans[idx++] = num;
            }
            return ans;
        }
    }
}
