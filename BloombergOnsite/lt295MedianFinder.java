package BloombergOnsite;

import java.util.PriorityQueue;

public class lt295MedianFinder {
    class MedianFinder {
        //two heaps
        PriorityQueue<Integer> frontpq;
        PriorityQueue<Integer> backpq;
        boolean even;
        /** initialize your data structure here. */
        public MedianFinder() {
            frontpq = new PriorityQueue<>((a,b)->b-a);
            backpq = new PriorityQueue<>();
            even = true;
        }

        /*
        用了两个heap，一个是较小的那半部分，一个是较大的那半部分，然后小的是从大到小排列，大的是从小达到排列，
        然后保持着，如果input是偶数，那么平分，如果是奇数，前半部分会比后半部分多一个
        1.当前不是even，进来了变成even，我们看这个数是不是小于前面的最大数，
        1.1是的话，前半部分丢出最大加到后面，再加入input
        1.2不是的话，直接加入后半部分，前后等长了
        2.当前是even，进来变成了odd的length
        2.1当前input是不是小于后半部分最小的，是的话直接加入前半部分
        2.2不是的话，先把后半部分最小的拿出来加入前面，再把input加入后半部分。
        遵照这个逻辑，前半部分在偶数的input len下，跟后面等下，奇数的情况下，比后半部分多一个
        然后第一个input要特殊处理下
        */
        public void addNum(int num) {
            //start case
            if(frontpq.isEmpty()){
                frontpq.add(num);
                even = !even;
                return;
            }
            if(!even){
                if(num <= frontpq.peek()){
                    backpq.add(frontpq.poll());
                    frontpq.add(num);
                }else{
                    backpq.add(num);
                }
            }else{
                if(num <= backpq.peek()){
                    frontpq.add(num);
                }else{
                    frontpq.add(backpq.poll());
                    backpq.add(num);
                }
            }
            even = !even;
        }

        public double findMedian() {
            if(even){
                double v1 = frontpq.peek();
                double v2 = backpq.peek();
                return (v1 + v2) / 2;
            }else{
                return frontpq.peek();
            }
        }
    }
}
