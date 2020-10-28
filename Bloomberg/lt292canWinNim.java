package Bloomberg;

public class lt292canWinNim {

    class Solution {
        /*
        n=4给提示了，一次只能拿1~3个石头，也就是说两个人不管另一个人怎么拿石头，都可以把每轮拿掉的石头数量变成4，
        那么如果石头是4的整倍数的话，对手永远可以拿到最后一个，只有被4除有余数，那么第一个人才可以赢
        */
        public boolean canWinNim(int n) {
            return n % 4 == 0 ? false : true;
        }
    }
}
