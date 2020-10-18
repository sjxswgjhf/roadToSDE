package IMC;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class CustomStack {

    /*
     * Complete the function below.
     */

    // static void superStack(String[] operations) {
    //     List<Long> stack = new ArrayList<>();
    //     int maxSize = 20000;
    //     for(int i = 0 ; i < operations.length; i++){
    //         String operation = operations[i];
    //         String[] commends = operation.split(" ");
    //         String commend = commends[0];
    //         long top;
    //         int val;
    //         if(commend.equals("push")){
    //             val = Integer.valueOf(commends[1]);
    //             stack.add((long)val);
    //             System.out.println(stack.get(ststackk.size() - 1));
    //         }
    //         if(commend.equals("pop")){
    //             if(stack.isEmpty()){
    //                 System.out.println("EMPTY");
    //             }else{
    //                 stk.remove(stack.size() - 1);
    //                 if(stack.isEmpty()){
    //                     System.out.println("EMPTY");
    //                 }else{
    //                     System.out.println(stack.get(stack.size() - 1));
    //                 }
    //             }
    //         }
    //         if(commend.equals("inc")){
    //             int k = Integer.valueOf(commends[1]);
    //             val = Integer.valueOf(commends[2]);
    //             for(int j = 0; j < k && j < stack.size(); j++){
    //                 stack.set(j, stack.get(j)+val);
    //             }
    //             System.out.println(stack.get(stack.size() - 1));
    //         }
    //     }
    // }

    static void superStack(String[] operations) {
        Stack<Long> stack = new Stack<>();
        int maxSize = 20000;
        Long[] inc = new Long[2000];
        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i];
            String[] commends = operation.split(" ");
            String commend = commends[0];
            long top;
            long val;
            if (commend.equals("push")) {
                val = Long.valueOf(commends[1]);
                push(val, stack, maxSize);
                System.out.println(stack.peek());
            }
            if (commend.equals("pop")) {
                top = pop(stack, inc);
                if (stack.isEmpty()) {
                    System.out.println("EMPTY");
                } else {
                    System.out.println(top);
                }
            }
            if (commend.equals("inc")) {
                int k = Integer.valueOf(commends[1]);
                val = Long.valueOf(commends[2]);
                top = increment(stack, inc, k, val);
                System.out.println(top);
            }
        }
    }

    private static Long increment(Stack<Long> stack, Long[] inc, int k, Long val) {
        int i = Math.min(k, stack.size()) - 1;
        if (i >= 0) {
            inc[i] = inc[i] + val;
        }
        return stack.peek() + inc[stack.size() - 1];
    }

    private static Long pop(Stack<Long> stack, Long[] inc) {
        int idx = stack.size() - 1;
        if (idx < 0) {
            return Long.MIN_VALUE;
        }
        if (idx > 0) {
            inc[idx - 1] += inc[idx];
        }
        stack.pop();
        long res = stack.isEmpty() ? Long.MIN_VALUE : stack.peek() + inc[idx - 1];
        inc[idx] = (long) 0;
        return res;
    }

    private static void push(Long val, Stack<Long> stack, int maxSize) {
        if (stack.size() < maxSize) {
            stack.push((long) val);
        }
    }
}