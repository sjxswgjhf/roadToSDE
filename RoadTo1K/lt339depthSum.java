package RoadTo1K;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lt339depthSum {

      // This is the interface that allows for creating nested lists.
      // You should not implement it, or speculate about its implementation
      public class NestedInteger {
          // Constructor initializes an empty nested list.
          public NestedInteger(){}

          // Constructor initializes a single integer.
          public NestedInteger(int value){}

          // @return true if this NestedInteger holds a single integer, rather than a nested list.
          public boolean isInteger(){
              return true;
          }

          // @return the single integer that this NestedInteger holds, if it holds a single integer
          // Return null if this NestedInteger holds a nested list
          public Integer getInteger(){
              return 1;
          }

          // Set this NestedInteger to hold a single integer.
          public void setInteger(int value){}

          // Set this NestedInteger to hold a nested list and adds a nested integer to it.
          public void add(NestedInteger ni){}

          // @return the nested list that this NestedInteger holds, if it holds a nested list
          // Return null if this NestedInteger holds a single integer
          public List<NestedInteger> getList(){
              return new ArrayList<>();
          }
      }


    class Solution {

        /*
        一个[]是一层，那么我们逐层遍历，其实有两种，一种是直接处理了[[[[]]]这样的情况，计算结果累积，另一种是一层层的处理把里面层重新塞入queue
        */
        public int depthSum(List<NestedInteger> nestedList) {
            if(nestedList == null){
                return 0;
            }

            int sum = 0;
            int level = 1;

            Queue<NestedInteger> queue = new LinkedList<NestedInteger>(nestedList);
            while(queue.size() > 0){
                int size = queue.size();

                for(int i = 0; i < size; i++){
                    NestedInteger ni = queue.poll();

                    if(ni.isInteger()){
                        sum += ni.getInteger() * level;
                    }else{
                        queue.addAll(ni.getList());
                    }
                }

                level++;
            }

            return sum;
        }
    }
}
