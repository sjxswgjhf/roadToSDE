package microsoft;

public class addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carryOne = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null || l2 != null){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carryOne;
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;
            carryOne = sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(carryOne != 0){
            dummy.next = new ListNode(carryOne);
        }
        return head.next;
    }
}
