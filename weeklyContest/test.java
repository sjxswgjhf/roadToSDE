package weeklyContest;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class test {

        public static void main(String args[] ) throws Exception {
            /* Use your class here */
            MyStack<Integer> stack = new MyStack<>();
            stack.push(1);
            stack.push(2);
            stack.push(3);
            // size = 3
            System.out.println(stack.Size());
            // false
            System.out.println(stack.isEmpty());
            stack.push(4);
            stack.push(5);
            //size = 5
            System.out.println(stack.Size());
            //5
            System.out.println(stack.pop());
            //4
            System.out.println(stack.pop());
            //3
            System.out.println(stack.pop());
            //size = 2
            System.out.println(stack.Size());
            //2
            System.out.println(stack.pop());
            //1
            System.out.println(stack.pop());
            //size = 0
            System.out.println(stack.Size());
            //empty stack
            System.out.println(stack.isEmpty());
            //keep pop get null and output
            System.out.println(stack.pop());
        }
    }

    /* Define your class here */
    class MyStack<E>{
        private int size = 0;
        private int capacity = 3;
        private Object datas[];

        public MyStack(){
            datas = new Object[capacity];
        }

        //push item into array, if the capacity is no enough, increase capacity first then add into array
        public void push(E e){
            if(datas.length == capacity){
                increaseCapacity();
            }
            datas[size] = e;
            size++;
        }

        //get the data from the array and set that idx to be null
        //if there is no data in stack, output the Stack is Empty and return null instead of throw EmptyStackException
        public E pop(){
            if(size == 0){
                System.out.println("Stack is Empty!");
                System.exit(0);
                return null;

            }

            E e = (E)datas[size-1];
            datas[size-1]=null;
            size--;
            return e;
        }

        //create a new empty array with capacity * 2, then copy the data from old array to the new array, change the capacity value
        //set the array to the new array
        private void increaseCapacity(){
            Object[] tmp = new Object[capacity * 2];
            for(int i = 0 ; i < capacity; i++){
                tmp[i] = datas[i];
            }
            this.capacity = capacity * 2;
            this.datas = tmp;
        }

        //get the size of the array = total elements in the array
        public int Size(){
            return this.size;
        }

        //check the size of array is zero or not, if zeor means empty
        public boolean isEmpty(){
            return this.size == 0;
        }

    }
