package dataStructure;

public class FenwickTree {

    /*
        also called binary indexed tree
        FenwickTree的least significant bit表示了当前覆盖的范围，001表示覆盖了当前自己，010表示覆盖了2个，自己跟小于自己的那个，
        100表示覆盖了4个，以此类推,通过binary idx的特性来实现，所以也叫binary indexed tree

     */
    int[] sums;
    public FenwickTree(int n){
        sums = new int[n + 1];
    }

    public FenwickTree(int[] values){
        this.sums = values.clone();
        for(int i = 1; i < sums.length; i++){
            int j = i + lowbit(i);
            if(j < sums.length){
                sums[j] += sums[i];
            }
        }
    }

    public void update(int i, int delta){
        while(i < sums.length){
            sums[i] += delta;
            i += lowbit(i);
        }
    }

    public int query(int i ){
        int sum = 0;
        while(i > 0){
            sum += sums[i];
            i -= lowbit(i);
        }
        return sum;
    }

    /*
    lsb: 正负数的bit representation中只有最后一位的1是一样的
    8 = 0000 0100
    -8 =1111 1100
    所以and之后 8 & -8 = 0000 0100 lsb也就是100最快速的找lsb的方法

     */
    public int lowbit(int x){
        return (x & (-x));
    }

    public static void main(String[] args) {
        int i = 123;
        String binString = Integer.toBinaryString(i);
        System.out.println(binString);
        int j = -123;
        binString = Integer.toBinaryString(j);
        System.out.println(binString);
        System.out.println(Integer.toBinaryString(i&j));
    }
}
