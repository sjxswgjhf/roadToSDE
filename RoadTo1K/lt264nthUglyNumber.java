package RoadTo1K;

import java.util.HashSet;
import java.util.PriorityQueue;

public class lt264nthUglyNumber {

    class Solution {
        /*
        只能被2 3 5 整除
        即2 3 5 网上乘

        1 2 3 5 4 6 10
        所以需要排序,并且还要避免重复

        做个做法的缺点是我们加入了大量的不必要大的数字，
        所以insert浪费了时间，
        我们要优化的话尽可能的避免加入大的数字，

        思考如何生成一个丑数，巧好是最小的新的丑数，我们就需要排列了。
        对于任意一个丑数，都是由之前的丑数*2，*3，*5得到的
        大佬的说法：
        假设我们有abc三个丑数，对应他们的a*2,b*3,c*5，如果a*2最小，我们放入队列是ok的，那么如果下一个丑数是由a*2得到的呢，即d*2，我们怎么求得呢，
        我们需要当前对应a的指针在哪了，就可以知道下一个丑数，同理，我们也需要b，c的指针，
        然后每次都是比较对应指针指的数乘对应的2，3，5，取最小的那个，并增长指针，这样就可以形成轮流交替的增长，但是每次都是最小的
        我的理解:
        对于每个数，我们都需要乘2 3 5，
        如果*2是最小的，放入了，看下一位，3跟5还没乘，我们不能移动3跟5的指针，
        只有完成了当前数的乘法，我们才能移动对应的指针，这样，我们每次都能比较三个数，这三个数是潜在的最小的可能，取最小的并移动指针，因为我们完成了那个乘法

        1 出发 * 2 3 5 三个数 取 2， 现在idx2 = 1， idx3 跟 idx5 还是0
        得：
        2   那对应的下一位数是 2 * 2， 1 * 3, 1 * 5
        我们只取4


        */
        public int nthUglyNumber(int n) {
            if(n == 1){
                return 1;
            }
            int[] dp = new int[n];
            dp[0] = 1;
            //*2的指针指向的数
            int idx2 = 0;

            //*3的指针指向的数
            int idx3 = 0;

            //*5的指针指向的数
            int idx5 = 0;
            //什么时候才能移动当前的指针呢，只有当我们完成了这个数的2，3，5对应的倍数计算，我们才移动到下一个数
            for(int i = 1; i < n; i++){
                int next2 = dp[idx2] * 2;
                int next3 = dp[idx3] * 3;
                int next5 = dp[idx5] * 5;
                int next = Math.min(next2, Math.min(next3, next5));
                //看取了*2还是*3还是*5，取了哪个，表示对应指的那个数乘的指针的倍数计算完了，我们移动到下一位数
                if(next == next2){
                    dp[i] = next;
                    idx2++;
                }
                if(next == next3){
                    dp[i] = next;
                    idx3++;
                }
                if(next == next5){
                    dp[i] = next;
                    idx5++;
                }
            }
            return dp[n - 1];
        }
    }

    class SolutionNLOGN {
        /*
        只能被2 3 5 整除
        即2 3 5 网上乘

        1 2 3 5 4 6 10
        所以需要排序,并且还要避免重复

        */
        public int nthUglyNumber(int n) {
            if(n == 1){
                return 1;
            }
            long num = 1;
            PriorityQueue<Long> pq = new PriorityQueue<>();
            HashSet<Long> visited = new HashSet<>();
            pq.add(num);
            visited.add(num);
            for(int i = 0; i < n; i++){
                num = pq.poll();
                if(!visited.contains(num * 2)){
                    pq.add(num * 2);
                    visited.add(num * 2);
                }
                if(!visited.contains(num * 3)){
                    pq.add(num * 3);
                    visited.add(num * 3);
                }
                if(!visited.contains(num * 5)){
                    pq.add(num * 5);
                    visited.add(num * 5);
                }
            }
            return (int)num;
        }
    }
}
