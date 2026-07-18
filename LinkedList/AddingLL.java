

public class AddingLL {
   public class ListNode {
      int val;
     ListNode next;
     ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
      public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode result  = new ListNode();
        ListNode head = result ; 

        int carry = 0 ;

        while(l1 != null || l2 != null){
            int num1 = 0 ;
            int num2 = 0 ;

            if(l1 != null){
                num1 = l1.val ;
                l1 = l1.next ;
            }

            if(l2 != null){
                num2 = l2.val ;
                l2 = l2.next ;
            }

            int sum = num1 + num2 + carry;
            carry = sum/10;
            head.next = new ListNode(sum%10);
            head = head.next;
            
            if(l1 == null && l2 == null)break;
        }

        if(carry != 0){
            head.next = new ListNode(carry);
        }

        return result.next ;
    }
}
