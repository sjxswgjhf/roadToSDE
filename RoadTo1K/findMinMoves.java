package RoadTo1K;

public class findMinMoves {
    class Solution {
        /*
        超级洗衣机，把这个input想成是山峰跟低地组合在一起，我们要找一条水平线，使得山峰填了坑，都跟水平线一样
        首先总sum肯定要被整除
        那么对于每个idx有两种状态，一种是输出，一种是输入。输出的话有分向左输出跟向有输出，输入的话也是左右，
        但是我们可以合起来，用正负区分输入输出
        左右输入输出最后的总和肯定是 machines[i] - k 水平线的差值
        left[i] + right[i] = machines[i] - k
        然后我们找left跟right的关系，我们直到i的右输入等于i+1左输出,但是正负相反
        right[i] = -left[i+1]
        left[i] = -right[i-1]

        */
        public int findMinMoves(int[] machines) {
            int n = machines.length;
            int sum = 0;
            for(int m : machines){
                sum += m;
            }
            if(sum % n != 0){
                return -1;
            }
            int k = sum / n;
            int[] left = new int[n];
            int[] right = new int[n];
            left[0] = 0;    //最左边的没有左边输入输出
            right[0] = machines[0] - k; //最右边的右输入/输出等于衣服-k
            right[n-1] = 0;   //最右边的没有右边的输入输出
            left[n-1] = machines[n-1] - k;  //最右边的左输出/输入是衣服-k
            for(int i = 1; i < n - 1; i++){
                left[i] = -right[i-1];  //i left = i-1 right
                right[i] = machines[i] - k - left[i];   //left[i] + right[i] = machiens[i] - k
            }
            int res = 0;
        /*
        这里为什么要这样做，因为我们要看的是净输出多少，就算是最高的山峰也有可能会有净输入，
        例如 0 0 11 5, 5要把衣服给11，11再给0 0 ，虽然11有净收入，但是11的步数是要看输出了多少次，
        11要输出8次，这起码要8步才行,即如果有净收入为负的话，会减少净输出的次数，这是不对的
        */
            for(int i = 0; i < n; i++){
                int t = 0;
                if(left[i] > 0){
                    t += left[i];
                }
                if(right[i] > 0){
                    t += right[i];
                }
                res = Math.max(res, left[i] + right[i]);
            }
            return res;
        }
    }
}
/*
直到sum跟size，我就知道每个洗衣机的要多少了

:minimum number of moves to make all the washing machines have the same number of dresses

[1,0,5]

left[i]: 向左给,负数表示得到
right[i]: 向右给,负数表示得到

left + right = machines[i] - k
right[i] = -left[i+1] i的向右输出等于i+1的左边的输入
left[0] = 0
洗衣机的每次的东西
净输出1:
净输出0:
净输入1/2(左右各给我一件):
把高的山拿去填海，只用看净输出，因为输入可以是1或者2，不可控，但是输出一直是1
*/