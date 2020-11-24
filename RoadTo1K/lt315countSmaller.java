package RoadTo1K;

import java.util.*;

public class lt315countSmaller {



    class SolutionBIT {
        /*
        这题还可以用Fenwick Tree来实现，即Binary Index Tree。
        首先我们需要sort input之后，知道每个sorted num对应的rank，这里我们从n个input -> k个unqiue sorted num
        */
        private int lowbit(int x) { return x & (-x); }

        class FenwickTree {
            private int[] sums;

            public FenwickTree(int n) {
                sums = new int[n + 1];
            }

            public void update(int i, int delta) {
                while (i < sums.length) {
                    sums[i] += delta;
                    i += lowbit(i);
                }
            }

            public int query(int i) {
                int sum = 0;
                while (i > 0) {
                    sum += sums[i];
                    i -= lowbit(i);
                }
                return sum;
            }
        };

        public List<Integer> countSmaller(int[] nums) {
            int[] sorted = Arrays.copyOf(nums, nums.length);
            Arrays.sort(sorted);
            HashMap<Integer, Integer> ranks = new HashMap<>();
            int rank = 0;
            for (int i = 0; i < sorted.length; ++i)
                if (i == 0 || sorted[i] != sorted[i - 1])
                    ranks.put(sorted[i], ++rank);

            FenwickTree tree = new FenwickTree(ranks.size());
            List<Integer> ans = new ArrayList<Integer>();
            for (int i = nums.length - 1; i >= 0; --i) {
                int sum = tree.query(ranks.get(nums[i]) - 1);
                ans.add(tree.query(ranks.get(nums[i]) - 1));
                tree.update(ranks.get(nums[i]), 1);
            }
            Collections.reverse(ans);
            return ans;
        }

    }

    class SolutionBST {
    /*
    从后往前构建BST，同时记录当前leftcount跟self count
    insert左右的时候需要考虑情况
    time complexity: average O(nlogn), worst O(n^2)
    */

        class BSTNode{
            int val;
            int count;
            int leftCount;
            BSTNode left, right;
            public BSTNode(int val){
                this.val = val;
                this.count = 1;
                this.leftCount = 0;
                this.left = null;
                this.right = null;
            }

            public int count_less_equal(){
                return count + leftCount;
            }
        }

        /*
        这个method做两件事情，一是找当前num的位置，如果发现存在了就增加selfcount，如果没找到，就建立新的bstnode，
        还有就是需要返回比这个num小的所有的node的count
        */
        private int insertNode(BSTNode root, int num){
            if(root.val == num){
                root.count++;
                return root.leftCount;
            }
            //left side
            else if(root.val > num){
                //先增长当前root的leftcount
                root.leftCount++;
                //然后看左边还有没有了
                if(root.left == null){
                    root.left = new BSTNode(num);
                    return 0;
                }
                //还有,就塞进左边subtree
                return insertNode(root.left, num);
            }else{
                if(root.right == null){
                    //塞入右边，root的leftCount
                    root.right = new BSTNode(num);
                    return root.count_less_equal();
                }
            /*
            这里为什么要这样呢，因为对于先前的left的情况，我们只返回了左边的leftcount，如果我们有一个node是先去右边，再去左边的话，我们只返回了0，这样不对的，因为root也比他小
            需要带上root那边的count
            塞入2的话我们要返回2,即1的(count: 1) + (leftcount: 1) = 2,但是我们前面handle了leftnode的return值是只返回了0，因为4的left是null,同理4的right也是null，加入
            5的时候需要带着root的情况，当然这是recursion的做法，如果用while loop的做法，可以直接更新node里面的count然后用临时变量携带所有的leftcount最后返回
            1
           / \
          0   4
             / \
            2   5
            */
                return root.count_less_equal() + insertNode(root.right, num);
            }
        }

        public List<Integer> countSmaller(int[] nums) {
            List<Integer> res = new ArrayList<>();
            if(nums == null || nums.length == 0){
                return res;
            }
            int n = nums.length;
            BSTNode root = new BSTNode(nums[n-1]);
            res.add(0);
            for(int i = n - 2; i >= 0; i--){
                res.add(0, insertNode(root, nums[i]));
            }
            // Collections.reverseOrder(res);
            return res;
        }
    }
}
